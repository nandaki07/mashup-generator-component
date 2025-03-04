package components.projecttracker;

import components.standard.Standard;

/**
 * {@code ProjectTrackerKernel} defines the core functionality for tracking
 * project milestones.
 *
 * The purpose is to provide a project tracker that helps businesses track and
 * plan their projects.
 */
public interface ProjectTrackerKernel extends Standard<ProjectTracker> {

    /**
     * Adds a milestone to the project tracker with a name, description, and
     * deadline.
     *
     * @param milestoneName
     *            the name of the milestone
     * @param description
     *            a brief description of the milestone
     * @param deadline
     *            the deadline for the milestone
     * @requires milestoneName, description, and deadline are valid non-null
     *           strings
     * @ensures a new milestone is added to the project tracker
     */
    void addMilestone(String milestoneName, String description,
            String deadline);

    /**
     * Removes a milestone from the project tracker that was previously added.
     *
     * @param milestoneName
     *            the name of the milestone to be removed
     * @requires milestoneName is a valid non-null string
     * @ensures the specified milestone is removed from the project tracker
     */
    void removeMilestone(String milestoneName);

    /**
     * Updates the status of a milestone (e.g., "In progress", "Not started",
     * "Completed").
     *
     * @param milestoneName
     *            the name of the milestone to update
     * @param status
     *            the new status of the milestone
     * @requires milestoneName and status are valid non-null strings
     * @ensures the milestone's status is updated accordingly
     */
    void updateMilestone(String milestoneName, String status);

    /**
     * Returns the information about a specific milestone.
     *
     * @param milestoneName
     *            the name of the milestone to retrieve information for
     * @return a string containing details of the milestone
     * @requires milestoneName is a valid non-null string
     * @ensures the milestone information is retrieved and returned as a string
     */
    String getMilestoneInfo(String milestoneName);

}
