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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlertBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testInfo()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new AlertBehavior(AlertStyle.INFO));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "alert"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "alert-info"));
    }
}
