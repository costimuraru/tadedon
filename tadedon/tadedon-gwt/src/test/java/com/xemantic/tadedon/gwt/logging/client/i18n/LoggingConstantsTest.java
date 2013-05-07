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
package com.xemantic.tadedon.gwt.logging.client.i18n;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.xemantic.tadedon.gwt.logging.client.i18n.LoggingConstants;

/**
 * Integration test for {@link LoggingConstants}.
 * <p>
 * Created on May 6, 2013
 *
 * @author morisil
 */
public class LoggingConstantsTest extends GWTTestCase {

  /** {@inheritDoc} */
  @Override
  public String getModuleName() {
    return "com.xemantic.tadedon.gwt.logging.Logging";
  }

  /**
   * Tests creation of logging messages.
   */
  public void testShouldCreateLocalizedMessage() {
    // given LoggingConstants class

    // when
    LoggingConstants constants = GWT.create(LoggingConstants.class);

    // then
    assertEquals(
        "An unexpected error has occurred. The report was sent to the server.",
        constants.unexpectedError());
  }

}
