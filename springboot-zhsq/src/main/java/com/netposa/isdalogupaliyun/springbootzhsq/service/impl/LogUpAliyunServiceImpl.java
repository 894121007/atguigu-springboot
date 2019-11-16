package com.netposa.isdalogupaliyun.springbootzhsq.service.impl;

import com.netposa.isdalogupaliyun.springbootzhsq.dao.LogUpAliyunDao;
import com.netposa.isdalogupaliyun.springbootzhsq.entities.LogUpAliyun;
import com.netposa.isdalogupaliyun.springbootzhsq.service.LogUpAliyunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/27 14:12
 *
 */
@Service
public class LogUpAliyunServiceImpl implements LogUpAliyunService {

	@Autowired
	private LogUpAliyunDao logUpAliyunDao;

	@Override
	public List<LogUpAliyun> getLog(LogUpAliyun logUpAliyun) {
		List<LogUpAliyun> log = logUpAliyunDao.getLog(logUpAliyun);
		return log;
	}

	@Override
	public int getMaxId() {
		return logUpAliyunDao.getMaxId();
	}
}
