package components.projecttracker;

/**
 * {@code ProjectTrackerKernel} enhanced with secondary methods.
 */

public interface ProjectTracker
        extends Comparable<ProjectTracker>, ProjectTrackerKernel {

    /**
     * Calculates the overall progress of a project based on the completed
     * milestones.
     *
     * @updates this
     * @ensures progress is calculated based on completed milestones
     */
    void calculateProgress();

    /**
     * Sends reminders for approaching milestones.
     *
     * @updates this
     * @ensures reminders are sent to relevant team members
     */
    void sendReminders();

    /**
     * Generates a progress report and exports it as a PDF file.
     *
     * @param fileName
     *            the name of the file to export the progress report to
     * @requires fileName is a valid string and writable
     * @ensures a progress report is generated and saved as a PDF file
     */
    void generateProgressReport(String fileName);

    /**
     * Sorts milestones by their approaching deadlines.
     *
     * @updates this
     * @ensures milestones are sorted in order of their deadlines
     */
    void sortMilestones();

    /**
     * Assigns a team member to a specific milestone and makes them the owner.
     *
     * @param milestoneName
     *            the name of the milestone to be assigned
     * @param owner
     *            the name of the team member to assign as the owner
     * @requires milestoneName and owner are valid strings
     * @ensures the specified milestone is assigned to the given owner
     */
    void assignMilestone(String milestoneName, String owner);

public class ProjectTracker {
    // Declare fields to represent different components of a project
    private String projectName;
    private int milestonesCompleted;
    private int totalMilestones;

    // Create a constructor
    public ProjectTracker(String projectName, int totalMilestones) {
        this.projectName = projectName;
        this.totalMilestones = totalMilestones;
        this.milestonesCompleted = 0;
    }

    // Method to update milestone completion
    public void updateMilestone() {
        if (this.milestonesCompleted < this.totalMilestones) {
            this.milestonesCompleted++;
            System.out.println(
                    "Milestone completed. " + this.milestonesCompleted + "/"
                            + this.totalMilestones + " milestones completed");
            System.out.println();
        } else {
            System.out.println("All milestones have alreaady been completed.");
            System.out.println();
        }
    }

    // Method to display project status
    public void displayStatus() {
        System.out.println("Project: " + this.projectName);
        System.out.println("Progress: " + this.milestonesCompleted + "/"
                + this.totalMilestones);
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        ProjectTracker project1 = new ProjectTracker("Limb Difference Product",
                4);
        project1.displayStatus();
        project1.updateMilestone();
        project1.updateMilestone();
        project1.displayStatus();
    }
}