package net.dontdrinkandroot.wicket.bootstrap.component.pagination

import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior
import net.dontdrinkandroot.wicket.bootstrap.css.FontAwesome4IconClass
import org.apache.wicket.markup.html.link.AbstractLink
import org.apache.wicket.markup.html.navigation.paging.IPageable
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

abstract class LastPageLinkItem(id: String, pageable: IPageable) : AbstractPageLinkItem(id, pageable) {

    override fun createLabel(): IModel<String> = Model("")

    override fun onLinkCreated(link: AbstractLink) {
        super.onLinkCreated(link)
        link.add(IconBehavior(FontAwesome4IconClass.ANGLE_DOUBLE_RIGHT.createIcon()))
    }

    override fun isEnabled(): Boolean = (pageable.pageCount != 0L && pageable.currentPage != pageable.pageCount - 1)

    override fun setPaginablePage() {
        pageable.currentPage = pageable.pageCount - 1
    }

    override val paginablePageModel: IModel<Long>
        get() = IModel { pageable.pageCount - 1 }
}