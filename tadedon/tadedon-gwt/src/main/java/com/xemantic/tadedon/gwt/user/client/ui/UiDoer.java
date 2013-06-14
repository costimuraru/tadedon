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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import com.xemantic.tadedon.gwt.user.client.Doer;

/**
 * Doer factory creating doers on behalf of specific {@link IsWidget} or
 * {@link Element}. Such a {@link Doer} handles invocation of some asynchronous
 * process related to specific on-screen element. It could be animation of
 * showing or hiding the widget, or the action of scrolling widget into view.
 * <p>
 * Created on Jun 12, 2013
 *
 * @author morisil
 */
public interface UiDoer {

  /**
   * Creates {@link Doer} for given {@code widget}.
   *
   * @param widget the widget.
   * @return the doer.
   */
  Doer on(IsWidget widget);

  /**
   * Creates {@link Doer} for given {@code element}.
   *
   * @param element the element.
   * @return the doer.
   */
  Doer on(Element element);

}
