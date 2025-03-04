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