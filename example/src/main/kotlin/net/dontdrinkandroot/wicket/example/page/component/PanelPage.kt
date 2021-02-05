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
package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.panel.PlainPanel
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class PanelPage(parameters: PageParameters?) : ComponentPage(parameters)
{
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Panels")
    }

    override fun onInitialize()
    {
        super.onInitialize()
        val panelStyleView = RepeatingView("panelStyle")
        this.add(panelStyleView)
        for (panelStyle in PanelStyle.values())
        {
            val panel: SimplePanel<*> =
                SimplePanel<Void>(panelStyleView.newChildId(), Model.of(panelStyle.name), Heading.Level.H3)
            panel.panelStyle = panelStyle
            panelStyleView.add(panel)
        }
        val panelFooter: PlainPanel<*> = object : PlainPanel<Void?>("panelFooter")
        {
            override fun createBody(id: String): Component
            {
                return Label(id, "Body")
            }

            override fun createFooter(id: String): Component
            {
                return Label(id, "Footer")
            }
        }
        this.add(panelFooter)
    }
}