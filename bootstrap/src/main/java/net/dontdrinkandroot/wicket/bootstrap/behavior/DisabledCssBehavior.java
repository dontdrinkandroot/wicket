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

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;


/**
 * Adds {@link BootstrapCssClass#DISABLED} to the class attribute of components that are not enabled
 * in hierarchy.
 */
public class DisabledCssBehavior extends Behavior {

    @Override
    public void onComponentTag(Component component, ComponentTag tag)
    {

        super.onComponentTag(component, tag);

        if (!component.isEnabledInHierarchy()) {

            String classAttribute = tag.getAttribute("class");

            if (classAttribute != null) {

                String[] parts = classAttribute.split(" ");
                for (String part : parts) {
                    if (part.equalsIgnoreCase(BootstrapCssClass.DISABLED.getClassString())) {
                        return;
                    }
                }

                classAttribute += " " + BootstrapCssClass.DISABLED.getClassString();
                tag.put("class", classAttribute);
            } else {

                tag.put("class", BootstrapCssClass.DISABLED.getClassString());
            }
        }
    }

}
