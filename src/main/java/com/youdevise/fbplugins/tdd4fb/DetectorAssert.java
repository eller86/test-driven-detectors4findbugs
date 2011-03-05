/*
 * Mutability Detector
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * Further licensing information for this project can be found in 
 * 		license/LICENSE.txt
 */

package com.youdevise.fbplugins.tdd4fb;

import static com.youdevise.fbplugins.tdd4fb.internal.DetectorRunner.runDetectorOnClass;

import org.hamcrest.Matcher;

import com.youdevise.fbplugins.tdd4fb.internal.BugsReportedAsserter;
import com.youdevise.fbplugins.tdd4fb.internal.FindBugsMocks;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;

public class DetectorAssert {
	
	private static BugsReportedAsserter asserter = new BugsReportedAsserter();

	public static void assertBugReported(Class<?> classToTest, Detector detector,
										 BugReporter bugReporter, 
			                             Matcher<BugInstance> bugInstanceMatcher) 
										 throws Exception {
		runDetectorOnClass(detector, classToTest, bugReporter);
		asserter.assertBugReported(bugReporter, bugInstanceMatcher);
		
	}

	public static void assertBugReported(Class<?> classToTest, Detector detector, BugReporter bugReporter)
									     throws Exception {
		runDetectorOnClass(detector, classToTest, bugReporter);
		asserter.assertBugReported(bugReporter);
	}

	public static void assertNoBugsReported(Class<?> classToTest, Detector detector, BugReporter bugReporter) 
					   						throws Exception {
		runDetectorOnClass(detector, classToTest, bugReporter);
		asserter.assertNoBugsReported(bugReporter);
		
	}

	public static BugReporter bugReporterForTesting() {
		return FindBugsMocks.mockBugReporter();
	}

}
