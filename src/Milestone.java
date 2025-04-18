public class Milestone {
    /** The name of the milestone. */
    private String name;
    /** A brief description of the milestone. */
    private String description;
    /** The deadline for completing the milestone (format: YYYY-MM-DD). */
    private String deadline;

    /**
     * Constructs a new milestone with the specified name, description, and
     * deadline.
     *
     * @param name
     *            the name of the milestone
     * @param description
     *            a brief description of the milestone
     * @param deadline
     *            the deadline for the milestone in YYYY-MM-DD format
     */
    public Milestone(String name, String description, String deadline) {
        this.name = name;
        this.description = description;

        this.deadline = deadline;
    }

    /**
     * Retrieves the deadline of the milestone.
     *
     * @return the deadline of the milestone as a string in YYYY-MM-DD format.
     */
    public String getDeadline() {
        return this.deadline;
    }
}
