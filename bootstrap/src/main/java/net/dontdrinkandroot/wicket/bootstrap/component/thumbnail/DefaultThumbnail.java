package net.dontdrinkandroot.wicket.bootstrap.component.thumbnail;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.TypedPanel;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.model.IModel;


public abstract class DefaultThumbnail<T> extends TypedPanel<T> {

	public DefaultThumbnail(String id, IModel<? extends T> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		MarkupContainer link = this.createLink("link", this.getModel());
		link.add(new CssClassAppender(BootstrapCssClass.THUMBNAIL));
		this.add(link);

		Component image = this.createImage("image", this.getModel());
		link.add(image);
	}


	protected abstract MarkupContainer createLink(String id, IModel<T> model);


	protected abstract Component createImage(String id, IModel<T> model);

}
