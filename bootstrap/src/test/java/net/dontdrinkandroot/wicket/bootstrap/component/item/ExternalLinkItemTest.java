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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ExternalLinkItemTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        ExternalLinkItem component = new ExternalLinkItem("id", Model.of("Label"), Model.of("http://example.com"));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assertions.assertEquals("<wicket:container wicket:id=\"id\"><wicket:panel>\n" +
                "    <a href=\"http://example.com\" wicket:id=\"link\" rel=\"external\">Label</a>\n" +
                "    <wicket:child/>\n" +
                "</wicket:panel></wicket:container>", componentMarkup.toString());
    }
}
