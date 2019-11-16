package com.netposa.isdalogupaliyun.springbootzhsq.dao;

import com.netposa.isdalogupaliyun.springbootzhsq.entities.LogUpAliyun;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/27 14:13
 *
 */
@Mapper
public interface LogUpAliyunDao {

	List<LogUpAliyun> getLog(LogUpAliyun logUpAliyun);

	int getMaxId();
}
