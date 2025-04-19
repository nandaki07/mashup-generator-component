import components.projecttracker.Milestone;
import components.projecttracker.ProjectTracker;
import components.projecttracker.ProjectTracker1L;

public class ProjectManager {
    private ProjectTracker projectTracker;

    public ProjectManager() {
        this.projectTracker = new ProjectTracker1L(); // Using the ProjectTracker1L class
    }

    // Adding milestone progress
    public void updateMilestoneProgress(String milestoneName, String status) {
        Milestone milestone = this.projectTracker.getMilestones()
                .get(milestoneName);
        if (milestone != null) {
            milestone.setStatus(status); // Assume Milestone class has a setStatus method
            System.out.println(
                    "Updated " + milestoneName + " to status: " + status);
        } else {
            System.out.println("Milestone not found.");
        }
    }

    // Calculate and print overall project progress
    public void printProjectProgress() {
        double progress = this.projectTracker.calculateProgress();
        System.out.println("Overall Project Progress: " + progress + "%");
    }

    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();

        // Adding milestones
        manager.projectTracker.addMilestone("Initial Planning",
                new Milestone("Initial Planning", "2025-04-20"));
        manager.projectTracker.addMilestone("Design Phase",
                new Milestone("Design Phase", "2025-04-30"));

        // Updating and displaying progress
        manager.updateMilestoneProgress("Initial Planning", "Completed");
        manager.printProjectProgress();
    }
}
