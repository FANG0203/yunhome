package com.mrfang.yunhome.task;

import com.mrfang.yunhome.domain.SignContract;
import com.mrfang.yunhome.service.ISignContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @ Author: Fang
 * @ Date: 2022/11/30 16:32
 * @ Project: RuoYi
 */

@EnableScheduling   //开启定时任务
@Component
public class MyTask {

    @Autowired
    private ISignContractService signContractService;

    //每天凌晨0点时执行该任务
    @Scheduled(cron = "0 0 0 * * ?")
    public void checkSignTime(){
        //得到所有签约中的记录
        List<SignContract> list = signContractService.list(1L);
        //取得当前日期
        LocalDate now = LocalDate.now();

        for (int i = 0; i < list.size(); i++) {
            SignContract signContract = list.get(i);
            String endTime = signContract.getEndTime();
            //将每条记录的结束时间转为localDate
            LocalDate endTime1 = LocalDate.parse(endTime);
            if(now.isAfter(endTime1)){
                signContractService.updateStatus(signContract.getId(), 2L);
            }
        }
    }

}
