package net.dontdrinkandroot.wicket.example.page

import ` net`.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.RepeatingNavbarNav
import net.dontdrinkandroot.wicket.bootstrap.css.BackgroundColor
import net.dontdrinkandroot.wicket.bootstrap.css.NavbarPosition
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import net.dontdrinkandroot.wicket.bootstrap.headeritem.FontAwesomeCssHeaderItem
import net.dontdrinkandroot.wicket.example.component.BuildInfoItem
import net.dontdrinkandroot.wicket.example.component.ThemeDropdownItem
import net.dontdrinkandroot.wicket.example.getCurrentSession
import net.dontdrinkandroot.wicket.example.headeritem.HighlightJsInitHeaderItem
import net.dontdrinkandroot.wicket.example.page.component.*
import net.dontdrinkandroot.wicket.example.page.form.*
import net.dontdrinkandroot.wicket.markup.html.link.BookmarkablePageLink
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.markup.head.CssContentHeaderItem
import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem
import org.apache.wicket.markup.head.IHeaderResponse
import org.apache.wicket.markup.head.OnDomReadyHeaderItem
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class DecoratorPage<T> : StandardBootstrapPage<T> {

    constructor() : super()

    constructor(parameters: PageParameters) : super(parameters)

    constructor(model: IModel<T>?) : super(model)

    override fun createPageTitlePrefixModel() = "wicket.example".model()

    override fun createNavbar(id: String) = Navbar(
        id,
        positionModel = Model(NavbarPosition.FIXED_TOP),
        behaviors = listOf(CssClassAppender(BackgroundColor.LIGHT)),
        createBrandHandler = { id ->
            BookmarkablePageLink<Void>(
                id,
                pageClass = HomePage::class.java,
                bodyModel = Model("wicket.example")
            )
        }
    ) { collapseItemView ->
        val leftItems = RepeatingNavbarNav<Void>(collapseItemView.newChildId()) { itemView ->
            populateNavbarLeftItems(itemView)
        }
        leftItems.add(CssClassAppender(Spacing(Spacing.Property.MARGIN, Spacing.Size.AUTO, Spacing.Side.END)))
        collapseItemView.add(leftItems)
        val rightItems = RepeatingNavbarNav<Void>(collapseItemView.newChildId()) { itemView ->
            itemView.add(ThemeDropdownItem(itemView.newChildId()))
            itemView.add(BuildInfoItem(itemView.newChildId()))
        }
        collapseItemView.add(rightItems)
    }

    protected fun populateNavbarLeftItems(leftItemView: RepeatingView) {
        leftItemView.add(
            BookmarkablePageLinkItem<Void>(
                leftItemView.newChildId(),
                labelModel = "Getting Started".model(),
                pageClass = GettingStartedPage::class.java
            )
        )
        leftItemView.add(
            BookmarkablePageLinkItem<Void>(
                leftItemView.newChildId(),
                labelModel = "CSS".model(),
                pageClass = CssPage::class.java
            )
        )
        leftItemView.add(
            BookmarkablePageLinkItem<Void>(
                leftItemView.newChildId(),
                labelModel = "The Grid".model(),
                pageClass = GridPage::class.java
            )
        )
        leftItemView.add(object : RepeatingDropdownItem<Void>(
            leftItemView.newChildId(),
            labelModel = "Components".model()
        ) {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Buttons".model(),
                        pageClass = ButtonPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Cards".model(),
                        pageClass = CardPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Navs".model(),
                        pageClass = NavPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Navbars".model(),
                        pageClass = NavbarPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Breadcrumbs".model(),
                        pageClass = BreadcrumbPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Badges".model(),
                        pageClass = BadgePage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Alerts and Feedback".model(),
                        pageClass = AlertPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Progress Bars".model(),
                        pageClass = ProgressBarPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Pagination".model(),
                        pageClass = PaginationPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Dropdowns".model(),
                        pageClass = DropdownPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Modals".model(),
                        pageClass = ModalPage::class.java
                    )
                )
            }

            override val active: Boolean
                get() = this.page is ComponentPage
        })
        leftItemView.add(object : RepeatingDropdownItem<Void?>(
            leftItemView.newChildId(),
            labelModel = Model.of("Forms")
        ) {
            override fun populateItems(itemView: RepeatingView) {
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Form Groups and Form Styles".model(),
                        pageClass = FormGroupPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Input Groups".model(),
                        pageClass = InputGroupPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Validations".model(),
                        pageClass = ValidationPage::class.java
                    )
                )
                itemView.add(
                    BookmarkablePageLinkItem<Void>(
                        itemView.newChildId(),
                        labelModel = "Ajax Forms".model(),
                        pageClass = AjaxFormPage::class.java
                    )
                )
            }

            override val active: Boolean
                get() = this.page is FormPage
        })
    }

    override fun renderHead(response: IHeaderResponse) {
        response.render(this.bootstrapHeaderItem)
        response.render(CssUrlReferenceHeaderItem(getCurrentSession().currentTheme!!.url, null, null))
        response.render(FontAwesomeCssHeaderItem())
        response.render(CssContentHeaderItem("body{padding-top: 56px;}", "bodyPadding"))
        response.render(
            CssContentHeaderItem(
                ".has-error .help-block .info{color: #737373;}",
                "infoHelpText"
            )
        )
        response.render(OnDomReadyHeaderItem(" $(\"a[rel='external']\").attr('target', '_blank');"))
        response.render(HighlightJsInitHeaderItem())
    }
}