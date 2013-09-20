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
package com.xemantic.tadedon.servlet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Test for {@link CacheForcingFilter}.
 * <p>
 * Created on Sep 20, 2013
 *
 * @author morisil
 */
public class CacheForcingFilterTest {

  /**
   * Test for {@link CacheForcingFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, FilterChain)}
   *
   * @throws ServletException in case of servlet error.
   * @throws IOException in case of IO error.
   */
  @SuppressWarnings({ "deprecation", "boxing" })
  @Test
  public void shouldAddCacheForeverResponseHeaders() throws IOException, ServletException {
    // given
    CacheForcingFilter filter = new CacheForcingFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);

    // when
    filter.doFilter(request, response, chain);
    Date expires = new Date(Long.parseLong(response.getHeader("Expires")));

    // then
    verify(chain).doFilter(request, response);
    assertThat(expires.getYear(), is((new Date()).getYear() + 1));
    assertThat(
        response.getHeader("Cache-control"),
        is("max-age=31556926"));
  }

}
