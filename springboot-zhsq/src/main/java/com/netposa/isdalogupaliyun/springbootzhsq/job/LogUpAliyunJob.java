package com.netposa.isdalogupaliyun.springbootzhsq.job;

import com.netposa.isdalogupaliyun.springbootzhsq.entities.LogUpAliyun;
import com.netposa.isdalogupaliyun.springbootzhsq.service.LogUpAliyunService;
import com.netposa.isdalogupaliyun.springbootzhsq.util.FileProperties;
import com.netposa.isdalogupaliyun.springbootzhsq.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 日志上云定时任务
 */
@Component
@DependsOn(value = {"fileUtil"})
public class LogUpAliyunJob {
	private Logger log = LoggerFactory.getLogger(LogUpAliyunJob.class);

	@Autowired
	private LogUpAliyunService logUpAliyunService;

	@Autowired
	private FileProperties fileProperties;

	//从实验中可以看出来，因为这个bean中有@PostConstruct，所以先初始化这个bean，然后再去初始化里面需要注入的bean
//	@Autowired
//	private FileUtil fileUtil;  //这里的这个fileUtil虽然没有用到，但是却让IOC容器去加载了这个bean，并初始化了里面的File
	//当然更好的方法不是 加一个不适用的fileUtil属性，而是让当前的类在FileUtil之前，被加载，
	// 在类上标注@DependsOn(value = {"fileUtil"}) fileUtil指的是bean名称

	private int startLogId; //查询需要推送的日志的时候，判断数据库中的id大于这个值的才推送

	/**
	 * 设置需要推送记录的最新id
	 */
	@PostConstruct
	public void setStartLogId() throws IOException {
		//读取写入文件中的最后一行的数据，截取到 记录id
//		String endLine = FileUtil.getEndLine();
//		if(!StringUtils.isEmpty(endLine)) {
//			// | 在正则里是个特殊字符,"|"等同于""，空或空的意思正确的写法是 "\\|" 或者 "[|]"
//			String[] split = endLine.split("[|]");
//			startLogId = Integer.parseInt(split[2]);
//		} else {
			//如果配置文件为空，就从当前时间开始推送
			startLogId = logUpAliyunService.getMaxId();
//		}
	}

	@Scheduled(fixedDelay = 5000L)
	public void upAliyun() throws IOException {
		log.info("定时任务执行...");

		//1、从数据库获取需要上云的数据，如果数据为空，直接结束掉
		LogUpAliyun logUpAliyun = new LogUpAliyun();
		logUpAliyun.setMaxId(startLogId);
		List<LogUpAliyun> logObject = logUpAliyunService.getLog(logUpAliyun);
		if (logObject.size() == 0) {log.info("没有新的日志需要推送，定时结束..."); return;}

		//2、将需要上云的数据拼接为阿里要求的字符串
		List<String> strings = appendStrToAliYun(logObject);

		//3、将拼接好的字符串，写入指定位置，指定文件名的文件中
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			FileUtil.write(str);
		}
		log.info("日志推送成功,定时任务结束");

		//4、调用重置方法，把id设为最大的。
		setStartLogId();
	}

	/**
	 * 拼接一个字符串给阿里云
	 */
	private List<String> appendStrToAliYun(List<LogUpAliyun> log) {
		List<String> result = new ArrayList<>();
		for (LogUpAliyun logUpAliyun : log) {
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(fileProperties.getProductID());
			stringBuffer.append("|").append(logUpAliyun.getProductName());
			stringBuffer.append("|").append(logUpAliyun.getLogID()); //记录id不会为空
			stringBuffer.append("|").append(logUpAliyun.getOperatorID()); //不需必传
			stringBuffer.append("|").append(logUpAliyun.getOperatorAccount());
			stringBuffer.append("|").append(logUpAliyun.getOperatorIdentity());
			stringBuffer.append("|").append(logUpAliyun.getOperatorName());
			stringBuffer.append("|").append(logUpAliyun.getOrganizationName());
			stringBuffer.append("|").append(logUpAliyun.getOrganizationID());
			stringBuffer.append("|").append(logUpAliyun.getOpTime());
			stringBuffer.append("|").append(logUpAliyun.getResTime());
			stringBuffer.append("|").append(logUpAliyun.getTerminalType());
			stringBuffer.append("|").append(logUpAliyun.getTerminalID());
			stringBuffer.append("|").append(logUpAliyun.getTerminalNum() == null ? "" : logUpAliyun.getTerminalNum());
			stringBuffer.append("|").append(logUpAliyun.getTerminalMac() == null ? "" : logUpAliyun.getTerminalMac());
			stringBuffer.append("|").append(logUpAliyun.getOpType());
			stringBuffer.append("|").append(logUpAliyun.getOperateCondition() == null ? "" : logUpAliyun.getOperateCondition());
			stringBuffer.append("|").append(logUpAliyun.getOperateResult());
			stringBuffer.append("|").append(logUpAliyun.getErrCode() == null ? "" : logUpAliyun.getErrCode());
			stringBuffer.append("|").append(logUpAliyun.getClientIp());
			stringBuffer.append("|").append(logUpAliyun.getClientPort());
			stringBuffer.append("|").append(logUpAliyun.getUrl());
			stringBuffer.append("|").append(logUpAliyun.getObjectParams() == null ? "" : logUpAliyun.getObjectParams());
			stringBuffer.append("|").append(logUpAliyun.getSessionID());
			stringBuffer.append("|").append(logUpAliyun.getFuncModuleName());
			stringBuffer.append("|").append(logUpAliyun.getObjectIP());
			stringBuffer.append("|").append(logUpAliyun.getObjectPort());
			stringBuffer.append("|").append(logUpAliyun.getQuerySql());
			result.add(stringBuffer.toString());
		}
		return result;
	}
}
