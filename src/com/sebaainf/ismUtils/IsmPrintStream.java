package com.sebaainf.ismUtils;

import java.io.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${sebaainf.com} on 06/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class IsmPrintStream extends PrintStream {
    private final PrintStream second;

    public IsmPrintStream(OutputStream main, PrintStream second) {
        super(main);
        this.second = second;
    }

    /**
     * Closes the main stream.
     * The second stream is just flushed but <b>not</b> closed.
     * @see java.io.PrintStream#close()
     */
    @Override
    public void close() {
        // just for documentation
        super.close();
    }

    @Override
    public void flush() {
        super.flush();
        second.flush();
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        second.write(buf, off, len);
    }

    @Override
    public void write(int b) {
        super.write(b);
        second.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
        second.write(b);
    }


    public static void prepareLogFile() {
        // for logging in log.text .....................

        FileOutputStream log_file = null;
        try {


            log_file = new FileOutputStream("log.txt", true);
            IsmPrintStream ismPrintStream = new IsmPrintStream(log_file, System.out);
            System.setOut(ismPrintStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // loggin code finished .......................
    }

    public static void logging(String text) {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy  - HH:mm:ss");
        String espace = "                                         ......................................   ";
        System.out.println(text + espace.substring(text.length())+ format.format(new Date()));

    }

   /* public static void prepareLogFile() {
        // for logging in log.text .....................

        FileOutputStream log_file_temp = null;
        FileOutputStream log_file = null;
        FileReader fr = null;
        FileWriter fw = null;
        try {





            log_file_temp = new FileOutputStream("log_temp.txt", true);
            log_file = new FileOutputStream("log.txt", true);
            IsmPrintStream ismPrintStream = new IsmPrintStream(log_file_temp, System.out);
            System.setOut(ismPrintStream);

            fr = new FileReader("log.txt");
            fw = new FileWriter("log_temp.txt");
            int c = fr.read();
            while (c != -1) {
                fw.write(c);
                c = fr.read();
            }

            File logFile = new File("log.txt");
            log_file.close();
            logFile.delete();

            File logFile_temp = new File("log_temp.txt");
            log_file_temp.close();
            logFile_temp.renameTo(logFile);


            //log_file_temp.write(log_file.);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(fr);
            close(fw);
        }
        // loggin code finished .......................

    }

    public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch(IOException e) {
            //...
        }
    }*/

    // this code
    // TODO later to logging at the beggining of log file

}
