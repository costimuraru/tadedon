/*
 * Copyright 2012 Xemantic
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
package com.xemantic.tadedon.gwt.jquery.client;

/**
 * Represents predefined durations - number of milliseconds.
 * <p>
 * Created on Mar 5, 2012
 *
 * @author morisil
 */
public enum Duration {

  /** 200 milliseconds */
  FAST(200),

  /** 400 milliseconds */
  MEDIUM(400),

  /** 600 milliseconds */
  SLOW(600);


  private final int milliseconds;


  private Duration(int milliseconds) {
    this.milliseconds = milliseconds;
  }

  /**
   * Number of milliseconds in the duration.
   * 
   * @return the milliseconds
   */
  public int getMilliseconds() {
    return milliseconds;
  }

}
