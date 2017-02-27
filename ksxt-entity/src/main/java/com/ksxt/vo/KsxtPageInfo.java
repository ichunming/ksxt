/**
 * @author ming
 * @date 2017年2月10日 上午11:44:58
 */
package com.ksxt.vo;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class KsxtPageInfo<T> extends PageInfo<T> {
	private static final long serialVersionUID = -436574926882857476L;

    public KsxtPageInfo(List<T> list) {
        super(list);
    }
}
