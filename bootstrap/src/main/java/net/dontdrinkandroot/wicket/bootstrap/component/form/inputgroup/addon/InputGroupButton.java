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
package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.button.IButton;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class InputGroupButton<T> extends GenericPanel<T> implements IButton
{
    private final ButtonBehavior buttonBehavior = new ButtonBehavior();

    public InputGroupButton(String id)
    {
        super(id);
    }

    public InputGroupButton(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.INPUT_GROUP_BTN));
        Component link = this.createLink("button");
        link.add(this.buttonBehavior);
        this.add(link);
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.buttonBehavior.getButtonSize();
    }

    @Override
    public InputGroupButton<T> setButtonSize(ButtonSize buttonSize)
    {
        this.buttonBehavior.setButtonSize(buttonSize);
        return this;
    }

    @Override
    public ButtonStyle getButtonStyle()
    {
        return this.buttonBehavior.getButtonStyle();
    }

    @Override
    public InputGroupButton<T> setButtonStyle(ButtonStyle buttonStyle)
    {
        this.buttonBehavior.setButtonStyle(buttonStyle);
        return this;
    }

    @Override
    public InputGroupButton<T> setButtonSizeModel(IModel<ButtonSize> buttonSizeModel) {
        this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
        return this;
    }

    @Override
    public InputGroupButton<T> setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel) {
        this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
        return this;
    }

    protected abstract Component createLink(String id);
}
