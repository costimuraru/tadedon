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

import javax.inject.Singleton;

import com.google.common.collect.ImmutableMap;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

/**
 * Guice module of the showcase app.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
public class TadedonShowcaseAppModule extends ServletModule {

  /** {@inheritDoc} */
  @Override
  protected void configureServlets() {
    bind(RequestFactoryServlet.class).in(Singleton.class);
    serve("/gwtRequest").with(
        RequestFactoryServlet.class,
        ImmutableMap.of(
            "symbolMapsDirectory", "WEB-INF/deploy/showcase/symbolMaps"));
  }

}
