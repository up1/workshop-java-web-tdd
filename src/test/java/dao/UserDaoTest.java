package dao;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.Charset;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import demo.dao.DatabaseUserDao;
import demo.dao.UserDao;

public class UserDaoTest {

	private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String UTF8 = "UTF8";

    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, "schema/user.sql", Charset.forName(UTF8), false);
		RunScript.execute(JDBC_URL, USER, PASSWORD, "schema/user.sql", Charset.forName(UTF8), false);
    }

    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }

    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File("./data/user.xml"));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    private DataSource getDatasource() {
    		JdbcDataSource dataSource = new JdbcDataSource();
    		dataSource.setURL(JDBC_URL);
    		dataSource.setUser(USER);
    		dataSource.setPassword(PASSWORD);
    		return dataSource;
    }

    UserDao userDao = new DatabaseUserDao();

	@Test
	public void success_with_user_and_pin() throws SQLException {
		userDao.setConnection(getDatasource().getConnection());
		assertTrue(userDao.checkUser("demo", "pass"));
	}

	@Test
	public void user_not_found_with_user_and_pin() throws SQLException {
		userDao.setConnection(getDatasource().getConnection());
		assertFalse(userDao.checkUser("demo1", "pass1"));
	}
	
	@Test
	public void user_not_found_with_user_and_pin2() throws SQLException {
		userDao.setConnection(getDatasource().getConnection());
		assertFalse(userDao.checkUser("demo1", "pass1"));
	}

	@Test
	public void fail_with_null_connection() throws SQLException {
		userDao.setConnection(null);
		assertFalse(userDao.checkUser("demo1", "pass1"));
	}

}
