/*
 * Copyright 2010 Xemantic
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
package com.xemantic.tadedon.guice.configuration;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * Component for test purposes
 * @author hshsce
 */
@Singleton
public class PropertyInjectedComponent {

    private final String foo;
    private final List<String> list;

    @Inject
    public PropertyInjectedComponent(
            @Named("foo") String foo,
            @Named("list") List<String> list) {
        this.foo = foo;
        this.list = list;
    }

    public String getFoo() {
        return foo;
    }
    
    public List<String> getList() {
        return list;
    }
}
