package components.projecttracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import components.projecttracker.ProjectTracker1L;
/**
 * JUnit 5 test cases for ProjectTracker1L.
 */
public class ProjectTracker1LTest {

    private ProjectTracker1L tracker;

    @BeforeEach
    public void setUp() {
        tracker = new ProjectTracker1L();
    }

    @Test
    public void testAddMilestone() {
        tracker.addMilestone("M1", "First task", "2025-05-01");
        String info = tracker.getMilestoneInfo("M1");
        assertTrue(info.contains("First task"));
        assertTrue(info.contains("Not started"));
    }

    @Test
    public void testRemoveMilestone() {
        tracker.addMilestone("M2", "Second task", "2025-06-01");
        tracker.removeMilestone("M2");
        String info = tracker.getMilestoneInfo("M2");
        assertEquals("Milestone not found.", info);
    }

    @Test
    public void testUpdateMilestone() {
        tracker.addMilestone("M3", "Third task", "2025-07-01");
        tracker.updateMilestone("M3", "Completed");
        String info = tracker.getMilestoneInfo("M3");
        assertTrue(info.contains("Completed"));
    }

    @Test
    public void testClearMilestones() {
        tracker.addMilestone("M4", "Fourtracker.clear();

    

    @Test
    public void testAssignMilestone() {
        tracker.addMilestone("M5", "Fifth task", "2025-09-01");
        tracker.assignMilestone("M5", "Jordan");
        String info = tracker.getMilestoneInfo("M5");
        assertTrue(info.contains("Owner: Jordan"));
    }

    @Test
    public void testCompareTo() {
        ProjectTracker1L other = new ProjectTracker1L();
        tracker.addMilestone("A", "Alpha", "2025-01-01");
        tracker.addMilestone("B", "Beta", "2025-02-01");

        other.addMilestone("C", "Gamma", "2025-03-01");

        assertTrue(tracker.compareTo(other) > 0);
        assertTrue(other.compareTo(tracker) < 0);
        other.addMilestone("D", "Delta", "2025-04-01");
        assertEquals(0, tracker.compareTo(other));
    }

    @Test
    public void testGenerateProgressReport() {
        // This just tests the method runs without exception.
        tracker.addMilestone("ReportTest", "Testing report", "2025-11-01");
        assertDoesNotThrow(() -> tracker.generateProgressReport("report"));
    }

    @Test
    public void testCalculateProgress() {
        tracker.addMilestone("P1", "Progress test 1", "2025-01-01");
        tracker.addMilestone("P2", "Progress test 2", "2025-01-02");

        tracker.updateMilestone("P1", "Completed");
        // This prints progress — you can improve this method to return the % for better testability.
        assertDoesNotThrow(() -> tracker.calculateProgress());
    }

    @Test
    public void testSortMilestones() {
        tracker.addMilestone("M3", "Sort test 3", "2025-12-15");
        tracker.addMilestone("M1", "Sort test 1", "2025-10-01");
        tracker.addMilestone("M2", "Sort test 2", "2025-11-01");

        assertDoesNotThrow(() -> tracker.sortMilestones());
    }

    @Test
    public void testToString() {
        tracker.addMilestone("Intro", "Project intro", "2025-04-01");
        String output = tracker.toString();
        assertTrue(output.contains("Intro"));

}
