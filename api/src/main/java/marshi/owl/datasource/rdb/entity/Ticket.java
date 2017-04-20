package marshi.owl.datasource.rdb.entity;

public class Ticket {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.project_id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    private Long projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.title
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.assignee_id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    private Integer assigneeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.content
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.id
     *
     * @return the value of ticket.id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ticket.id
     *
     * @param id the value for ticket.id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.project_id
     *
     * @return the value of ticket.project_id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ticket.project_id
     *
     * @param projectId the value for ticket.project_id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.title
     *
     * @return the value of ticket.title
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ticket.title
     *
     * @param title the value for ticket.title
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.assignee_id
     *
     * @return the value of ticket.assignee_id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public Integer getAssigneeId() {
        return assigneeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ticket.assignee_id
     *
     * @param assigneeId the value for ticket.assignee_id
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.content
     *
     * @return the value of ticket.content
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ticket.content
     *
     * @param content the value for ticket.content
     *
     * @mbggenerated Thu Apr 20 23:58:39 JST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}