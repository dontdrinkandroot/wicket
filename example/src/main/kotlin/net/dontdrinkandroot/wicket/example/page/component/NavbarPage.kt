package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.divider
import net.dontdrinkandroot.wicket.bootstrap.component.item.dropdown
import net.dontdrinkandroot.wicket.bootstrap.component.item.header
import net.dontdrinkandroot.wicket.bootstrap.component.item.pageLink
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.*
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarAlignment
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarStyle
import net.dontdrinkandroot.wicket.example.component.NavbarForm
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.markup.html.link.BookmarkablePageLink
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class NavbarPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Navbars".model()

    override fun onInitialize() {
        super.onInitialize()
        val navbarLight = createExampleNavbar("navbarLight")
        navbarLight.add(CssClassAppender(BackgroundColor.LIGHT))
        this.add(navbarLight)

        val navbarDark = createExampleNavbar("navbarDark", styleModel = Model(NavbarStyle.DARK))
        navbarDark.add(CssClassAppender(BackgroundColor.DARK))
        this.add(navbarDark)
    }

    protected fun createExampleNavbar(id: String, styleModel: IModel<NavbarStyle> = Model(null)): Navbar = navbar(
        id,
        styleModel = styleModel,
        createBrandHandler = { id ->
            BookmarkablePageLink<Void>(id, pageClass = HomePage::class.java, bodyModel = Model("Brand"))
        }
    )
    {
        navbarNav()
        {
            dropdown("Dropdown") {
                pageLink("Action", HomePage::class)
                divider()
                header("A header")
                pageLink("Another Action", HomePage::class)
            }
            pageLink("Link", NavbarPage::class)
        }

        val form = NavbarForm(newChildId())
        add(form)

        val text = NavbarText(newChildId(), Model.of("Text"))
        add(text)
        add(NavbarButtonLink<Void>(
            newChildId(),
            bodyModel = Model("Button"),
            alignmentModel = NavbarAlignment.RIGHT.model()
        ) {})
    }
}