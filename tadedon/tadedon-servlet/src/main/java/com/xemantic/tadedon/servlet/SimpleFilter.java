/*
 * Copyright 2010, 2013 Xemantic
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

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet {@link Filter} which does not require initialization
 * and clean up and casts {@link ServletRequest} and {@link ServletResponse}
 * to {@link HttpServletRequest} and {@link HttpServletResponse}
 * <p>
 * Created on Aug 6, 2010
 *
 * @author morisil
 */
public abstract class SimpleFilter implements Filter {

  /** {@inheritDoc} */
  @Override
  public void doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    if (!(request instanceof HttpServletRequest)) {
      throw new AssertionError("The request is not HttpServletReqeust");
    }
    if (!(response instanceof HttpServletResponse)) {
      throw new AssertionError("The response is not HttpServletResponse");
    }
    doFilter(
        (HttpServletRequest) request,
        (HttpServletResponse) response,
        chain);
  }

  /** {@inheritDoc} */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    /* nothing to do */
  }

  /** {@inheritDoc} */
  @Override
  public void destroy() {
    /* nothing to do */
  }

  protected abstract void doFilter(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException;

}
