package net.dontdrinkandroot.wicket.bootstrap.component.nav

import net.dontdrinkandroot.wicket.bootstrap.css.NavItemAlignment
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class NavTabsTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        val component: RepeatingNavTabs<*> = navTabs("id") {}
        val markup = ComponentRenderer.renderComponent(component).toString()
        val tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("nav nav-tabs", tagTester.getAttribute("class"))
    }

    @Test
    fun testJustifiedMarkup() {
        val component: RepeatingNavTabs<*> = navTabs<Any?>(
            "id",
            itemAlignment = Model(NavItemAlignment.JUSTIFIED),
            populateItemsHandler = {})
        val markup = ComponentRenderer.renderComponent(component).toString()
        val tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("nav nav-tabs nav-justified", tagTester.getAttribute("class"))
    }
}