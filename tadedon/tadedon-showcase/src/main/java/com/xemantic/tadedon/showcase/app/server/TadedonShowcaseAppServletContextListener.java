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
package com.xemantic.tadedon.showcase.app.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.xemantic.tadedon.guice.lifecycle.jsr250.Jsr250LifecycleModule;
import com.xemantic.tadedon.guice.servlet.TadedonGuiceServletContextListener;
import com.xemantic.tadedon.gwt.http.GwtHttpCachingModule;

/**
 *
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
public class TadedonShowcaseAppServletContextListener extends
    TadedonGuiceServletContextListener {

  /** {@inheritDoc} */
  @Override
  protected Injector getInjector(Stage stage) {
    return Guice.createInjector(
        stage,
        new Jsr250LifecycleModule(),
        new GwtHttpCachingModule(),
        new TadedonShowcaseAppModule());
  }

}
