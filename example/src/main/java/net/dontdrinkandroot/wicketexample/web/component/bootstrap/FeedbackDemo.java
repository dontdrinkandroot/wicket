package net.dontdrinkandroot.wicketexample.web.component.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.CloseableFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FeedbackPanel;
import net.dontdrinkandroot.wicket.component.TypedPanel;


public class FeedbackDemo extends TypedPanel<Void> {

	public FeedbackDemo(String id) {

		super(id);

		FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		this.add(feedbackPanel);

		CloseableFeedbackPanel closeableFeedbackPanel = new CloseableFeedbackPanel("closeableFeedbackPanel");
		this.add(closeableFeedbackPanel);

		this.debug("A debug message");
		this.info("A info message");
		this.success("A success message");
		this.warn("A warn message");
		this.error("A error message");
		this.fatal("A fatal message");
	}

}
