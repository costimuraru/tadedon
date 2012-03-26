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


import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.UIObject;

/**
 * Utility for calling common jQuery methods from GWT.
 * <p>
 * Created on Mar 5, 2012
 *
 * @author morisil
 */
public final class JQuery {

  private JQuery() { /* util class, non-instantiable */ }


  /**
   * Scrolls window top to given {@code offset} with smooth animation which
   * will take the {@code duration} to finish.
   *
   * @param offset the offset to scroll to.
   * @param duration one of predefined animation durations.
   */
  public static void scrollTop(int offset, Duration duration) {
    scrollTop(offset, duration.getMilliseconds());
  }

  /**
   * Scrolls window top to given {@code offset} with smooth animation which
   * will take the {@code duration} to finish.
   *
   * @param offset the offset to scroll to.
   * @param duration the animation duration.
   */
  public static native void scrollTop(
      int offset,
      int duration)
  /*-{
    $wnd.$('html, body').animate(
        { scrollTop: offset },
        duration,
        function() {callback.@java.lang.Runnable::run()();});
  }-*/;

  /**
   * Scrolls window top to given {@code offset} with smooth animation which
   * will take the {@code duration} to finish and the {@code callback} will be
   * executed then.
   *
   * @param offset the offset to scroll to.
   * @param duration one of predefined animation durations.
   * @param callback the callback to execute when animation is finished.
   */
  public static void scrollTop(
      int offset,
      Duration duration,
      Runnable callback) {

    scrollTop(offset, duration.getMilliseconds());
  }

  /**
   * Scrolls window top to given {@code offset} with smooth animation which
   * will take the {@code duration} to finish and the {@code callback} will be
   * executed then.
   *
   * @param offset the offset to scroll to.
   * @param duration the animation duration.
   * @param callback the callback to execute when animation is finished.
   */
  public static native void scrollTop(
      int offset,
      int duration,
      Runnable callback)
  /*-{
    $wnd.$('html, body').animate(
        { scrollTop: offset },
        duration,
        function() {callback.@java.lang.Runnable::run()();});
  }-*/;

  /**
   * Displays the {@code widget} by fading it to opaque.
   * Note: make sure to set this widget invisible by calling
   * {@code setVisible(false)} method first.
   *
   * @param widget the widget to fade in.
   */
  public static void fadeIn(UIObject widget) {
    fadeIn(widget, Duration.MEDIUM);
  }

  /**
   * Displays the {@code widget} by fading it to opaque.
   * Note: make sure to set this widget invisible by calling
   * {@code setVisible(false)} method first.
   *
   * @param widget the widget to fade in.
   * @param duration one of predefined animation durations.
   */
  public static void fadeIn(UIObject widget, Duration duration) {
    fadeIn(widget, duration.getMilliseconds());
  }

  /**
   * Displays the {@code widget} by fading it to opaque.
   * Note: make sure to set this widget invisible by calling
   * {@code setVisible(false)} method first.
   *
   * @param widget the widget to fade in.
   * @param duration the animation duration.
   */
  public static void fadeIn(UIObject widget, int duration) {
    fadeIn(widget.getElement(), duration);
  }

  /**
   * Displays the {@code widget} by fading it to opaque and calls the
   * {@code callback} on finish.
   * Note: make sure to set this widget invisible by calling
   * {@code setVisible(false)} method first.
   *
   * @param widget the widget to fade in.
   * @param duration one of predefined animation durations.
   * @param callback the callback to execute when animation is finished.
   */
  public static void fadeIn(
      UIObject widget,
      Duration duration,
      Runnable callback) {

    fadeIn(widget, duration.getMilliseconds(), callback);
  }

  /**
   * Displays the {@code widget} by fading it to opaque and calls the
   * {@code callback} on finish.
   * Note: make sure to set this widget invisible by calling
   * {@code setVisible(false)} method first.
   *
   * @param widget the widget to fade in.
   * @param duration the animation duration.
   * @param callback the callback to execute when animation is finished.
   */
  public static void fadeIn(UIObject widget, int duration, Runnable callback) {
    fadeIn(widget.getElement(), duration, callback);
  }

  /**
   * Displays the {@code element} by fading it to opaque.
   *
   * @param element the element to fade in.
   * @param duration the animation duration.
   */
  public static void fadeIn(Element element, int duration) {
    fadeIn(element, String.valueOf(duration), "swing");
  }

