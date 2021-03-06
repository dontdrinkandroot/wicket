package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior

class MarkupIdBehavior(private val id: String) : Behavior() {

    override fun bind(component: Component) {
        component.markupId = id
        component.outputMarkupId = true
    }
}

fun markupId(id: String) = MarkupIdBehavior(id)