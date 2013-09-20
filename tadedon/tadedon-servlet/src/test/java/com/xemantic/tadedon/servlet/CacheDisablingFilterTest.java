/*
 * Copyright 2010,2013 Xemantic
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
package com.xemantic.tadedon.servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Unit test for {@link CacheDisablingFilter}.
 * <p>
 * Created on Aug 6, 2010
 *
 * @author morisil
 */
public class CacheDisablingFilterTest {

  /**
   * Test for {@link CacheDisablingFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, FilterChain)}
   *
   * @throws ServletException in case of servlet error.
   * @throws IOException in case of IO error.
   */
  @Test
  public void shouldAddNoCacheResponseHeaders() throws IOException, ServletException {
    // given
    CacheDisablingFilter filter = new CacheDisablingFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);

    // when
    filter.doFilter(request, response, chain);

    // then
    verify(chain).doFilter(request, response);
    assertThat(response.getHeader("Expires"), is("0"));
    assertThat(response.getHeader("Pragma"), is("no-cache"));
    assertThat(
        response.getHeader("Cache-control"),
        is("no-cache, no-store, must-revalidate"));
  }

}
