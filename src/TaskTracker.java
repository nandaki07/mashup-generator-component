import java.util.Map;

import components.projecttracker.Milestone;
import components.projecttracker.ProjectTracker;
import components.projecttracker.ProjectTracker1L;

public class TaskTracker {
    private ProjectTracker projectTracker;

    public TaskTracker() {
        this.projectTracker = new ProjectTracker1L(); // Using ProjectTracker1L class from your component
    }

    // Adding a new milestone to the project
    public void addTask(String taskName, String dueDate) {
        Milestone newTask = new Milestone(taskName, dueDate); // Milestone could represent a task
        this.projectTracker.addMilestone(taskName, newTask);
    }

    // Display the current milestones
    public void showMilestones() {
        System.out.println("Current Milestones:");
        for (Map.Entry<String, Milestone> entry : this.projectTracker
                .getMilestones().entrySet()) {
            System.out.println("Task: " + entry.getKey() + ", Due Date: "
                    + entry.getValue().getDueDate());
        }
    }

    public static void main(String[] args) {
        TaskTracker taskTracker = new TaskTracker();
        taskTracker.addTask("Complete Documentation", "2025-05-01");
        taskTracker.addTask("Finish Unit Testing", "2025-05-10");
        taskTracker.showMilestones();
    }
}
