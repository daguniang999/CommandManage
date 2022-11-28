package com.chenx.command.pojo.dto;

import com.chenx.command.pojo.dto.CommandArgDTO;
import lombok.Data;

import java.util.List;

/**
 * @ClassName CommandAddDTO
 * @Description 命令添加DTO
 * @Author daguniang
 * @Date 2022/11/27 17:58
 **/
@Data
public class CommandAddDTO {

    /**
     * 命令ID
     */
    private Long commandId;

    /**
     * 命令名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 命令组ID
     */
    private Long groupId;

    /**
     * 命令参数列表
     */
    private List<CommandArgDTO> commandArgList;

}
