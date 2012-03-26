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
package com.xemantic.tadedon.gwt.jquery.client;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.Label;


/**
 * Test for {@link JQuery}.
 * <p>
 * Created on Mar 22, 2012
 *
 * @author morisil
 */
public class JQueryGwtTest extends GWTTestCase {

  /** {@inheritDoc} */
  @Override
  public String getModuleName() {
    return "com.xemantic.tadedon.gwt.jquery.JQueryTest";
  }

  /** Tests {@link JQuery#fadeIn(com.google.gwt.user.client.ui.UIObject, Duration, Runnable)} */
  public void testShouldFadeInInvisibleWidget() {
    // given
    final Label label = new Label();
    label.setVisible(false);

    // when
    JQuery.fadeIn(label, Duration.FAST, new Runnable() {
      @Override
      public void run() {
        finishTest();
      }
    });
    delayTestFinish(500);

    // then
    assertTrue(label.isVisible());
  }

}
