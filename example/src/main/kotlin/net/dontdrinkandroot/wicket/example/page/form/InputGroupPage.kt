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
package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class InputGroupPage(parameters: PageParameters) : FormPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        val labels: InputGroupText = object : InputGroupText("labels", Model.of("")) {
            override fun createInputGroupPrepend(id: String): Component {
                return InputGroupLabel(id, Model.of("Before"))
            }

            override fun createInputGroupAppend(id: String): Component
            {
                return InputGroupLabel(id, Model.of("After"))
            }
        }
        this.add(labels)
        val buttons: InputGroupText = object : InputGroupText("buttons", Model.of(""))
        {
            override fun createInputGroupPrepend(id: String): Component
            {
                return object : InputGroupButton<Void?>(id)
                {
                    override fun createLink(id: String): Component
                    {
                        return Label(id, Model.of("Before"))
                    }
                }
            }

            override fun createInputGroupAppend(id: String): Component
            {
                return object : InputGroupButton<Void?>(id)
                {
                    override fun createLink(id: String): Component
                    {
                        return Label(id, Model.of("After"))
                    }
                }
            }
        }
        this.add(buttons)
    }

    override fun createPageHeadingModel() = "Input Groups".model()
}