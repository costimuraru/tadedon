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

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet applying "cache forever" HTTP headers.
 * <p>
 * Created on Aug 6, 2010
 *
 * @author morisil
 */
public class CacheForcingFilter extends SimpleFilter {

  private static final long ONE_YEAR_IN_SECONDS = 31556926;

  private static final long ONE_YEAR_IN_MILISECONDS =
                                          1000L * ONE_YEAR_IN_SECONDS;


  /** {@inheritDoc} */
  @Override
  public void doFilter(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    chain.doFilter(request, response);
    Date now = new Date();
    response.setDateHeader("Date", now.getTime());
    response.setDateHeader("Expires", now.getTime() + ONE_YEAR_IN_MILISECONDS);
    response.setHeader("Cache-control", "max-age=" + ONE_YEAR_IN_SECONDS);
  }

}