  /**
   * Displays the {@code element} by fading it to opaque and calls the
   * {@code callback} on finish.
   *
   * @param element the element to fade in.
   * @param duration the animation duration.
   * @param callback the callback to execute when animation is finished.
   */
  public static void fadeIn(Element element, int duration, Runnable callback) {
    fadeIn(element, String.valueOf(duration), "swing", callback);
  }

  /**
   * Displays the {@code element} by fading it to opaque.
   *
   * @param element the element to fade in.
   * @param duration the animation duration.
   * @param easing the easing function to use for the transition.
   */
  public static native void fadeIn(
      Element element,
      String duration,
      String easing)

  /*-{
    $wnd.$(element).fadeIn(duration, easing);
  }-*/;


  /**
   * Displays the {@code element} by fading it to opaque and calls the
   * {@code callback} on finish.
   *
   * @param element the element to fade in.
   * @param duration the animation duration.
   * @param easing the easing function to use for the transition.
   * @param callback the callback to execute when animation is finished.
   */
  public static native void fadeIn(
      Element element,
      String duration,
      String easing,
      Runnable callback)

  /*-{
    $wnd.$(element).fadeIn(
                        duration,
                        easing,
                        function() {callback.@java.lang.Runnable::run()();});
  }-*/;

  /**
   * Hides the {@code widget} by fading it to transparent.
   *
   * @param widget the widget to fade out.
   */
  public static void fadeOut(UIObject widget) {
    fadeOut(widget, Duration.MEDIUM);
  }

  /**
   * Hides the {@code widget} by fading it to transparent.
   *
   * @param widget the widget to fade out.
   * @param duration one of predefined animation durations.
   */
  public static void fadeOut(UIObject widget, Duration duration) {
    fadeOut(widget, duration.getMilliseconds());
  }

  /**
   * Hides the {@code widget} by fading it to transparent.
   *
   * @param widget the widget to fade out.
   * @param duration the animation duration.
   */
  public static void fadeOut(UIObject widget, int duration) {
    fadeOut(widget.getElement(), duration);
  }

  /**
   * Hides the {@code widget} by fading it to transparent and calls the
   * {@code callback} on finish.
   *
   * @param widget the widget to fade out.
   * @param duration one of predefined animation durations.
   * @param callback the callback to execute when animation is finished.
   */
  public static void fadeOut(
      UIObject widget,
      Duration duration,
      Runnable callback) {

    fadeOut(widget, duration.getMilliseconds(), callback);
  }

  /**
   * Hides the {@code widget} by fading it to transparent and calls the
   * {@code callback} on finish.
   *
   * @param widget the widget to fade out.
   * @param duration the animation duration.
   * @param callback the callback to execute when animation is finished.
   */
  public static void fadeOut(UIObject widget, int duration, Runnable callback) {
    fadeOut(widget.getElement(), duration, callback);
  }

  /**
   * Hides the {@code element} by fading it to transparent.
   *
   * @param element the element to fade out.
   * @param duration the animation duration.
   */
  public static void fadeOut(Element element, int duration) {
    fadeOut(element, String.valueOf(duration), "swing");
  }

  /**
   * Hides the {@code element} by fading it to transparent and calls the
   * {@code callback} on finish.
   *
   * @param element the element to fade out.
   * @param duration the animation duration.
   * @param callback the callback to execute when animation is finished.
   */
  public static void fadeOut(Element element, int duration, Runnable callback) {
    fadeOut(element, String.valueOf(duration), "swing", callback);
  }

  /**
   * Hides the {@code element} by fading it to transparent.
   *
   * @param element the element to fade out.
   * @param duration the animation duration.
   * @param easing the easing function to use for the transition.
   */
  public static native void fadeOut(
      Element element,
      String duration,
      String easing)

  /*-{
    $wnd.$(element).fadeOut(duration, easing);
  }-*/;

  /**
   * Hides the {@code element} by fading it to transparent and calls the
   * {@code callback} on finish.
   *
   * @param element the element to fade out.
   * @param duration the animation duration.
   * @param easing the easing function to use for the transition.
   * @param callback the callback to execute when animation is finished.
   */
  public static native void fadeOut(
      Element element,
      String duration,
      String easing,
      Runnable callback)

  /*-{
    $wnd.$(element).fadeOut(
                        duration,
                        easing,
                        function() {callback.@java.lang.Runnable::run()();});
  }-*/;

}

