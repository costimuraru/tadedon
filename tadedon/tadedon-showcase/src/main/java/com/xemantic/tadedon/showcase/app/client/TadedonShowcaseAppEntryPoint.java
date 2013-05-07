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
package com.xemantic.tadedon.showcase.app.client;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.GinModule;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.name.Names;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.xemantic.tadedon.gwt.logging.client.AlertUncaughtExceptionHandler;
import com.xemantic.tadedon.gwt.logging.client.RemoteLoggingGinModule;
import com.xemantic.tadedon.gwt.logging.shared.RemoteLoggingInitializer;

/**
 * Entry point of the Tadedon Showcase Application. It also implements
 * {@link GinModule} to aggregate all the configuration, component wiring and
 * initialization in single point.
 * <p>
 * Created on May 1, 2013
 *
 * @author morisil
 */
public class TadedonShowcaseAppEntryPoint extends AbstractGinModule
    implements EntryPoint {


  /*
   * Injected initialization services
   */

  /** initializer of remote logging */
  @Inject RemoteLoggingInitializer remoteLoggingInitializer;

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    install(new RemoteLoggingGinModule());
    bind(GWT.UncaughtExceptionHandler.class)
      .annotatedWith(Names.named("additionalUncaughtExceptionHandler"))
      .to(AlertUncaughtExceptionHandler.class);
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
  }

  /** {@inheritDoc} */
  @Override
  public void onModuleLoad() {
    ((AppGinjector) GWT.create(AppGinjector.class))
      .getEntryPoint().initialize();
  }

  private void initialize() {
    remoteLoggingInitializer.initialize();

    Button button = new Button();
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        throw new RuntimeException("test");
      }
    });
    RootPanel.get().add(button);
  }


  /**
   * Ginjector of this application.
   */
  @GinModules(TadedonShowcaseAppEntryPoint.class)
  public interface AppGinjector extends Ginjector {

    /**
     * Returns GIN created instance of this entry point.
     *
     * @return the entry point.
     */
    TadedonShowcaseAppEntryPoint getEntryPoint();

  }

}
