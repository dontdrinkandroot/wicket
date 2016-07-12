package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class StandardFormPage extends FormPage
{

	public StandardFormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Standard Form");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		Form<Void> form = new Form<Void>("form");
		this.add(form);

		RepeatingView formGroupView = new RepeatingView("formGroup");
		this.populateFormGroups(formGroupView);
		form.add(formGroupView);
	}

}
