package Monitor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author murali
 */
public class DiskInfo {

    public String getDiskInfo() {
        Process p;
        Runtime runTime;
        String memory = null;
        try {
            System.out.println("Memory Reading is started...");

            //Get Runtime environment of System
            runTime = Runtime.getRuntime();

            //Execute command thru Runtime            
            p = runTime.exec("iostat");

            //Create Inputstream for Read Processes
            InputStream inputStream = p.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //Read the processes from sysrtem and add & as delimeter for tokenize the output
            String line = bufferedReader.readLine();
            memory = "&";
            while (line != null) {
                line = bufferedReader.readLine();
                memory += line + "&";
            }

            //Close the Streams
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            System.out.println("Disk data is read.");
        } catch (IOException e) {
            System.out.println("Exception arise during the read Processe-> " + e.getMessage());
        }
        return memory;
    }

    public void showDiskData() {
        try {

            //Call the method For Read the memory
            String proc = getDiskInfo();

            //Create Streams for write processes
            //Given the filepath which you need.Its store the file at where your java file.
            OutputStreamWriter outputStreamWriter
                    = new OutputStreamWriter(new FileOutputStream("DiskList.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            //Tokenize the output for write the processes
            StringTokenizer st = new StringTokenizer(proc, "&");

            while (st.hasMoreTokens()) {
                bufferedWriter.write(st.nextToken());  //Write the data in file
                bufferedWriter.newLine();               //Allocate new line for next line
            }

            //Close the outputStreams
            bufferedWriter.close();
            outputStreamWriter.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
