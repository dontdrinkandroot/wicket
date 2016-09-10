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
package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.model.IModel;

//TODO: Still not able to handle double submits the way intended.
public class SimpleAjaxForm<T> extends SimpleForm<T>
{

    public SimpleAjaxForm(String id)
    {
        super(id);
        this.createSubmitBehavior();
    }

    public SimpleAjaxForm(String id, IModel<T> model)
    {
        super(id, model);
        this.createSubmitBehavior();
    }

    protected void createSubmitBehavior()
    {
        this.add(new AjaxFormSubmitBehavior(this, "submit")
        {
            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);
                attributes.setPreventDefault(true);
                attributes.setEventPropagation(AjaxRequestAttributes.EventPropagation.STOP_IMMEDIATE);
            }

            @Override
            protected void onError(AjaxRequestTarget target)
            {
                super.onError(target);
                SimpleAjaxForm.this.onError(target);
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
                SimpleAjaxForm.this.onSubmit(target);
            }

            @Override
            protected void onAfterSubmit(AjaxRequestTarget target)
            {
                super.onAfterSubmit(target);
                SimpleAjaxForm.this.onAfterSubmit(target);
            }
        });
    }

    protected void onAfterSubmit(AjaxRequestTarget target)
    {
        /* Hook */
    }

    protected void onSubmit(AjaxRequestTarget target)
    {
        /* Hook */
    }

    protected void onError(AjaxRequestTarget target)
    {
        target.add(this);
    }

    @Override
    protected final void onError()
    {
        if (this.getRequestCycle().find(AjaxRequestTarget.class) == null) {
            this.onError(null);
        }
    }

    @Override
    protected final void onSubmit()
    {
        if (this.getRequestCycle().find(AjaxRequestTarget.class) == null) {
            this.onSubmit(null);
            this.onAfterSubmit(null);
        }
    }
}
