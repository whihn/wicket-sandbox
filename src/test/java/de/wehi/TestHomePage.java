package de.wehi;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Simple test using the WicketTester
 */
class TestHomePage {

	private WicketTester tester;

	@BeforeEach
	void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	void homepageRendersSuccessfully() {
		tester.startPage(HomePage.class);

		tester.assertRenderedPage(HomePage.class);
	}

	@Test
	void changes_label_text_when_ajaxLink_is_clicked() {
		// given
		tester.startPage(HomePage.class);

		// when
		tester.clickLink("ajaxLink");

		// then
		tester.assertLabel("version", "changed: 8.5.0");
	}

}
