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
package net.dontdrinkandroot.wicket.bootstrap.css;

import net.dontdrinkandroot.wicket.css.CssClass;


public enum GlyphIconClass implements CssClass {

	ASTERISK("glyphicon-asterisk"),
	PLUS("glyphicon-plus"),
	EURO("glyphicon-euro"),
	MINUS("glyphicon-minus"),
	CLOUD("glyphicon-cloud"),
	ENVELOPE("glyphicon-envelope"),
	PENCIL("glyphicon-pencil"),
	GLASS("glyphicon-glass"),
	USER("glyphicon-user");

	private final String classString;


	private GlyphIconClass(String classString) {

		this.classString = classString;
	}


	@Override
	public String getClassString() {

		return "glyphicon " + this.classString;
	}

}