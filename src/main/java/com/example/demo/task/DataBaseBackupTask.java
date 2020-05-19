//package com.example.demo.task;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.LocalDate;
//
///**
// * <p>
// *
// * @author stardust
// * @version 1.0.0
// * 2019/9/3  10:32
// * 数据库备份定时器
// * <p>
// * 交由linux本身做定时器备份 *
// */
////@Component
//@Slf4j
//public class DataBaseBackupTask {
//
//    /**
//     * 每天备份数据库
//     */
//    @Scheduled(cron = "0 0 0 * * ?")
//    private void backupDB() {
//        LocalDate localDate = LocalDate.now();
//        log.info("Start To Backup DATABASE......");
//        try {
//            backupDb(localDate.toString());
//            backupActiviti(localDate.toString());
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//    }
//
//    public void backupDb(String fileName) throws Exception {
//        String cmd = "mysqldump -h 10.71.165.131 -uyhqshjzyglj -p7_uoICaF --databases hzyh > /usr/local/nginx/html/jar/DB_Backup/hzyh_" + fileName + ".sql";
///**
// *      Oracle 数据库备份命令
// *      String cmd = "exp ORACLE_HZDB/ORACLE_HZDB file=/usr/local/nginx/html/jar/hangzhouYH/DB_Backup/hzyhdb_"+ fileName +".dmp owner=ORACLE_HZDB";
// */
//        log.info(cmd);
//        Process process = Runtime.getRuntime().exec(cmd);
//        process.waitFor();
//    }
//
//    public void backupActiviti(String fileName) throws Exception {
//        String cmd = "mysqldump -h 10.71.165.131 -uyhqshjzyglj -p7_uoICaF --databases activiti > /usr/local/nginx/html/jar/DB_Backup/activiti" + fileName + ".sql";
///**
// *      Oracle 数据库备份命令
// *      String cmd = "exp ACTIVITI/ACTIVITI file=/usr/local/nginx/html/jar/hangzhouYH/DB_Backup/hzyhactiviti_"+ fileName +".dmp owner=ACTIVITI";
// *
// */
//        log.info(cmd);
//        Process process = Runtime.getRuntime().exec(cmd);
//        process.waitFor();
//    }
//}