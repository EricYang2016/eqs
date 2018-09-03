/*
 * @date 2016年10月28日 17:38
 */
package com.eqs.orm.dao;


import com.eqs.data.ICache;
import com.eqs.data.ICache;

/**
 * 缓存
 * @author june
 */
public interface CacheProvider {

    /**
     * 获取缓存实例
     * @param dsId 当前数据源id
     * @param statementRuntime 要执行的sql
     * @return ICache
     */
    ICache getCache(String dsId, StatementRuntime statementRuntime);

}
