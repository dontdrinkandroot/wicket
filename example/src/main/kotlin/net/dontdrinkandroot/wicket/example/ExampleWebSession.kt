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
package net.dontdrinkandroot.wicket.example

import net.dontdrinkandroot.wicket.example.model.Theme
import org.apache.wicket.Session
import org.apache.wicket.protocol.http.WebSession
import org.apache.wicket.request.Request

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class ExampleWebSession(request: Request?) : WebSession(request)
{
    var currentTheme: Theme? = null
        get()
        {
            if (null == field)
            {
                field = Theme.availableThemes.iterator().next()
            }
            return field
        }

    companion object
    {
        @JvmStatic
        fun get(): ExampleWebSession
        {
            return Session.get() as ExampleWebSession
        }
    }
}