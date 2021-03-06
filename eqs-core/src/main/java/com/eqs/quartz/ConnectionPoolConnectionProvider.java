package com.eqs.quartz;

import com.eqs.common.BeanKit;
import com.eqs.common.StrKit;
import com.eqs.orm.dao.IApplicationDao;
import org.quartz.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 数据源
 * @author june
 */
public class ConnectionPoolConnectionProvider implements ConnectionProvider {

    private static String dsName = null;
    static {
        //获取数据源名称
        ResourceBundle rb = ResourceBundle.getBundle("quartz");
        String keyName = "eqs.quartz.dataSource.name";
        if(rb.containsKey(keyName)){
            dsName = rb.getString(keyName);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        IApplicationDao dao;
        if(StrKit.isNotEmpty(dsName)){
            dao = BeanKit.getBean(dsName,IApplicationDao.class);
        }else{
            dao = BeanKit.getBean(IApplicationDao.class);
        }
        return dao.getJdbcTemplate().getDataSource().getConnection();
    }

    @Override
    public void shutdown() throws SQLException {

    }

    @Override
    public void initialize() throws SQLException {

    }

}
