package TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Monitor.NetworkInfo;
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
public class NetworkInfoTest {

    public NetworkInfoTest() {
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
        //Info write test
        System.out.println("Testing Network Info");
        NetworkInfo ni = new NetworkInfo();
        String networkdata = ni.GetNetworkListData();
        assert (!networkdata.isEmpty());
        System.out.println("Network Data is not null");

        //Info write test
        System.out.println("Testing Network Info Text File");
        ni.showNetworkData();
        File logFile = new File("NetworkList.txt");
        long i = logFile.length();
        assert (i > 0);
        System.out.println("Network Info Text File is not Empty");
    }
}
