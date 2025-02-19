package net.thucydides.junit.runners

import net.thucydides.model.domain.TestOutcome

class TestOutcomeChecks {

    static TestOutcomeChecker resultsFrom(List<TestOutcome> testOutcomes) {
        new TestOutcomeChecker(testOutcomes)
    }

    static class TestOutcomeChecker {
        private final List<TestOutcome> testOutcomes

        TestOutcomeChecker(List<TestOutcome> testOutcomes) {
            this.testOutcomes = testOutcomes
        }

        TestOutcome getAt(String methodName) {
            def matchingOutcome = testOutcomes.find { it.name.equals(methodName) }
            if (!matchingOutcome) {
                throw new AssertionError("No matching test method called $methodName")
            }
            return matchingOutcome
        }

        boolean isEmpty() {
            return testOutcomes.isEmpty()
        }
    }
}
