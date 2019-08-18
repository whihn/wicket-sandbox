package de.wehi;

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

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		// TODO Add your page's components here

	}
}
