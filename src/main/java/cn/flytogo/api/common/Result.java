package cn.flytogo.api.common;

import java.util.HashMap;
import java.util.Map;

    /**
     * @Description 通用返回结果
     * @Author
     * @Date
     **/
public class Result<T> {
    private Integer code;             // 编码：0成功,1和其它数字为失败
    private String msg;               // 错误信息
    private T data;                   // 数据
    private Map<Object, Object> resultMap = new HashMap<>();  // 动态数据

    /**
     * 返回实体数据，需要泛型
     * @param data
     * @param <T>
     * @return response
     */

    public static <T> Result<T> success(T data) {
        Result response = new Result<>();
        response.data = data;
        response.code = 0;
        return response;
    }

    /**
     * 返回错误信息，不需要泛型
     * @param message
     * @param <T>
     * @return
     */

    public static <T> Result<T> error(String message) {
        Result<T> response = new Result<>();
        response.msg = message;
        response.code = 1;
        return response;
    }

    public Result<T> add(String key, Object value) {
        this.resultMap.put(key, value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<Object, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<Object, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
