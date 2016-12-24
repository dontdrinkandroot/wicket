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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AlertBehavior extends Behavior
{
    private IModel<AlertStyle> alertStyleModel = new Model<AlertStyle>();

    public AlertBehavior(AlertStyle alertStyle)
    {
        this.alertStyleModel = Model.of(alertStyle);
    }

    public AlertBehavior(IModel<AlertStyle> alertStyleModel)
    {
        this.alertStyleModel = alertStyleModel;
    }

    public AlertStyle getStyle()
    {
        return this.alertStyleModel.getObject();
    }

    protected IModel<AlertStyle> getStyleModel()
    {
        return this.alertStyleModel;
    }

    @Override
    public void bind(Component component)
    {
        super.bind(component);

        component.add(new CssClassAppender(BootstrapCssClass.ALERT));
        component.add(new CssClassAppender(this.getStyleModel()));
    }
}
