package net.dontdrinkandroot.wicket.behavior

import net.dontdrinkandroot.wicket.css.CssClass
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel
import org.apache.wicket.behavior.AttributeAppender
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * Appends a <tt>class</tt> attribute to an element. Can be a String, A [CssClass] or a model of a [CssClass].
 */
open class CssClassAppender : AttributeAppender {

    constructor(classToAdd: String?) : super("class", Model(classToAdd), " ")
    constructor(cssClass: CssClass) : super("class", Model(cssClass.classString), " ")
    constructor(cssClassModel: IModel<out CssClass?>) : super("class", CssClassClassStringModel(cssClassModel), " ")
}