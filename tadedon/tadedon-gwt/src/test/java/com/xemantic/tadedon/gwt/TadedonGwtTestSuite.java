/*
 * Copyright 2010,2013 Xemantic
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
package com.xemantic.tadedon.gwt;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.tools.GWTTestSuite;
import com.xemantic.tadedon.gwt.field.client.UiFieldAccessorGeneratorTest;
import com.xemantic.tadedon.gwt.logging.client.i18n.LoggingConstantsTest;

/**
 * GWT Test suite for tadedon-gwt module.
 * <p>
 * Created on Aug 12, 2010
 *
 * @author morisil
 */
public class TadedonGwtTestSuite extends GWTTestSuite {

  /**
   * Creates GWT test suite.
   *
   * @return the test suite.
   */
  public static Test suite() {
    TestSuite suite = new GWTTestSuite(TadedonGwtTestSuite.class.getName());
    suite.addTestSuite(UiFieldAccessorGeneratorTest.class);
    suite.addTestSuite(LoggingConstantsTest.class);
    return suite;
  }

}
