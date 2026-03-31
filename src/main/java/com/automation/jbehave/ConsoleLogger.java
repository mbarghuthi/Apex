package com.automation.jbehave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.NullStoryReporter;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.stereotype.Component;

import com.automation.jbehave.format.PropertyConverter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Component
public class ConsoleLogger extends NullStoryReporter {

	private static final Logger log = Logger.getLogger(ConsoleLogger.class);

	// Report Declarations
	private static ExtentReports extent;

	private static synchronized ExtentReports getExtent() {
		if (extent == null) {
			extent = ReportManager.createInstance();
		}
		return extent;
	}
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	// Track all stories summary
	private static final List<String> passedStories = Collections.synchronizedList(new ArrayList<>());
	private static final List<String> failedStories = Collections.synchronizedList(new ArrayList<>());

	private final ThreadLocal<Boolean> runningStoryStatus = new ThreadLocal<>();
	private final ThreadLocal<Story> storyThreadLocal = new ThreadLocal<>();

	private WebDriver driver;
	private final WebDriverProvider webDriverProvider;

	public ConsoleLogger(WebDriverProvider webDriverProvider) {
		Locale.setDefault(Locale.ENGLISH);
		this.webDriverProvider = webDriverProvider;
	}

//	@Override
	public void beforeStories() {
		passedStories.clear();
		failedStories.clear();

		log.info("==========================================================");
		log.info("BEGIN EXECUTION");
		log.info("==========================================================");
	}

//	@Override
	public void afterStories() {
	printSummary();

	try {
		if (extent != null) {
			getExtent().flush();
			getExtent().close();
		}
	} catch (Exception e) {
		log.error("Failed to close extent report", e);
	}

	try {
		WebDriver webDriver = webDriverProvider.get();
		if (webDriver != null) {
			webDriver.quit();
		}
	} catch (Exception e) {
		log.error("Failed to quit WebDriver in afterStories", e);
	}

	test.remove();
	extentTest.remove();
	runningStoryStatus.remove();
	storyThreadLocal.remove();
}

	@Override
	public void storyNotAllowed(Story story, String filter) {
		log.info(String.format("%s (NOT ALLOWED [filter: %s])", story, filter));
	}

	@Override
	public void storyCancelled(Story story, StoryDuration storyDuration) {
		log.info(String.format("%s (CANCELLED [duration: %s])", story, storyDuration));
	}

	@Override
	public void beforeStory(Story story, boolean givenStory) {
		this.storyThreadLocal.set(story);

		if (!story.getName().equals("BeforeStories") && !story.getName().equals("AfterStories")) {
			this.runningStoryStatus.set(true);
			reportBeforeStory(story);
		}
	}

	private void reportBeforeStory(Story story) {
		log.info("==========================================================");
		log.info("Begin Story: " + story.getName());
		log.info("==========================================================");
	}

	@Override
	public void afterStory(boolean givenStory) {
		Story story = this.storyThreadLocal.get();

		if (story != null && story.getName() != null
				&& !story.getName().equals("BeforeStories")
				&& !story.getName().equals("AfterStories")) {

			boolean isPassed = Boolean.TRUE.equals(this.runningStoryStatus.get());

			if (isPassed) {
				passedStories.add(story.getName());
			} else {
				failedStories.add(story.getName());
			}

			reportAfterStory(story, isPassed);
		}
	}

	private void printSummary() {
		log.info("==========================================================");
		log.info("FINAL STORIES EXECUTION SUMMARY");
		log.info("==========================================================");

		log.info("PASSED STORIES COUNT: " + passedStories.size());
		for (String storyName : passedStories) {
			log.info("[PASSED] " + storyName);
		}

		log.info("FAILED STORIES COUNT: " + failedStories.size());
		for (String storyName : failedStories) {
			log.info("[FAILED] " + storyName);
		}

		log.info("==========================================================");
		log.info("TOTAL STORIES: " + (passedStories.size() + failedStories.size()));
		log.info("==========================================================");
	}

	private void reportAfterStory(Story story, boolean isPassed) {
		String status = isPassed ? "PASSED" : "FAILED";

		log.info("==========================================================");
		log.info("End Story: " + story.getName());
		log.info("Status: " + status);
		log.info("==========================================================");
	}

	@Override
	public void narrative(Narrative narrative) {
		log.info(narrative.toString());
	}

	@Override
	public void lifecyle(Lifecycle lifecycle) {
		log.info(lifecycle.toString());
	}

