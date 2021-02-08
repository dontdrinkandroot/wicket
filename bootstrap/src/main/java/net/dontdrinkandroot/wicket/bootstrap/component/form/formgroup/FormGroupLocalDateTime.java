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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupLocalDateTime;
import net.dontdrinkandroot.wicket.component.form.LocalDateTimeTextField;
import net.dontdrinkandroot.wicket.model.KModel;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.time.LocalDateTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalDateTime extends FormGroupInputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField, InputGroupLocalDateTime>
{
    public FormGroupLocalDateTime(String id, KModel<String> labelModel, IModel<LocalDateTime> model) {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<LocalDateTime, LocalDateTime, LocalDateTimeTextField> createInputGroup(String id)
    {
        return new InputGroupLocalDateTime(id, this.getModel())
        {
            @Override
            protected Component createInputGroupPrepend(String id)
            {
                return FormGroupLocalDateTime.this.createInputGroupPrepend(id);
            }

            @Override
            protected Component createInputGroupAppend(String id)
            {
                return FormGroupLocalDateTime.this.createInputGroupAppend(id);
            }
        };
    }
}
