package com.qiafengqishi.nuoya.web.WorkOrder;


import com.qiafengqishi.nuoya.domain.WorkCase;
import com.qiafengqishi.nuoya.web.AjaxResult;
import com.qiafengqishi.nuoya.web.WorkOrder.command.WorkOrderAddCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/workorder")
@ResponseBody
@Slf4j
public class WorkOrderController {

    @Autowired
    private WorkOrderFacade workOrderFacade;


    /**
     * 注册
     * @param registerCommand
     * @return
     */
    @PostMapping(value = "/register")
    public String register(@RequestBody WorkOrderAddCommand registerCommand) {
        if (!registerCommand.isValid()) {
            return AjaxResult.failAlert("信息错误！");
        }
        workOrderFacade.newWorkOrder(registerCommand);


        return AjaxResult.success();
    }

    @GetMapping(value = "/id/{id}")
    public String queryById(@PathVariable("id") Long id) {
        if (null == id) {
            return AjaxResult.failAlert("信息错误！");
        }
        WorkCase workCase = workOrderFacade.getById(id);


        return AjaxResult.success(workCase);
    }

//    @GetMapping(value = "/{bizId}")
//    public String queryByBizId(@PathVariable("bizId") String bizId) {
//        if (null == bizId) {
//            return AjaxResult.failAlert("信息错误！");
//        }
////        WorkCase workCase = workOrderFacade.getByBizId(bizId);
//
//
//        return AjaxResult.success();
//    }
}
