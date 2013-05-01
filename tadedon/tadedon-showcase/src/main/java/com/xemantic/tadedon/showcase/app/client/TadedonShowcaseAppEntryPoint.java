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
package com.xemantic.tadedon.showcase.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point of the Tadedon Showcase Application.
 * <p>
 * Created on May 1, 2013
 *
 * @author morisil
 */
public class TadedonShowcaseAppEntryPoint implements EntryPoint {

  /** {@inheritDoc} */
  @Override
  public void onModuleLoad() {
    RootPanel.get().add(new Label("test"));
  }

}
