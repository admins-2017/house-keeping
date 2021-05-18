package com.cloud.sys.controller;


import com.cloud.sys.service.IOperationRecordService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/sys/record")
public class OperationRecordController {

    private final IOperationRecordService recordService;

    public OperationRecordController(IOperationRecordService recordService) {
        this.recordService = recordService;
    }
}
