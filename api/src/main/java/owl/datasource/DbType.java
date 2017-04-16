package owl.datasource;

/**
 * Created by a13178 on 2017/04/16.
 */
public enum DbType {

    Master, Slave;

    public String label() {
        return this.name().toLowerCase();
    }

}
