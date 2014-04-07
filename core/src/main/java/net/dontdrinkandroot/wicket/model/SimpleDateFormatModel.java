/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class SimpleDateFormatModel extends AbstractChainedModel<Date, String> {

	private final SimpleDateFormat sdf;


	public SimpleDateFormatModel(IModel<? extends Date> parent, String pattern) {

		super(parent);
		this.sdf = new SimpleDateFormat(pattern);
	}


	@Override
	public String getObject() {

		return this.sdf.format(this.getParentObject());
	}

}
