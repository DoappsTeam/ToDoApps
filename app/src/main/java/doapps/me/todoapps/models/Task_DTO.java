package doapps.me.todoapps.models;

/**
 * Created by jonathan on 21/03/2015.
 */
public class Task_DTO {
    private int taskId;
    private String taskName;
    private String taskRate;
    private String taskDueDate;
    private String taskCreatedAt;
    private String taskUpdatedAt;
    private String taskState;
    private int verbId;
    private int objectId;

    public Task_DTO(){}

    public Task_DTO(int taskId, String taskName, String taskCreatedAt, String taskUpdatedAt, String taskRate, String taskDueDate, String taskState, int verbId, int objectId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskCreatedAt = taskCreatedAt;
        this.taskUpdatedAt = taskUpdatedAt;
        this.taskRate = taskRate;
        this.taskDueDate = taskDueDate;
        this.taskState = taskState;
        this.verbId = verbId;
        this.objectId = objectId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCreatedAt() {
        return taskCreatedAt;
    }

    public void setTaskCreatedAt(String taskCreatedAt) {
        this.taskCreatedAt = taskCreatedAt;
    }

    public String getTaskUpdatedAt() {
        return taskUpdatedAt;
    }

    public void setTaskUpdatedAt(String taskUpdatedAt) {
        this.taskUpdatedAt = taskUpdatedAt;
    }

    public String getTaskRate() {
        return taskRate;
    }

    public void setTaskRate(String taskRate) {
        this.taskRate = taskRate;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public int getVerbId() {
        return verbId;
    }

    public void setVerbId(int verbId) {
        this.verbId = verbId;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
