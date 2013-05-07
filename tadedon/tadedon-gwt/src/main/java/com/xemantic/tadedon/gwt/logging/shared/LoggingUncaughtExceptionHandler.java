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

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.inject.Inject;

/**
 * The {@link UncaughtExceptionHandler} which logs the exception.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
@Singleton
public class LoggingUncaughtExceptionHandler
    implements UncaughtExceptionHandler {

  private static Logger logger = Logger.getLogger("UncaughtClientException");

  private UncaughtExceptionHandler additionalUncaughtExceptionHandler;


  /**
   * Injects optional additional {@link UncaughtExceptionHandler}. If it is
   * present, it will be fired after this one.
   *
   * @param additionalUncaughtExceptionHandler the exception handler.
   */
  @Inject(optional = true)
  public void setUncaughtExceptionHandler(
      @Named("additionalUncaughtExceptionHandler")
      UncaughtExceptionHandler additionalUncaughtExceptionHandler) {

    this.additionalUncaughtExceptionHandler = additionalUncaughtExceptionHandler;
  }

  /** {@inheritDoc} */
  @Override
  public void onUncaughtException(Throwable e) {
    logger.log(Level.SEVERE, e.getMessage(), e);
    if (additionalUncaughtExceptionHandler != null) {
      additionalUncaughtExceptionHandler.onUncaughtException(e);
    }
  }

}
