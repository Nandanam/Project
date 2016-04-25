package TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Monitor.ProcessInfo;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author murali
 */
public class ProcessInfoTest {

    public ProcessInfoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void test() {
        //Info read test
        System.out.println("Testing Process Info");
        ProcessInfo pi = new ProcessInfo();
        String processdata = pi.GetProcessListData();
        assert (!processdata.isEmpty());
        System.out.println("Process data is not null");

        //Info write test
        System.out.println("Testing Process Info Text File");
        pi.showProcessData();
        File logFile = new File("ProcessList.txt");
        long i = logFile.length();
        assert (i > 0);
        System.out.println("Process Info Text File is not Empty");
    }
}
