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
package net.dontdrinkandroot.wicket.model;

import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class CssClassToggleModel extends AbstractReadOnlyModel<CssClass>
{

    private IModel<Boolean> toggleModel;

    private CssClass activeClass;

    private CssClass inactiveClass;

    public CssClassToggleModel(CssClass activeClass)
    {
        this.toggleModel = Model.of(true);
        this.activeClass = activeClass;
    }

    public CssClassToggleModel(IModel<Boolean> toggleModel, CssClass activeClass)
    {
        this.toggleModel = toggleModel;
        this.activeClass = activeClass;
    }

    public CssClassToggleModel(IModel<Boolean> toggleModel, CssClass activeClass, CssClass inactiveClass)
    {
        this.toggleModel = toggleModel;
        this.activeClass = activeClass;
        this.inactiveClass = inactiveClass;
    }

    @Override
    public CssClass getObject()
    {
        if (this.isActive()) {
            return this.activeClass;
        } else {
            return this.inactiveClass;
        }
    }

    protected boolean isActive()
    {
        return this.toggleModel.getObject().booleanValue();
    }

    @Override
    public void detach()
    {
        super.detach();
        if (null != this.toggleModel) {
            this.toggleModel.detach();
        }
    }

}
