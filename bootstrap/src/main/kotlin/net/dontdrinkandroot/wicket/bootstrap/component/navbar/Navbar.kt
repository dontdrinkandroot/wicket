package net.dontdrinkandroot.wicket.bootstrap.component.navbar

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.*
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.AttributeModifier
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

open class Navbar(id: String?) : Panel(id) {

    private val positionModel: IModel<NavbarPosition?> = Model(null)
    private val styleModel: IModel<NavbarStyle> = NavbarStyle.LIGHT.model()
    private val expandModel: IModel<NavbarExpand> = NavbarExpand.LG.model()
    private val containerStyleModel: IModel<ContainerStyle> = ContainerStyle.DEFAULT.model()
    private var navbarCollapse: WebMarkupContainer? = null

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.NAVBAR))
        this.add(CssClassAppender(styleModel))
        this.add(CssClassAppender(positionModel))
        this.add(CssClassAppender(expandModel))
        val container = WebMarkupContainer("container")
        container.add(CssClassAppender(containerStyleModel.getObject()))
        this.add(container)
        container.add(createBrand("navbarBrand"))
        navbarCollapse = WebMarkupContainer("navbarCollapse")
        navbarCollapse!!.outputMarkupId = true
        container.add(navbarCollapse)
        val navbarToggle = createNavbarToggler("navbarToggler")
        navbarToggle.add(AttributeModifier("data-bs-target") { "#$navbarCollapseId" })
        container.add(navbarToggle)
        val collapseItemView = RepeatingView("navbarCollapseItem")
        populateCollapseItems(collapseItemView)
        navbarCollapse!!.add(collapseItemView)
    }

    protected open fun createNavbarToggler(id: String): Component = NavbarToggler(id)

    protected open fun createBrand(id: String): Component {
        val brandLink = WebMarkupContainer(id)
        brandLink.isVisible = false
        return brandLink
    }

    protected open fun populateCollapseItems(collapseItemView: RepeatingView) {
        /* Hook */
    }

    fun setPosition(position: NavbarPosition): Navbar {
        positionModel.setObject(position)
        return this
    }

    fun setStyle(style: NavbarStyle): Navbar {
        styleModel.setObject(style)
        return this
    }

    fun setContainerStyle(containerStyle: ContainerStyle): Navbar {
        containerStyleModel.setObject(containerStyle)
        return this
    }

    fun setExpand(expand: NavbarExpand): Navbar {
        expandModel.setObject(expand)
        return this
    }

    val navbarCollapseId: String
        get() = navbarCollapse!!.markupId
}