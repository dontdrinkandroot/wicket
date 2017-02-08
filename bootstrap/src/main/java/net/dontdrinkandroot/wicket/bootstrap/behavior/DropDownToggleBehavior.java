/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior;
import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.Behavior;

/**
 * Adds the required attributes for a DropDown Toggle.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DropDownToggleBehavior extends CompositeBehavior
{
    public DropDownToggleBehavior(Behavior... behaviors)
    {
        super(
                new CssClassAppender(BootstrapCssClass.DROPDOWN_TOGGLE),
                new AttributeModifier("data-toggle", "dropdown"),
                new AttributeModifier("aria-haspopup", "true"),
                new AttributeModifier("aria-expanded", "false")
        );
    }
}
