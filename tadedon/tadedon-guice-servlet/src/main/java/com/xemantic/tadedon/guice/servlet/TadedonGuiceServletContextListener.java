/*
 * Copyright 2013 Xemantic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xemantic.tadedon.guice.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;
import com.google.inject.ConfigurationException;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.servlet.GuiceServletContextListener;
import com.xemantic.tadedon.guice.lifecycle.LifecycleManager;
import com.xemantic.tadedon.guice.lifecycle.jsr250.Jsr250LifecycleModule;

/**
 * The instance of {@link GuiceServletContextListener} which support component
 * lifecycle.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 * @see LifecycleManager
 * @see Jsr250LifecycleModule
 */
public abstract class TadedonGuiceServletContextListener
    extends GuiceServletContextListener {

  private Stage stage;

  private LifecycleManager lifecycleManager;

  private Logger logger;


  /** {@inheritDoc} */
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    logger = LoggerFactory.getLogger(getClass());
    ServletContext ctx = servletContextEvent.getServletContext();
    stage = GuiceServlets.getStage(servletContextEvent.getServletContext());
    logger.info("Starting webapp in stage: {}", stage);
    try {
      // it will call creation of injector which could throw exceptions
      super.contextInitialized(servletContextEvent);
    } catch (Throwable t) {
      // servlet container can eat the exception, we want to know what's going on
      logger.error("Cannot start the webapp", t);
      Throwables.propagate(t);
    }

    Injector injector = (Injector) ctx.getAttribute(Injector.class.getName());
    try {
      lifecycleManager = injector.getInstance(LifecycleManager.class);
    } catch (ConfigurationException e) {
      logger.error(
          "The LifecycleManager cannot be obtained, " +
          "make sure the Jsr250LifecycleModule is added to the project", e);
      Throwables.propagate(e);
    }
    try {
      lifecycleManager.initialize();
    } catch (Throwable t) {
      // servlet container can eat the exception, we want to know what's going on
      logger.error("Cannot initialize the webapp", t);
      // trying to stop components which are already started
      onDestroy();
      Throwables.propagate(t);
    }
  }

  /** {@inheritDoc} */
  @Override
  protected Injector getInjector() {
    return getInjector(stage);
  }

  /**
   * Override this method to create (or otherwise obtain a reference to) your
   * injector. The {@code stage} parameter is retrieved from the {@code web.xml}
   * file see {@link GuiceServlets#getStage(ServletContext)} for details.
   *
   * @param stage the application stage.
   * @return the injector.
   */
  protected abstract Injector getInjector(Stage stage);


  /** {@inheritDoc} */
  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    if (lifecycleManager != null) {
      onDestroy();
    }
  }

  private void onDestroy() {
    try {
      lifecycleManager.destroy();
    } catch (Throwable t) {
      // servlet container can eat the exception, we want to know what's going on
      logger.error("Cannot destroy the webapp", t);
      Throwables.propagate(t);
    }
  }

}
