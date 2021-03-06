package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import findClosestBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.model.IModel

class FormLabelSizeBehavior : Behavior() {

    override fun bind(component: Component) {
        super.bind(component)
        component.add(CssClassAppender(IModel<CssClass> {
            val formStyleBehavior = component.findClosestBehavior(FormStyleBehavior::class)
            when {
                null != formStyleBehavior && formStyleBehavior.horizontal -> formStyleBehavior.labelSize
                else -> null
            }
        }))
        component.add(CssClassAppender(IModel<CssClass> {
            val formStyleBehavior = component.findClosestBehavior(FormStyleBehavior::class)
            when {
                null != formStyleBehavior && formStyleBehavior.horizontal -> BootstrapCssClass.COL_FORM_LABEL
                else -> null
            }
        }))
    }
}