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
package net.dontdrinkandroot.wicket.bootstrap.component.navbar;

import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition;
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavbarTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        Navbar component = new Navbar("id");
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester tagTester;

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-light"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-expand-lg"));

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "container"));
    }

    @Test
    public void testPositioningAndStyle()
    {
        Navbar component = new Navbar("id");
        component.setPosition(NavbarPosition.FIXED_TOP);
        component.setStyle(NavbarStyle.DARK);
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester tagTester;

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-dark"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "fixed-top"));
        Assertions.assertTrue(tagTester.getAttributeContains("class", "navbar-expand-lg"));

        tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "container");
        Assertions.assertTrue(tagTester.getAttributeContains("class", "container"));
    }
}
