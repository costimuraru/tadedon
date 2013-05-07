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
package com.xemantic.tadedon.gwt.logging.client;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.inject.Singleton;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryLogHandler;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryLogHandler.LoggingRequestProvider;
import com.google.web.bindery.requestfactory.shared.LoggingRequest;
import com.xemantic.tadedon.gwt.logging.client.i18n.LoggingConstants;
import com.xemantic.tadedon.gwt.logging.shared.RemoteLoggingRequestFactory;
import com.xemantic.tadedon.gwt.logging.shared.RemoteLoggingRequestTransport;

/**
 * GIN module which configures remote logging of exceptions.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
public class RemoteLoggingGinModule extends AbstractGinModule {

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    bind(LoggingConstants.class).in(Singleton.class);
  }

  /**
   * Returns {@link RequestFactoryLogHandler} instance with given dependencies.
   * It will ignore {@link RemoteLoggingRequestTransport} logs thus avoiding
   * loop of logs being reported remotely to the server. Only logs with level
   * {@link Level#WARNING} and above are logged remotely.
   *
   * @param provider the {@link LoggingRequestProvider}.
   * @return the log handler.
   */
  @Provides
  RequestFactoryLogHandler getRequestFactoryLogHandler(
      LoggingRequestProvider provider) {

    List<String> ignoredLoggers = new ArrayList<String>();
    ignoredLoggers.add(RemoteLoggingRequestTransport.LOGGER_NAME);
    return new RequestFactoryLogHandler(
        provider, Level.WARNING, ignoredLoggers);
  }

  /**
   * Returns logging request provider.
   *
   * @param factory the logging request factory.
   * @return the logging request provider.
   */
  @Provides
  @Singleton
  LoggingRequestProvider getLoggingRequestProvider(
      final RemoteLoggingRequestFactory factory) {

    return new LoggingRequestProvider() {
      @Override
      public LoggingRequest getLoggingRequest() {
        return factory.newLoggingRequest();
      }
    };
  }

  /**
   * Returns initialized instance of {@link RemoteLoggingRequestFactory} for
   * given dependencies.
   *
   * @param eventBus the event bus.
   * @return the factory.
   */
  @Provides
  @Singleton
  RemoteLoggingRequestFactory getRemoteLoggingRequestFactory(
      EventBus eventBus) {

    RemoteLoggingRequestFactory factory =
        GWT.create(RemoteLoggingRequestFactory.class);
    factory.initialize(eventBus, new RemoteLoggingRequestTransport());
    return factory;
  }

}
