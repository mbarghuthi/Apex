package com.automation.test_runner;

import com.automation.configuration.ProjectConfiguration;
import com.automation.jbehave.ConsoleLogger;
import com.automation.jbehave.JBehaveReportFormatter;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AllStoriesTest extends JBehaveReportFormatter {

	private static final String STORY_NAME_PATTERN_ApexTest= "*ApexTest*";
	private static final String STORY_NAME = "*";

	public AllStoriesTest() {
		configuredEmbedder().embedderControls()
				.doIgnoreFailureInStories(false)
				.doIgnoreFailureInView(false)
				.doVerboseFailures(true)
				.doFailOnStoryTimeout(true);
	}

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}

	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()),

//				String.format("stories/**/%s.story", STORY_NAME_PATTERN_ApexTest.trim()), "");
				String.format("stories/TC_001_ApexTest.story", STORY_NAME.trim()), "");



//				String.format("stories/**/**/%s.story", STORY_NAME.trim()), "");
// 				String.format("stories/ControlAndMonitering/**/%s.story", STORY_NAME.trim()), "");
//				String.format("stories/FGA/**/%s.story", STORY_NAME.trim()), "");
// 				String.format("stories/Login/**/%s.story", STORY_NAME.trim()), "");
// 				String.format("stories/Quotation/**/%s.story", STORY_NAME.trim()), "");

//				String.format("stories/Login/TC_002_Apex.story", STORY_NAME.trim()), "");
//				String.format("stories/Quotation/TC_002_Apex.story", STORY_NAME.trim()), "");
//				String.format("stories/ControlAndMonitering/TC_006_Apex.story", STORY_NAME.trim()), "");
//				String.format("stories/FGA/TC_004_Apex.story", STORY_NAME.trim()), "");
	}


	private static final String SPECIFIC_STORY = "stories/Quotation/TC_001_Apex.story";
	private static final int RUN_COUNT = 3;

// For running the story multiple times
//	public List<String> storyPaths() {
//		List<String> paths = new ArrayList<>();
//		for (int i = 0; i < RUN_COUNT; i++) {
//			paths.add(SPECIFIC_STORY);
//		}
//		return paths;
//	}

	@Override
	public void run() throws Throwable {
		// reset failure tracker before every full run
		com.automation.jbehave.ConsoleLogger.resetFailures();

		try {
			super.run();
		} catch (Throwable t) {
			throw new RuntimeException("JBehave execution failed", t);
		}

		// Force Maven/JUnit failure if any story/step failed in JBehave
		if (com.automation.jbehave.ConsoleLogger.hasFailures()) {
			throw new RuntimeException("JBehave detected failed stories. Failing Maven build.");
		}
	}

}


