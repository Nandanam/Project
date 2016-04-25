package TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Monitor.DiskInfo;
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
public class DiskInfoTest {

    public DiskInfoTest() {
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
        System.out.println("Testing Disk Info");
        DiskInfo di = new DiskInfo();
        String disksdata = di.getDiskInfo();
        assert (!disksdata.isEmpty());
        System.out.println("Disk Data is not null");

        //Info write test
        System.out.println("Testing Disk Info Text File");
        di.showDiskData();
        File logFile = new File("DiskList.txt");
        long i = logFile.length();
        assert (i > 0);
        System.out.println("Disk Info Text File is not Empty");
    }
}
