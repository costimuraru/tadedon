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
package com.xemantic.tadedon.gwt.user.client.ui;

import com.google.gwt.user.client.ui.UIObject;

/**
 * Controller of widget's visibility.
 * <p>
 * Created on Mar 30, 2012
 *
 * @author morisil
 */
public interface VisibilityController {

  /**
   * Default visibility controller instance without animation effects.
   */
  public static VisibilityController DEFAULT = new VisibilityController() {

    /** {@inheritDoc} */
    @Override
    public void scrollIntoView(UIObject widget) {
      widget.getElement().scrollIntoView();
    }

    /** {@inheritDoc} */
    @Override
    public void scrollIntoView(UIObject widget, Runnable callback) {
      widget.getElement().scrollIntoView();
      callback.run();
    }

    /** {@inheritDoc} */
    @Override
    public void fadeIn(UIObject widget) {
      widget.setVisible(true);
    }

    /** {@inheritDoc} */
    @Override
    public void fadeIn(UIObject widget, Runnable callback) {
      widget.setVisible(true);
      callback.run();
    }

    /** {@inheritDoc} */
    @Override
    public void fadeOut(UIObject widget) {
      widget.setVisible(false);

    }

    /** {@inheritDoc} */
    @Override
    public void fadeOut(UIObject widget, Runnable callback) {
      widget.setVisible(false);
      callback.run();
    }

  };

  /**
   * Scrolls specified {@code widget} into view.
   *
   * @param widget the widget to scroll into view.
   */
  public void scrollIntoView(UIObject widget);

  /**
   * Scrolls specified {@code widget} into view and then calls the
   * {@code callback}.
   *
   * @param widget the widget to scroll into view.
   * @param callback the callback to call when scrolling is finished.
   */
  public void scrollIntoView(UIObject widget, Runnable callback);

  /**
   * Fades in the {@code widget}.
   *
   * @param widget the widget to fade in.
   */
  public void fadeIn(UIObject widget);

  /**
   * Fades in the {@code widget} and then calls the
   * {@code callback}.
   *
   * @param widget the widget to fade in.
   * @param callback the callback to call when widget is fully displayed.
   */
  public void fadeIn(UIObject widget, Runnable callback);

  /**
   * Fades out the {@code widget}.
   *
   * @param widget the widget to fade out.
   */
  public void fadeOut(UIObject widget);

  /**
   * Fades out the {@code widget} and then calls the {@code callback}.
   *
   * @param widget the widget to fade out.
   * @param callback the callback to call when widget is completely hidden.
   */
  public void fadeOut(UIObject widget, Runnable callback);

}
