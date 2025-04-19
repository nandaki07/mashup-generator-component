package components.projecttracker;

import java.util.Map;

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

    /**
     * Returns the map of milestones.
     *
     * @return A map where the key is the milestone name and the value is the
     *         milestone object.
     */
    public Map<Milestone, String> getMilestones();
}
