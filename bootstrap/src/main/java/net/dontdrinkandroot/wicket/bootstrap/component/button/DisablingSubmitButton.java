/***Copyright(C)2012-2014 Philip W.Sorst<philip @sorst.net>*and individual contributors as indicated*by the @authors tag.**Licensed under the Apache License,Version 2.0(the"License");*you may not use this file except in compliance with the License.*You may obtain a copy of the License at**http://www.apache.org/licenses/LICENSE-2.0
**Unless required by applicable law or agreed to in writing,software*distributed under the License is distributed on an"AS IS"BASIS,*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.*See the License for the specific language governing permissions and*limitations under the License.*/
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;


public abstract class DisablingSubmitButton extends AjaxSubmitLink
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior();

	private Model<String> loadingTextModel = new Model<String>("Submitting...");


	public DisablingSubmitButton(String id)
	{
		super(id);
	}

	public DisablingSubmitButton(String id, Model<String> loadingTextModel)
	{
		super(id);
		this.loadingTextModel = loadingTextModel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new AttributeModifier("data-loading-text", this.getLoadingTextModel()));
		this.add(this.getButtonBehavior());
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
	{
		super.updateAjaxAttributes(attributes);

		attributes.getAjaxCallListeners().add(new AjaxCallListener() {

			@Override
			public CharSequence getBeforeHandler(Component component)
			{
				return "console.log(attrs)";
			}

			@Override
			public CharSequence getAfterHandler(Component component)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("$('#" + DisablingSubmitButton.this.getMarkupId() + "').button('loading');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " input').attr('disabled', 'disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " textarea').attr('disabled', 'disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " select').attr('disabled', 'disabled');");

				return sb.toString();
			}

			@Override
			public CharSequence getCompleteHandler(Component component)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("$('#" + DisablingSubmitButton.this.getMarkupId() + "').button('reset');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " input').removeAttr('disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " textarea').removeAttr('disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " select').removeAttr('disabled');");

				return sb.toString();
			}
		});
	}

	public ButtonBehavior getButtonBehavior()
	{
		return this.buttonBehavior;
	}

	public Model<String> getLoadingTextModel()
	{
		return this.loadingTextModel;
	}

}