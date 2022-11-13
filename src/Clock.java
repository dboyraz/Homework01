import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JPanel implements Runnable {

    private Date date;
    private DateFormat dateFormat;
    private String time;


    @Override
    public void run() {

        try {
            while (true) {

                Thread.sleep(1000);
                date = new Date();
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                time = dateFormat.format(date);
                MyFrame.lblDate.setText(time + "    ");


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
