package cn.flytogo.api.service;

import org.springframework.stereotype.Service;

/**
 *  数据服务
 * @author 24294
 */

public interface AcrtmsDataService {

    /**
     * 增加一条数据
     * @param data 数据
     * @param id deviceID
     */
    void increase(String data, String id);

    /**
     * 清空数据
     */
    void clear();
}