	@Override
	public void scenarioNotAllowed(Scenario scenario, String filter) {
		log.info(String.format("%s (NOT ALLOWED [filter: %s])", scenario, filter));
	}

	@Override
	public void beforeScenario(String scenarioTitle) {
		String scenarioKey;
		String scenarioName;

		if (scenarioTitle.contains(" ")) {
			scenarioKey = scenarioTitle.substring(0, scenarioTitle.indexOf(" ")).trim();
			scenarioName = scenarioTitle.substring(scenarioTitle.indexOf(" ")).trim();
		} else {
			scenarioKey = scenarioTitle.trim();
			scenarioName = scenarioTitle.trim();
		}

		ExtentTest currentTest = getExtent().startTest(scenarioName, scenarioKey);
		extentTest.set(currentTest);
		test.set(currentTest);
		getExtent().flush();

		log.info("==========================================================");
		log.info("Scenario: " + scenarioKey);
		log.info("==========================================================");
	}

	@Override
	public void scenarioMeta(Meta meta) {
		log.info(meta.toString());
	}

	@Override
	public void afterScenario() {
		ExtentTest currentTest = extentTest.get();
		if (currentTest != null) {
			getExtent().endTest(currentTest);
			getExtent().flush();
		}
	}

	@Override
	public void givenStories(GivenStories givenStories) {
	}

	@Override
	public void givenStories(List<String> storyPaths) {
	}

	@Override
	public void beforeExamples(List<String> steps, ExamplesTable table) {
	}

	@Override
	public void example(Map<String, String> tableRow) {
	}

	@Override
	public void afterExamples() {
	}

	@Override
	public void beforeStep(String step) {
	}

	@Override
	public void successful(String step) {
		if (test.get() != null) {
			test.get().log(LogStatus.PASS, PropertyConverter.convert(step));
			getExtent().flush();
		}

		log.info(String.format("%s (SUCCESSFUL)", step));
	}

	@Override
	public void ignorable(String step) {
		log.info(String.format("%s (IGNORED)", step));
	}

	@Override
	public void pending(String step) {
		if (test.get() != null) {
			test.get().log(LogStatus.ERROR, PropertyConverter.convert(step));
		}

		log.info(String.format("%s (PENDING)", step));
		this.runningStoryStatus.set(false);
	}

	@Override
	public void notPerformed(String step) {
		if (test.get() != null) {
			test.get().log(LogStatus.SKIP, PropertyConverter.convert(step));
		}

		log.info(String.format("%s (NOT PERFORMED)", step));
	}

	@Override
	public void failed(String step, Throwable cause) {
		if (test.get() != null) {
			test.get().log(LogStatus.FAIL, PropertyConverter.convert(step));

			if (cause != null && cause.getCause() != null) {
				test.get().log(LogStatus.INFO, cause.getCause().getMessage());
				log.error(cause.getCause());
			} else if (cause != null && cause.getMessage() != null) {
				test.get().log(LogStatus.INFO, cause.getMessage());
				log.error(cause);
			} else {
				test.get().log(LogStatus.INFO, "Unknown error occurred");
				log.error("Unknown error occurred");
			}

			String screenshotBase64 = captureScreenshot();
			if (screenshotBase64 != null && !screenshotBase64.isEmpty()) {
				test.get().log(LogStatus.INFO, "Screenshot of the failure",
						"<img src='data:image/png;base64," + screenshotBase64 + "' />");
			}

			getExtent().flush();
		}

		this.runningStoryStatus.set(false);
		log.info(String.format("%s (FAILED)", step));
	}

	@Override
	public void failedOutcomes(String step, OutcomesTable table) {
		this.runningStoryStatus.set(false);
	}

	@Override
	public void restarted(String step, Throwable cause) {
	}

	@Override
	public void restartedStory(Story story, Throwable throwable) {
		this.runningStoryStatus.set(false);
	}

	@Override
	public void dryRun() {
	}

	@Override
	public void pendingMethods(List<String> methods) {
	}

	public String captureScreenshot() {
		driver = webDriverProvider.get();
		if (driver == null) {
			log.error("WebDriver instance is null. Cannot capture screenshot.");
			return null;
		}

		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
			log.info("Screenshot saved successfully");
			return base64Code;
		} catch (WebDriverException e) {
			log.error("Failed to capture screenshot: " + e.getMessage());
			return null;
		}
	}
}