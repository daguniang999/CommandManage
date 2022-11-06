package com.chenx.command.pojo.entity;

/**
 * 命令参数
 */
public class CommandArg {

    /**
     * ID
     */
    private String id;

    /**
     * 命令ID
     */
    private String commandId;

    /**
     * 简称
     */
    private String sortName;

    /**
     * 全称
     */
    private String fullName;

    /**
     * 描述
     */
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }
}
