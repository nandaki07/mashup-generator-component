package components.projecttracker;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class that implements the secondary methods of ProjectTracker.
 */
public abstract class ProjectTrackerSecondary implements ProjectTracker {

    /**
     * A list of milestones associated with the project. Each milestone contains
     * information like name, description, status, and deadline.
     */
    private final Map<Milestone, String> milestones;

    /**
     * Constructs a new {@code ProjectTrackerSecondary} instance. Initializes
     * the list of milestones to an empty {@code ArrayList}.
     */
    public ProjectTrackerSecondary() {
        this.milestones = new HashMap<>();
    }

    /**
     * Returns the map of milestones.
     *
     * @return A map where the key is the milestone name and the value is the
     *         milestone object.
     */
    @Override
    public Map<Milestone, String> getMilestones() {
        return this.milestones;
    }

    /**
     * Constant multiplier used to convert the progress to a percentage.
     */
    private static final double PERCENTAGE_MULTIPLIER = 100.0;

    /**
     * Returns a hash code value for this {@code ProjectTrackerSecondary}
     * object. The hash code is computed based on the list of milestones to
     * ensure consistency with the {@code equals} method.
     *
     * @return the hash code value for this object
     */
    @Override
    public int hashCode() {
        return this.milestones.hashCode();
    }

    /**
     * Compares this {@code ProjectTrackerSecondary} to the specified object for
     * equality. Two {@code ProjectTrackerSecondary} objects are considered
     * equal if they are of the same class and have the same list of milestones.
     *
     * @param obj
     *            the object to compare with
     * @return {@code true} if this object is equal to {@code obj},
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ProjectTrackerSecondary other = (ProjectTrackerSecondary) obj;
        return this.milestones.equals(other.milestones);
    }

    /**
     * Returns a string representation of this {@code ProjectTrackerSecondary}
     * object. The string includes the class name and a summary of all
     * milestones.
     *
     * @return a string representation of the project tracker
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(" with milestones:\n");

        // Iterate over the entries of the map (milestones)
        for (Map.Entry<Milestone, String> entry : this.milestones.entrySet()) {
            sb.append(" - Milestone Name: ").append(entry.getKey().name)
                    .append("\n   Description: ")
                    .append(entry.getKey().description)
                    .append("\n   Deadline: ").append(entry.getKey().deadline)
                    .append("\n   Status: ").append(entry.getKey().status)
                    .append("\n   Owner: ").append(entry.getValue()) // This is the value (String, presumably the owner)
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * Calculates the overall progress of a project based on the completed
     * milestones.
     */
    @Override
    public void calculateProgress() {
        int completed = 0;
        int total = this.getMilestoneNames().size();

        for (String milestone : this.getMilestoneNames()) {
            if (this.getMilestoneInfo(milestone).contains("Completed")) {
                completed++;
            }
        }
        System.out.println("Project Progress: "
                + ((double) completed / total * PERCENTAGE_MULTIPLIER) + "%");
    }

    /**
     * Sends reminders for approaching milestones.
     */
    @Override
    public void sendReminders() {
        Date today = new Date();
        for (Milestone milestone : this.milestones) {
            String deadline = milestone.getDeadline();
            if (this.isApproachingDeadline(deadline, today)) {
                System.out.println("Reminder: Milestone " + milestone
                        + " is approaching!");
            }
        }
    }

    /**
     * Generates a progress report and exports it as a PDF file.
     */
    @Override
    public void generateProgressReport(String fileName) {
        System.out
                .println("Generating progress report as " + fileName + ".pdf");
        // Actual PDF generation logic would be implemented here
    }

    /**
     * Sorts milestones by their approaching deadlines.
     */
    @Override
    public void sortMilestones() {
        int n = this.milestones.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare milestone dates
                if (this.milestones.get(j).getDeadline().compareTo(
                        this.milestones.get(j + 1).getDeadline()) > 0) {
                    // Swap milestones
                    Milestone temp = this.milestones.get(j);
                    this.milestones.set(j, this.milestones.get(j + 1));
                    this.milestones.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Assigns a team member to a specific milestone and makes them the owner.
     */
    @Override
    public void assignMilestone(String milestoneName, String owner) {
        String details = this.getMilestoneInfo(milestoneName);
        this.updateMilestone(milestoneName, details + " | Owner: " + owner);
        System.out.println(
                "Milestone " + milestoneName + " assigned to " + owner);
    }

    @Override
    public int compareTo(ProjectTracker proj) {
        int thisSize = this.getMilestones().size();
        int otherSize = 0;

        if (proj instanceof ProjectTrackerSecondary) {
            otherSize = ((ProjectTrackerSecondary) proj).getMilestones.size();
        } else {
            throw new IllegalArgumentException(
                    "Incompatible ProjectTracker type for comparison.");
        }
        return Integer.compare(thisSize, otherSize);
    }

    /**
     * Helper method to get all milestone names.
     *
     * @return list of milestone names
     */
    protected abstract List<String> getMilestoneNames();

    /**
     * Helper method to get the deadline of a milestone.
     *
     * @param milestoneName
     *            the name of the milestone
     * @return the deadline of the milestone
     */
    protected abstract String getMilestoneDeadline(String milestoneName);

    /**
     * Helper method to check if a deadline is approaching.
     *
     * @param deadline
     *            the deadline date as a string
     * @param today
     *            today's date
     * @return true if the milestone is approaching, false otherwise
     */
    private boolean isApproachingDeadline(String deadline, Date today) {
        // Placeholder logic for deadline comparison
        return true;
    }
}
