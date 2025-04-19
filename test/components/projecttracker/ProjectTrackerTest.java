package components.projecttracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for ProjectTracker1L.
 */
public class ProjectTrackerTest {

    private ProjectTracker1L tracker;

    @BeforeEach
    public void setUp() {
        tracker = new ProjectTracker1L();
    }

    @Test
    public void testAddMilestone() {
        tracker.addMilestone("Design", "Create design docs", "2025-05-01");
        String info = tracker.getMilestoneInfo("Design");
        assertTrue(info.contains("Create design docs"));
        assertTrue(info.contains("Not started"));
    }

    @Test
    public void testUpdateMilestoneStatus() {
        tracker.addMilestone("Implementation", "Develop features", "2025-06-01");
        tracker.updateMilestone("Implementation", "In Progress");
        String info = tracker.getMilestoneInfo("Implementation");
        assertTrue(info.contains("In Progress"));
    }

    @Test
    public void testRemoveMilestone() {
        tracker.addMilestone("Testing", "Write tests", "2025-07-01");
        tracker.removeMilestone("Testing");
        String info = tracker.getMilestoneInfo("Testing");
        assertEquals("Milestone not found.", info);
    }

    @Test
    public void testAssignMilestone() {
        tracker.addMilestone("Review", "Peer review code", "2025-08-01");
        tracker.assignMilestone("Review", "Alice");
        String info = tracker.getMilestoneInfo("Review");
        assertTrue(info.contains("Owner: Alice"));
    }

    @Test
    public void testCalculateProgress() {
        tracker.addMilestone("M1", "Step 1", "2025-01-01");
        tracker.addMilestone("M2", "Step 2", "2025-02-01");
        tracker.updateMilestone("M1", "Completed");
        tracker.updateMilestone("M2", "Not started");
        // This prints to stdout, you may redirect System.out to test actual output
        tracker.calculateProgress();
    }

    @Test
    public void testCompareTo() {
        ProjectTracker1L other = new ProjectTracker1L();
        tracker.addMilestone("M1", "A", "2025-01-01");
        tracker.addMilestone("M2", "B", "2025-01-02");

        other.addMilestone("M3", "C", "2025-01-03");

        assertTrue(tracker.compareTo(other) > 0);
    }

    @Test
    public void testClear() {
        tracker.addMilestone("Cleanup", "Clean data", "2025-10-01");
        tracker.clear();
        assertEquals("Milestone not found.", tracker.getMilestoneInfo("Cleanup"));
    }
}
