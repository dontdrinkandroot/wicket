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
package net.dontdrinkandroot.wicket.bootstrap.component.list;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.basic.UnorderedList;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class ListGroup<T> extends UnorderedList<T>
{
    public ListGroup(String id)
    {
        super(id);
    }

    public ListGroup(String id, IModel<List<T>> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(new CssClassAppender(BootstrapCssClass.LIST_GROUP));
    }

    @Override
    protected void processListComponent(Component listComponent)
    {
        super.processListComponent(listComponent);
        listComponent.add(new CssClassAppender(BootstrapCssClass.LIST_GROUP_ITEM));
    }
}
