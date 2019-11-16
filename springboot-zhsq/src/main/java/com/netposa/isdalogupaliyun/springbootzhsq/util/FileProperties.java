package com.netposa.isdalogupaliyun.springbootzhsq.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/27 13:38
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "zhsq")
public class FileProperties {

	private String logUpAliyunLocal;

	private String productID;

}
