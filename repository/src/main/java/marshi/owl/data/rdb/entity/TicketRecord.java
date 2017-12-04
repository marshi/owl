package marshi.owl.data.rdb.entity;

import java.util.Date;

public class TicketRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.project_id
     *
     * @mbggenerated
     */
    private Long projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.assignee_id
     *
     * @mbggenerated
     */
    private Integer assigneeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.deadline
     *
     * @mbggenerated
     */
    private Date deadline;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ticket.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.id
     *
     * @return the value of ticket.id
     *
     * @mbggenerated
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
     * @mbggenerated
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
     * @mbggenerated
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
     * @mbggenerated
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
     * @mbggenerated
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
     * @mbggenerated
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
     * @mbggenerated
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
     * @mbggenerated
     */
    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.deadline
     *
     * @return the value of ticket.deadline
     *
     * @mbggenerated
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ticket.deadline
     *
     * @param deadline the value for ticket.deadline
     *
     * @mbggenerated
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ticket.content
     *
     * @return the value of ticket.content
     *
     * @mbggenerated
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
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}