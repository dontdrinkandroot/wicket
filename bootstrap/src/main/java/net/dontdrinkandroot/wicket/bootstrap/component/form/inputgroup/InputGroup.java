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
package net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the FormComponent.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class InputGroup<T, M, F extends FormComponent<M>> extends GenericPanel<T>
{
    public static final String INPUT_GROUP_PREPEND_ID = "inputGroupPrepend";

    public static final String INPUT_GROUP_APPEND_ID = "inputGroupAppend";

    private Component inputGroupPrepend;

    private Component inputGroupAppend;

    private F formComponent;

    public InputGroup(String id)
    {
        this(id, null);
    }

    public InputGroup(String id, IModel<T> model)
    {
        super(id, model);
        this.formComponent = this.createFormComponent("formComponent");
        this.formComponent.setOutputMarkupId(true);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.INPUT_GROUP));

        this.add(this.formComponent);

        this.inputGroupPrepend = this.createInputGroupPrepend(InputGroup.INPUT_GROUP_PREPEND_ID);
        this.add(this.inputGroupPrepend);

        this.inputGroupAppend = this.createInputGroupAppend(InputGroup.INPUT_GROUP_APPEND_ID);
        this.add(this.inputGroupAppend);
    }

    @Override
    protected void onConfigure()
    {
        super.onConfigure();

        boolean hasAddon = this.inputGroupPrepend.isVisible() || this.inputGroupAppend.isVisible();
        this.setRenderBodyOnly(!hasAddon);
    }

    @Override
    protected void onBeforeRender()
    {
        super.onBeforeRender();
    }

    public F getFormComponent()
    {
        return this.formComponent;
    }

    protected Component createInputGroupPrepend(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    protected Component createInputGroupAppend(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    protected abstract F createFormComponent(String id);
}
