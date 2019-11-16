package com.netposa.isdalogupaliyun.springbootzhsq.service;

import com.netposa.isdalogupaliyun.springbootzhsq.entities.LogUpAliyun;

import java.util.List;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/27 14:00
 *
 */
public interface LogUpAliyunService {

	List<LogUpAliyun> getLog(LogUpAliyun logUpAliyun);

	int getMaxId();
}
