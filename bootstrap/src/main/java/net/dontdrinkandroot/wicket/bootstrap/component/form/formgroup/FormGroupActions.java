/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.form.BootstrapForm;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public class FormGroupActions<T> extends GenericPanel<T>
{

	private WebMarkupContainer spaceHolder;

	private WebMarkupContainer actionContainer;


	public FormGroupActions(String id)
	{
		super(id);
	}

	public FormGroupActions(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.FORM_GROUP));
		this.spaceHolder = new WebMarkupContainer("spaceHolder");
		this.add(this.spaceHolder);

		this.actionContainer = new WebMarkupContainer("actionContainer");
		this.add(this.actionContainer);

		RepeatingView actionView = new RepeatingView("action");
		this.populateActions(actionView);
		this.actionContainer.add(actionView);

		Form<?> form = this.getForm();
		if (form instanceof BootstrapForm<?>) {
			BootstrapForm<?> bootstrapForm = (BootstrapForm<?>) form;
			if ((null != bootstrapForm.getLabelColumnSize()) && (null != bootstrapForm.getFormComponentColumnSize())) {
				this.spaceHolder.add(new CssClassAppender(bootstrapForm.getLabelColumnSize()));
				this.actionContainer.add(new CssClassAppender(bootstrapForm.getFormComponentColumnSize()));
			}
		}
	}

	protected void populateActions(RepeatingView actionView)
	{
		/* Hook */
	}

	public Form<?> getForm()
	{
		Form<?> form = Form.findForm(this);
		if (form == null) {
			throw new WicketRuntimeException("Could not find Form parent for " + this);
		}
		return form;
	}

}
