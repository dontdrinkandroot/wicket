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
package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.utils.BehaviorUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InlineFormScreenReaderOnlyLabelBehavior extends Behavior
{
    @Override
    public void bind(final Component component)
    {
        super.bind(component);

        component.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>()
        {

            @Override
            public CssClass getObject()
            {
                FormStyleBehavior formStyleBehavior =
                        BehaviorUtils.findClosestBehavior(component, FormStyleBehavior.class);
                if (null != formStyleBehavior) {
                    if (formStyleBehavior.isInline()) {
                        return BootstrapCssClass.SR_ONLY;
                    }
                }

                return null;
            }
        }));
    }
}
