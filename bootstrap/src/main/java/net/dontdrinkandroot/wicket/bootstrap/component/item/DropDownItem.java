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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropDownToggleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public abstract class DropDownItem extends AbstractLinkItem
{
    protected DropDownMenu dropDownMenu;

    public DropDownItem(String id, String label)
    {
        super(id, label);
    }

    public DropDownItem(String id, IModel<String> labelModel)
    {
        super(id, labelModel);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));

        this.dropDownMenu = createDropDownMenu("dropDownMenu");
        this.add(this.dropDownMenu);
    }


    @Override
    protected Component createLink(String id)
    {
        Label label = new Label(id, this.getModel());
        label.add(new DropDownToggleBehavior());
        this.setAppendIcon(this.getCaretClass());

        return label;
    }

    protected CssClass getCaretClass()
    {
        return BootstrapCssClass.CARET;
    }

    protected abstract DropDownMenu createDropDownMenu(String id);
}
