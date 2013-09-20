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
 * Servlet applying "never cache" HTTP headers.
 * <p>
 * See:
 * <ul>
 *   <li><a href="http://code.google.com/p/doctype/wiki/ArticleHttpCaching">ArticleHttpCaching</a></li>
 *   <li><a href="http://seewah.blogspot.com/2009/02/gwt-tips-2-nocachejs-getting-cached-in.html">GWT Tips 2 - nocache.js getting cached in browser</a></li>
 * </ul>
 * <p>
 * Created on Aug 6, 2010
 *
 * @author morisil
 */
public class CacheDisablingFilter extends SimpleFilter {

  /** {@inheritDoc} */
  @Override
  public void doFilter(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {

    chain.doFilter(request, response);
    Date now = new Date();
    response.setDateHeader("Date", now.getTime());
    response.setHeader("Expires", "0");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  }

}
