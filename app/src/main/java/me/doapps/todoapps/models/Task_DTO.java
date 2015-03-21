package me.doapps.todoapps.models;

/**
 * Created by jonathan on 21/03/2015.
 */
public class Task_DTO {
    private int taskId;
    private String taskName;
    private int taskRate;
    private String taskDueDate;
    private String taskCreatedAt;
    private String taskUpdatedAt;
    private int taskState;
    private int verbId;
    private int objectId;
    private String verbName;
    private String objectName;

    public Task_DTO(){}

    public Task_DTO(int taskId, String taskName, String taskCreatedAt, String taskUpdatedAt, int taskRate, String taskDueDate, int taskState, int verbId, int objectId) {
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

    public Task_DTO(int taskId, String taskName, String taskDueDate, String taskUpdatedAt, String objectName, String verbName, int objectId, int verbId, int taskState, int taskRate, String taskCreatedAt) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDueDate = taskDueDate;
        this.taskUpdatedAt = taskUpdatedAt;
        this.objectName = objectName;
        this.verbName = verbName;
        this.objectId = objectId;
        this.verbId = verbId;
        this.taskState = taskState;
        this.taskRate = taskRate;
        this.taskCreatedAt = taskCreatedAt;
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

    public int getTaskRate() {
        return taskRate;
    }

    public void setTaskRate(int taskRate) {
        this.taskRate = taskRate;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public int getTaskState() {
        return taskState;
    }

    public void setTaskState(int taskState) {
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

    public String getVerbName() {
        return verbName;
    }

    public void setVerbName(String verbName) {
        this.verbName = verbName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
