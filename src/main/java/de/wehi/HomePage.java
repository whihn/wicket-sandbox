package de.wehi;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

import static org.apache.wicket.markup.head.JavaScriptHeaderItem.forReference;

public class HomePage extends WebPage implements IHeaderContributor {

	private static final long serialVersionUID = 1L;

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(forReference(new PackageResourceReference(getClass(), "hello.js")));
	}

	public HomePage(final PageParameters parameters) {
		super(parameters);

		Label versionLabel = new Label("version", getApplication().getFrameworkSettings().getVersion());
		versionLabel.setOutputMarkupId(true);
		add(versionLabel);
		add(new AjaxLink<Void>("ajaxLink") {

			@Override
			public void onClick(AjaxRequestTarget ajaxRequestTarget) {
				versionLabel.setDefaultModelObject("changed: " + versionLabel.getDefaultModelObject());
				ajaxRequestTarget.add(versionLabel);
			}
		});
	}
}
