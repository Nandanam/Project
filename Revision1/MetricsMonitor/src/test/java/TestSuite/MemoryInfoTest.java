package TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Monitor.MemoryInfo;
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
public class MemoryInfoTest {

    public MemoryInfoTest() {
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
        System.out.println("Testing Memory Info");
        MemoryInfo mi = new MemoryInfo();
        String memorydata = mi.GetMemoryListData();
        assert (!memorydata.isEmpty());
        System.out.println("Memory data is not null");

        //Info write test
        System.out.println("Testing Memory Info Text File");
        mi.showMemoryData();
        File logFile = new File("MemoryList.txt");
        long i = logFile.length();
        assert (i > 0);
        System.out.println("Memory Info Text File is not Empty");
    }
}
