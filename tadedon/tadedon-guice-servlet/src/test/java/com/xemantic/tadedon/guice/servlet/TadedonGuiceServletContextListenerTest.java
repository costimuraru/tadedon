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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.junit.Test;
import org.springframework.mock.web.MockServletContext;

import com.google.inject.AbstractModule;
import com.google.inject.ConfigurationException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.Stage;
import com.xemantic.tadedon.guice.lifecycle.LifecycleManager;
import com.xemantic.tadedon.guice.lifecycle.jsr250.Jsr250LifecycleModule;

/**
 * Unit test for {@link TadedonGuiceServletContextListener}.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
public class TadedonGuiceServletContextListenerTest {

  /**
   * Tests initialization of {@link TadedonGuiceServletContextListener} when
   * no {@link LifecycleManager} is bound.
   */
  @Test(expected = ConfigurationException.class)
  public void shouldThrowExceptionIfNoLifecycleManagerIsBound() {
    // given
    MockServletContext ctx = new MockServletContext();
    ServletContextEvent event = mock(ServletContextEvent.class);
    given(event.getServletContext()).willReturn(ctx);

    ServletContextListener listener = new TadedonGuiceServletContextListener() {
      @Override
      protected Injector getInjector(Stage stage) {
        return Guice.createInjector(new AbstractModule() {
          @Override
          protected void configure() {
            // nothing to bind - no LifecycleManager
          }
        });
      }
    };

    // when
    listener.contextInitialized(event);

    // then RuntimeException should be thrown
  }

  /**
   * Tests if {@link TadedonGuiceServletContextListener} initializes managed
   * components.
   */
  @Test
  public void shouldInitializeComponentOnStart() {
    // given
    MockServletContext ctx = new MockServletContext();
    ServletContextEvent event = mock(ServletContextEvent.class);
    given(event.getServletContext()).willReturn(ctx);

    ServletContextListener listener = new TadedonGuiceServletContextListener() {
      @Override
      protected Injector getInjector(Stage stage) {
        return Guice.createInjector(
            new Jsr250LifecycleModule(),
            new AbstractModule() {
              @Override
              protected void configure() {
                bind(Component.class).asEagerSingleton();
              }
            });
      }
    };

    // when
    listener.contextInitialized(event);
    Component component =
        ((Injector) ctx.getAttribute(Injector.class.getName()))
          .getInstance(Component.class);

    // then
    assertThat(component.isRunning(), is(true));
  }

  /**
   * Tests if {@link TadedonGuiceServletContextListener} destroys managed
   * components.
   */
  public void shouldDestroyComponentOnShutdown() {
    // given
    MockServletContext ctx = new MockServletContext();
    ServletContextEvent event = mock(ServletContextEvent.class);
    given(event.getServletContext()).willReturn(ctx);

    ServletContextListener listener = new TadedonGuiceServletContextListener() {
      @Override
      protected Injector getInjector(Stage stage) {
        return Guice.createInjector(
            new Jsr250LifecycleModule(),
            new AbstractModule() {
              @Override
              protected void configure() {
                bind(Component.class).asEagerSingleton();
              }
            });
      }
    };

    // when
    listener.contextInitialized(event);
    listener.contextDestroyed(event);
    Component component =
        ((Injector) ctx.getAttribute(Injector.class.getName()))
          .getInstance(Component.class);

    // then
    assertThat(component.isRunning(), is(false));
  }


  /**
   * Test component which could be tested if it has been started or stopped.
   */
  @Singleton
  public static class Component {

    private boolean running = false;


    /**
     * Starts the component.
     */
    @PostConstruct
    public void initialize() {
      running = true;
    }

    /**
     * Stops the component.
     */
    @PreDestroy
    public void destroy() {
      running = false;
    }

    /**
     * Returns {@code running} flag.
     *
     * @return the running.
     */
    public boolean isRunning() {
      return running;
    }

  }

}
