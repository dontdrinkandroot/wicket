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
package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

/**
 * Sets the component to invisible if its model or the modelobject is null or it is an empty string.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class EmptyModelInvisibleBehavior : Behavior()
{
    override fun onConfigure(component: Component)
    {
        super.onConfigure(component)
        val modelObject = component.defaultModel?.`object`
        component.isVisible = null != modelObject && (modelObject !is String || modelObject.isNotEmpty())
    }
}
