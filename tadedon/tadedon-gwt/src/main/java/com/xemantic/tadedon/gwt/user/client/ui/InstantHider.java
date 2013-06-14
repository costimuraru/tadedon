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
package com.xemantic.tadedon.gwt.user.client.ui;

import javax.inject.Singleton;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;
import com.xemantic.tadedon.gwt.user.client.Doer;
import com.xemantic.tadedon.gwt.user.client.InstantDoer;

/**
 * Produces {@link Doer}s which instantly hide UI elements.
 * <p>
 * Created on Jun 12, 2013
 *
 * @author morisil
 */
@Singleton
public class InstantHider extends AbstractUiDoer {

  /** {@inheritDoc} */
  @Override
  public Doer on(final Element element) {
    return new InstantDoer() {
      @Override
      public void go() {
        UIObject.setVisible(element, false);
      }
    };
  }

}
