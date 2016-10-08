/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package cn.cobala.alibaba.zhima.openplatform;

/**
 * 
 * @author runzhi
 */
public interface ZhimaClient {

    /**
     * 
     * 
     * @param <T>
     * @param request
     * @return
     * @throws ZhimaApiException
     */
    public <T extends ZhimaResponse> T execute(ZhimaRequest<T> request) throws ZhimaApiException;
}
