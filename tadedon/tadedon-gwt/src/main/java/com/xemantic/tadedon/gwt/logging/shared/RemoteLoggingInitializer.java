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
package com.xemantic.tadedon.gwt.logging.shared;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.logging.client.LogConfiguration;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryLogHandler;

/**
 * Initializer of remote logging, typically in the beginning of your entry
 * point.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
@Singleton
public class RemoteLoggingInitializer {

  private final LoggingUncaughtExceptionHandler exceptionHandler;

  private final RequestFactoryLogHandler requestFactoryLogHandler;


  /**
   * Creates remote logging initializer instance with injected dependencies.
   *
   * @param exceptionHandler the exception handler.
   * @param requestFactoryLogHandler the request factory log handler.
   */
  @Inject
  public RemoteLoggingInitializer(
      LoggingUncaughtExceptionHandler exceptionHandler,
      RequestFactoryLogHandler requestFactoryLogHandler) {

    this.exceptionHandler = exceptionHandler;
    this.requestFactoryLogHandler = requestFactoryLogHandler;
  }

  /**
   * Initializes the remote logging.
   */
  public void initialize() {
    if (!LogConfiguration.loggingIsEnabled()) {
      throw new AssertionError("Logging is not enabled");
    }
    GWT.setUncaughtExceptionHandler(exceptionHandler);
    Logger.getLogger("").addHandler(requestFactoryLogHandler);
  }

}
