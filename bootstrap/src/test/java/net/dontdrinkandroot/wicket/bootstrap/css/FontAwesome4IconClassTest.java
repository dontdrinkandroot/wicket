/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.bootstrap.css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FontAwesome4IconClassTest
{
    @Test
    public void testGetClassString()
    {
        for (FontAwesome4IconClass fontAwesomeIconClass : FontAwesome4IconClass.values()) {
            if (!(fontAwesomeIconClass.equals(FontAwesome4IconClass.FIVEHUNDRED_PX))) {
                Assertions.assertEquals(
                        "fa-" + fontAwesomeIconClass.name().toLowerCase().replace("_", "-"),
                        fontAwesomeIconClass.getClassString()
                );
            }
        }
    }
}