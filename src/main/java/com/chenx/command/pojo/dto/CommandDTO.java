package com.chenx.command.pojo.dto;

import com.chenx.command.pojo.dto.CommandArgDTO;
import lombok.Data;
import java.util.List;

/**
 * 命令dto
 *
 * @ClassName CommandDTO
 * @Description 命令DTO
 * @Author daguniang
 * @Date 2022/11/6 10:53
 **/
@Data
public class CommandDTO {

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
     * 命令参数列表
     */
    private List<CommandArgDTO> commandArgList;

}
