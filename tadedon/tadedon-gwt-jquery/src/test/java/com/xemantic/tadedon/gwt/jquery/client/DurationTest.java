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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test for {@link Duration}.
 * <p>
 * Created on Mar 22, 2012
 *
 * @author morisil
 */
public class DurationTest {

  /** Tests {@link Duration#getMilliseconds()}. */
  @Test
  public void shouldReturn200MillisecondsForFast() {
    // given
    Duration duration = Duration.FAST;

    // when
    int milliseconds = duration.getMilliseconds();

    // then
    assertThat(milliseconds, is(200));
  }

  /** Tests {@link Duration#getMilliseconds()}. */
  @Test
  public void shouldReturn400MillisecondsForMedium() {
    // given
    Duration duration = Duration.MEDIUM;

    // when
    int milliseconds = duration.getMilliseconds();

    // then
    assertThat(milliseconds, is(400));
  }

  /** Tests {@link Duration#getMilliseconds()}. */
  @Test
  public void shouldReturn600MillisecondsForSlow() {
    // given
    Duration duration = Duration.SLOW;

    // when
    int milliseconds = duration.getMilliseconds();

    // then
    assertThat(milliseconds, is(600));
  }

}
