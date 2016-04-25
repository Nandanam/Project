package Monitor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author murali
 */
import java.io.*;
import java.util.StringTokenizer;

public class MemoryInfo {

    public String GetMemoryListData() {
        Process p;
        Runtime runTime;
        String memory = null;
        try {
            System.out.println("Memory Reading is started...");

            //Get Runtime environment of System
            runTime = Runtime.getRuntime();

 //Execute command thru Runtime
            //p = runTime.exec("tasklist");      // For Windows
            p = runTime.exec("free -h");                   //For Linux ps axo stat,pid,pcpu,comm

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

            System.out.println("MemoryList are read.");
        } catch (IOException e) {
            System.out.println("Exception arise during the read Processes");
            e.printStackTrace();
        }
        return memory;
    }

    public void showMemoryData() {
        try {

            //Call the method For Read the memory
            String proc = GetMemoryListData();

 //Create Streams for write processes
            //Given the filepath which you need.Its store the file at where your java file.
            OutputStreamWriter outputStreamWriter
                    = new OutputStreamWriter(new FileOutputStream("MemoryList.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            //Tokenize the output for write the processes
            StringTokenizer st = new StringTokenizer(proc, "&");

            bufferedWriter.write("                 total           used        free      shared     buff/cache    available");
            bufferedWriter.newLine();
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
