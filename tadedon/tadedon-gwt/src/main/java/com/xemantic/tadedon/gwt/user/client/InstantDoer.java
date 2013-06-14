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
package com.xemantic.tadedon.gwt.user.client;


/**
 * Version of {@link Doer} designed for extension, which assumes that process
 * started in the {@link Doer#go()} method is synchronous. It implies immediate
 * notification of the {@link When} callback after invocation of non-callback
 * {@link Doer#go()} method.
 * <p>
 * Created on Jun 12, 2013
 *
 * @author morisil
 */
public abstract class InstantDoer implements Doer {

  /** {@inheritDoc} */
  @Override
  public void go(When when) {
    go();
    when.done();
  }

}
