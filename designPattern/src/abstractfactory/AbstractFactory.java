package abstractfactory;

/**
 * 抽象工厂模式--有工厂方法模式组合而来
 */
public class AbstractFactory {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlIdataBaseUtils();
        IConnection iConnection = iDatabaseUtils.getConnection();
        iConnection.connect();
        Icommand icommand = iDatabaseUtils.getCommand();
        icommand.command();
    }
}

//变化: mysql, Oracle
//不变: connection command

interface IConnection {
    void connect();
}

interface Icommand {
    void command();
}

interface IDatabaseUtils {
    IConnection getConnection();
    Icommand getCommand();
}

class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("mysql连接建立");
    }
}

class MysqlCommand implements Icommand {
    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlIdataBaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public Icommand getCommand() {
        return new MysqlCommand();
    }
}