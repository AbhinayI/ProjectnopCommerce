package com.nopCommerceTestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopCommerceBase.TestBase;
import com.nopCommercePOMClasses.IndexPage;

public class IndexPageTest extends TestBase {

	IndexPage index;

	@BeforeMethod
	public void set() {
		index = new IndexPage(driver);
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyIndexPageTitle() throws IOException {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyIndexPageTitle");
		String title = index.getIndexPageTitle();
		log.info("Index Page Title is:" + title);
		Assert.assertEquals(title, "nopCommerce demo storeubk");
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyIndexPageLogo() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyIndexPageLogo");
		boolean result = index.validateLogo();
		Assert.assertTrue(result);
		log.info("=========== Test Case End ===========");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyFollowLinksClickable() {
		log.info("=========== Test Case Start ===========");
		log.info("Test - verifyFollowLinksClickable");
		log.info("All follow links clicked and titles are:");
		index.getClickOnFollowLinks();
		log.info("=========== Test Case End ===========");
	}
}
