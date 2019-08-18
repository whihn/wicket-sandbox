package de.wehi;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

import static org.apache.wicket.markup.head.JavaScriptHeaderItem.forReference;

public class HomePage extends WebPage implements IHeaderContributor {

	private static final long serialVersionUID = 1L;
	private Label version;
	private Label name;
	private Person loggedInUser;

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(forReference(new PackageResourceReference(getClass(), "hello.js")));
	}

	public HomePage(final PageParameters parameters) {
		super(parameters);
		loggedInUser = Person.builder().name("Werner").age(38).build();

		addVersionLabel();
		addLabelWithModel();
		add(new AjaxLink<Void>("ajaxLink") {

			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				version.setDefaultModelObject("changed: " + version.getDefaultModelObject());
				ajaxRequestTarget.add(version);

				loggedInUser.setName("Werner Hihn");
				ajaxRequestTarget.add(name);
			}
		});
	}

	private void addLabelWithModel() {
		name = new Label("personName", new PropertyModel(loggedInUser, "name"));
		name.setOutputMarkupId(true);
		add(name);
	}

	private void addVersionLabel() {
		version = new Label("version", getApplication().getFrameworkSettings().getVersion());
		version.setOutputMarkupId(true);
		add(version);
	}
}
