package com.splat.bms.controller;

import com.splat.bms.dto.ResponseDto;
import com.splat.bms.model.AdminAction;
import com.splat.bms.service.AdminActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class AdminActionRestController {

    @Autowired
    private AdminActionService adminActionService;

    @GetMapping("/get")
    public ResponseDto getAllActions() {
        return ResponseDto.getSuccess(this.adminActionService.getAllAdminActions());
    }

    @GetMapping("/get/by-admin-id/{id}")
    public List<AdminAction> getActionsByAdminId(@PathVariable int id) {
        return this.adminActionService.getAdminActionsByAdminId(id);
    }

    @GetMapping("/get/by-banner-id/{id}")
    public List<AdminAction> getActionsByBannerId(@PathVariable int id) {
        return this.adminActionService.getAdminActionsByBannerId(id);
    }

}
