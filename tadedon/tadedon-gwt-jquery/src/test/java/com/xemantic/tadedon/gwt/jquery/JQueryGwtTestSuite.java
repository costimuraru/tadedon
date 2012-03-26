/*
 * Copyright 2012 Xemantic
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
package com.xemantic.tadedon.gwt.jquery;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.junit.tools.GWTTestSuite;
import com.xemantic.tadedon.gwt.jquery.client.JQueryGwtTest;

/**
 * Test suite for JQuery module.
 * <p>
 * Created on Mar 22, 2012
 *
 * @author morisil
 */
public class JQueryGwtTestSuite extends GWTTestSuite {

  /**
   * Creates test suite that contains {@link GWTTestCase}s.
   *
   * @return the test suite.
   */
  public static Test suite() {
    TestSuite suite = new JQueryGwtTestSuite();
    suite.addTestSuite(JQueryGwtTest.class);
    return suite;
  }

}
