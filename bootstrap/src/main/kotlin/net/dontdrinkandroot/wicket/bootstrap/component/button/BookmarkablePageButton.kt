package net.dontdrinkandroot.wicket.bootstrap.component.button

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Page
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @param <T> Type of the model object.
 */
open class BookmarkablePageButton<T>(
    id: String,
    model: IModel<T>? = null,
    bodyModel: IModel<String> = Model(null),
    behaviors: List<Behavior> = emptyList(),
    pageClass: Class<out Page>,
    pageParameters: PageParameters? = null,
    buttonStyleModel: IModel<ButtonStyle> = ButtonStyle.SECONDARY.model(),
    buttonSizeModel: IModel<ButtonSize> = Model(null)
) : BookmarkablePageLink<T>(id, pageClass, pageParameters) {

    init {
        body = bodyModel
        behaviors.forEach { add(it) }
        add(ButtonBehavior(buttonStyleModel, buttonSizeModel))
    }
}