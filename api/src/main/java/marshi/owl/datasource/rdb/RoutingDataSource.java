package marshi.owl.datasource.rdb;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * Created by a13178 on 2017/04/16.
 */
public class RoutingDataSource extends AbstractRoutingDataSource implements DisposableBean {

    public RoutingDataSource(Map<Object, Object> dataSources) {
        super.setTargetDataSources(dataSources);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if (DbType.Master == SchemeContextHolder.get()) {
            return DbType.Master.label();
        }
        return DbType.Slave.label();
    }

    @Override
    public void destroy() throws Exception {

    }

}
