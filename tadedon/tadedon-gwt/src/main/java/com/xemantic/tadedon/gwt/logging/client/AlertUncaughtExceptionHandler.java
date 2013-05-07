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

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;
import com.xemantic.tadedon.gwt.logging.client.i18n.LoggingConstants;

/**
 * Handler of uncaught exceptions which presents dialog with generic message.
 * <p>
 * Created on May 6, 2013
 *
 * @author morisil
 */
@Singleton
public class AlertUncaughtExceptionHandler implements UncaughtExceptionHandler {

  private final LoggingConstants constants;


  /**
   * Creates exception handler instance with injected dependencies.
   *
   * @param constants the message translations.
   */
  @Inject
  public AlertUncaughtExceptionHandler(LoggingConstants constants) {
    this.constants = constants;
  }

  /** {@inheritDoc} */
  @Override
  public void onUncaughtException(Throwable e) {
    Window.alert(constants.unexpectedError());
  }

}
