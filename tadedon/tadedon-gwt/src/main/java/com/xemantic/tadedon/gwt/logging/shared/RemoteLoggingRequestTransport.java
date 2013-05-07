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
package com.xemantic.tadedon.gwt.logging.shared;

import java.util.logging.Logger;

import com.google.gwt.http.client.RequestCallback;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

/**
 * Transport for avoiding remote logging loops on server failure. Such an error
 * could happen in case of HTTP protocol errors.
 * <p>
 * Created on May 2, 2013
 *
 * @author morisil
 */
public class RemoteLoggingRequestTransport extends DefaultRequestTransport {

  /**
   * The logger name used by this transport.
   */
  public static final String LOGGER_NAME = "RemoteLoggingRequestTransport";

  private static final Logger logger = Logger.getLogger(LOGGER_NAME);

  /** {@inheritDoc} */
  @Override
  protected RequestCallback createRequestCallback(
      final TransportReceiver receiver) {

    return super.createRequestCallback(new TransportReceiver() {
      @Override
      public void onTransportSuccess(String payload) {
        receiver.onTransportSuccess(payload);
      }
      @Override
      public void onTransportFailure(ServerFailure failure) {
        logger.severe("Error occured while logging exception remotely");
        // swallow logging failure, to avoid loop
      }
    });
  }

}
