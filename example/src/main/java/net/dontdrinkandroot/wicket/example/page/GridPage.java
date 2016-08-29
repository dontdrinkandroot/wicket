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
package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetExtraSmall;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetLarge;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetMedium;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnOffsetSmall;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeExtraSmall;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeLarge;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeMedium;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeSmall;
import net.dontdrinkandroot.wicket.example.component.ColumnPanel;
import net.dontdrinkandroot.wicket.example.component.OffsetPanel;


public class GridPage extends DecoratorPage<Void>
{

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("The Grid");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		ColumnPanel xsColumns = new ColumnPanel("xsColumns", ColumnSizeExtraSmall.values());
		this.add(xsColumns);

		ColumnPanel smColumns = new ColumnPanel("smColumns", ColumnSizeSmall.values());
		this.add(smColumns);

		ColumnPanel mdColumns = new ColumnPanel("mdColumns", ColumnSizeMedium.values());
		this.add(mdColumns);

		ColumnPanel lgColumns = new ColumnPanel("lgColumns", ColumnSizeLarge.values());
		this.add(lgColumns);

		OffsetPanel xsOffsets = new OffsetPanel("xsOffsets", ColumnOffsetExtraSmall.values());
		this.add(xsOffsets);

		OffsetPanel smOffsets = new OffsetPanel("smOffsets", ColumnOffsetSmall.values());
		this.add(smOffsets);

		OffsetPanel mdOffsets = new OffsetPanel("mdOffsets", ColumnOffsetMedium.values());
		this.add(mdOffsets);

		OffsetPanel lgOffsets = new OffsetPanel("lgOffsets", ColumnOffsetLarge.values());
		this.add(lgOffsets);
	}
}
