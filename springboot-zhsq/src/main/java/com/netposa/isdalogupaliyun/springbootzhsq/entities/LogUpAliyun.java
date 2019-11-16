package com.netposa.isdalogupaliyun.springbootzhsq.entities;

import lombok.Data;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/27 14:04
 *
 */
@Data
public class LogUpAliyun {
	private String productID;
	private String productName;
	private String logID;
	private String operatorID;
	private String operatorAccount;
	private Integer operatorIdentity;
	private String operatorName;
	private String organizationName;
	private String organizationID;
	private String opTime;
	private String resTime;
	private String terminalType;
	private String terminalID;
	private String terminalNum;
	private String terminalMac;
	private Integer opType;
	private String operateCondition;
	private String operateResult;
	private String errCode;
	private String clientIp;
	private String clientPort;
	private String url;
	private String objectParams;
	private String sessionID;
	private String funcModuleName;
	private String objectIP;
	private String objectPort;
	private String querySql;

	private String mrowTime; //插入时间
	private int maxId;

}
