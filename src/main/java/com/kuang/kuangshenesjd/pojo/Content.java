package com.kuang.kuangshenesjd.pojo;

/*
 * @description:
 * @author: Felix_XHF
 * @create:2021-11-23 20:07
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;

    //可以自己添加属性
}
