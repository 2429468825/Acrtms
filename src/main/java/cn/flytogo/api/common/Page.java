package cn.flytogo.api.common;

import lombok.Data;

import java.util.List;

/**
 * @Description 分页查询页面包装类
 * @Author
 * @Date
 **/
@Data
public class Page<T> {

    private List<T> list;

    private Integer total;

    // 有参构造函数
    public Page(List<T> list, Integer total) {
        this.list = list;
        this.total = total;
    }

}
