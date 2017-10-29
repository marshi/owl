package marshi.owl.data.rdb;

/**
 * Created by a13178 on 2017/04/16.
 */
public class SchemeContextHolder {

    private static ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

    public static void set(DbType dbType) {
        contextHolder.set(dbType);
    }

    public static DbType get() {
        return contextHolder.get();
    }

    public static void remove() {
        contextHolder.remove();
    }

}
