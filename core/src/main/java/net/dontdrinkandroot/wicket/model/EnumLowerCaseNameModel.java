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
package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;


/**
 * Returns the name of an enum Model in lower case or null if not set.
 */
public class EnumLowerCaseNameModel extends AbstractChainedModel<Enum<?>, String> {

    public EnumLowerCaseNameModel(IModel<? extends Enum<?>> parent)
    {

        super(parent);
    }

    @Override
    public String getObject()
    {

        if (this.getParent() == null) {
            return null;
        }

        if (this.getParentObject() == null) {
            return null;
        }

        return this.getParentObject().name().toLowerCase();
    }

}
