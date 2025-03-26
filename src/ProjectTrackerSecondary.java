import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@code ProjectTrackerSecondary} provides an abstract implementation of the
 * {@code ProjectTracker} interface, which is responsible for tracking project
 * milestones. It includes methods to calculate project progress, send reminders
 * for approaching milestones, generate progress reports, sort milestones by
 * deadlines, and assign milestones to team members.
 *
 * This class uses a list of {@code Milestone} objects to manage and manipulate
 * milestone-related data. The class must be extended to implement methods for
 * handling milestone names and other project-specific details.
 */
public abstract class ProjectTrackerSecondary implements ProjectTracker {

    /**
     * A list of milestones associated with the project. Each milestone contains
     * information like name, description, status, and deadline.
     */
    private List<Milestone> milestones;

    /**
     * Constructs a new {@code ProjectTrackerSecondary} instance. Initializes
     * the list of milestones to an empty {@code ArrayList}.
     */
    public ProjectTrackerSecondary() {
        this.milestones = new ArrayList<>();
    }

    /**
     * Constant multiplier used to convert the progress to a percentage.
     */
    private static final double PERCENTAGE_MULTIPLIER = 100.0;

    /**
     * Calculates the overall progress of a project based on the completed
     * milestones.
     *
     * @updates this
     * @ensures progress is calculated based on completed milestones
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
     *
     * @updates this
     * @ensures reminders are sent to relevant team members
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
     *
     * @param fileName
     *            the name of the file to export the progress report to
     * @requires fileName is a valid string and writable
     * @ensures a progress report is generated and saved as a PDF file
     */
    @Override
    public void generateProgressReport(String fileName) {
        System.out
                .println("Generating progress report as " + fileName + ".pdf");
        // Actual PDF generation logic would be implemented here
    }

    /**
     * Sorts milestones by their approaching deadlines.
     *
     * @updates this
     * @ensures milestones are sorted in order of their deadlines
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
     *
     * @param milestoneName
     *            the name of the milestone to be assigned
     * @param owner
     *            the name of the team member to assign as the owner
     * @requires milestoneName and owner are valid strings
     * @ensures the specified milestone is assigned to the given owner
     */
    @Override
    public void assignMilestone(String milestoneName, String owner) {
        String details = this.getMilestoneInfo(milestoneName);
        this.updateMilestone(milestoneName, details + " | Owner: " + owner);
        System.out.println(
                "Milestone " + milestoneName + " assigned to " + owner);
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
