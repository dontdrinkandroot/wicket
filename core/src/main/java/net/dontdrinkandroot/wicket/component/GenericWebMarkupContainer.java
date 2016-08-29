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
package net.dontdrinkandroot.wicket.component;

import org.apache.wicket.IGenericComponent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;


public class GenericWebMarkupContainer<T> extends WebMarkupContainer  implements IGenericComponent<T> {

	private static final long serialVersionUID = 1L;


	public GenericWebMarkupContainer(String id) {
		super(id);
	}


	public GenericWebMarkupContainer(String id, IModel<T> model) {
		super(id, model);
	}


	@SuppressWarnings("unchecked")
	public IModel<T> getModel() {
		return (IModel<T>) this.getDefaultModel();
	}


	public void setModel(IModel<T> model) {
		this.setDefaultModel(model);
	}


	@SuppressWarnings("unchecked")
	public T getModelObject() {
		return (T) this.getDefaultModelObject();
	}


	public void setModelObject(T object) {
		this.setDefaultModelObject(object);
	}
}
