package components.projecttracker;

import java.util.HashMap;
import java.util.Map;

/**
 * Kernel implementation for ProjectTracker.
 */
public class ProjectTracker1L extends ProjectTrackerSecondary {

    /**
     * Representation of a milestone.
     */
    private static class Milestone {
        String name;
        String description;
        String deadline;
        String status;

        /**
         * Constructs a {@code Milestone} with the specified name, description,
         * and deadline. The initial status is set to "Not started".
         *
         * @param name
         * @param description
         * @param deadline
         */
        Milestone(String name, String description, String deadline) {
            this.name = name;
            this.description = description;
            this.deadline = deadline;
            this.status = "Not started";
        }
    }

    /**
     * Representation: A map from milestone name to Milestone objects.
     *
     * Convention: All keys (milestone names) are unique, non-null, non-empty
     * strings.
     *
     * Correspondence: Each entry in the map represents a milestone in the
     * project tracker.
     */
    private Map<String, Milestone> milestones;

    /**
     * Constructor.
     */
    public ProjectTracker1L() {
        this.milestones = new HashMap<>();
    }

    @Override
    public void addMilestone(String milestoneName, String description,
            String deadline) {
        if (milestoneName == null || description == null || deadline == null
                || milestoneName.isEmpty()) {
            throw new IllegalArgumentException(
                    "Milestone inputs must be non-null and valid.");
        }
        this.milestones.put(milestoneName,
                new Milestone(milestoneName, description, deadline));
    }

    @Override
    public void removeMilestone(String milestoneName) {
        if (!this.milestones.containsKey(milestoneName)) {
            throw new IllegalArgumentException("Milestone does not exist.");
        }
        this.milestones.remove(milestoneName);
    }

    @Override
    public void updateMilestone(String milestoneName, String status) {
        Milestone m = this.milestones.get(milestoneName);
        if (m == null || status == null) {
            throw new IllegalArgumentException("Invalid milestone or status.");
        }
        m.status = status;
    }

    /**
     * Returns milestone information as a formatted string.
     *
     * @param milestoneName
     *            the name of the milestone to retrieve
     * @return details of the milestone
     */
    @Override
    public String getMilestoneInfo(String milestoneName) {
        Milestone m = this.milestones.get(milestoneName);
        if (m == null) {
            return "Milestone not found.";
        }
        return String.format(
                "Name: %s\nDescription: %s\nDeadline: %s\nStatus: %s", m.name,
                m.description, m.deadline, m.status);
    }

    @Override
    public void clear() {
        this.milestones.clear();
    }

    @Override
    public ProjectTracker1L newInstance() {
        return new ProjectTracker1L();
    }
}