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

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class BookmarkablePageLinkItem extends AbstractLinkItem
{

	private BookmarkablePageLink<?> link;

	private final Class<? extends Page> pageClass;

	private PageParameters parameters;


	public <C extends Page> BookmarkablePageLinkItem(String id, IModel<String> labelModel, Class<C> pageClass)
	{

		super(id, labelModel);

		this.pageClass = pageClass;
	}

	public <C extends Page> BookmarkablePageLinkItem(
			String id,
			IModel<String> labelModel,
			Class<C> pageClass,
			PageParameters parameters)
	{

		this(id, labelModel, pageClass);

		this.parameters = parameters;
	}

	@Deprecated
	public <C extends Page> BookmarkablePageLinkItem(
			String id,
			String label,
			Class<C> pageClass,
			PageParameters parameters)
	{

		this(id, label, pageClass);

		this.parameters = parameters;
	}

	@Deprecated
	public <C extends Page> BookmarkablePageLinkItem(String id, String label, Class<C> pageClass)
	{

		super(id, new Model<String>(label));

		this.pageClass = pageClass;
	}

	@Override
	protected boolean isActive()
	{

		return this.getPage().getClass().isAssignableFrom(this.link.getPageClass());
	}

	@Override
	protected Component createLink(String id)
	{

		if (this.parameters == null) {
			this.link = new BookmarkablePageLink<Void>(id, this.pageClass);
		} else {
			this.link = new BookmarkablePageLink<Void>(id, this.pageClass, this.parameters);
		}
		this.link.setBody(this.getModel());

		return this.link;
	}
}
