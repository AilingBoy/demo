//package com.example.demo.task;
//
//import com.cn.hz.info.common.finance.option.FinanceManageFunctionsection;
//import com.cn.hz.info.common.mapper.finance.option.FinanceManageFunctionsectionMapper;
//import com.cn.hz.info.common.mapper.sys.SysOrganizationMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <p>
// *
// * @author stardust
// * @version 1.0.0
// * 2019/9/11  20:20
// * <p>
// * 缓存数据刷新
// */
//@Component
//@Slf4j
//public class CacheDataRefreshTask {
//
//    @Autowired
//    private SysOrganizationMapper organizationMapper;
//
//    @Autowired
//    private FinanceManageFunctionsectionMapper functionSectionMapper;
//
//    private static ThreadLocal<List<?>> tThreadLocal = new ThreadLocal<>();
//
//    private List<FinanceManageFunctionsection> functionSections = new ArrayList<>();
//
//    public List<FinanceManageFunctionsection> getFunctionSections() {
//        synchronized (functionSections){
//            if(functionSections.size() == 0){
//                refreshFunctionSectionList();
//            }
//        }
//        tThreadLocal.set(functionSections);
//        return (List<FinanceManageFunctionsection>)tThreadLocal.get();
//    }
//
//    /**
//     * 每天1点刷新,到缓存
//     */
//    @Scheduled(cron = "0 0 1 * * ?")
//    private void refreshFunctionSectionList() {
//        log.info("Start Refresh FunctionSectionList Data......");
//        int year = LocalDate.now().getYear();
//        functionSections = functionSectionMapper.list(year);
//    }
//}