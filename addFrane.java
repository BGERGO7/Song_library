import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class addFrane implements ActionListener{
    JFrame addFrame = new JFrame();
    JPanel addPanel = new JPanel();

    boolean isFatboiShowing = false;
    boolean isSleepShowing = false;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton fatboi = new JButton("Fatboi");
        JButton sleep = new JButton("Sleep");

        sleep.addActionListener(new Sleepnew());
        fatboi.addActionListener(new Fatboinew());


        addPanel.add(fatboi);
        addPanel.add(sleep);

        addFrame.add(addPanel);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addFrame.setVisible(true);
        addFrame.pack();
    }      
}

class Fatboinew implements ActionListener{
    
    addFrane addFrame = new addFrane();

    mainFrame mainFrame = new mainFrame();

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(addFrame.isFatboiShowing == false){
            addFrame.isFatboiShowing = true;
            addFrame.addFrame.dispose();//?
            mainFrame.mainFrame.dispose();//?
            mainFrame.addExtraSongs("FATBOI");
        }else if(addFrame.isSleepShowing == true && addFrame.isFatboiShowing == true){
            mainFrame.createMainFrame(true,true);
        }else if(addFrame.isSleepShowing == false && addFrame.isFatboiShowing == false){
            mainFrame.createMainFrame(true, false);
        }
        
    }

}

class Sleepnew implements ActionListener{
    
    addFrane addFrame = new addFrane();

    mainFrame mainFrame = new mainFrame();

    @Override
    public void actionPerformed(ActionEvent e){
        if(addFrame.isSleepShowing == false){
            addFrame.isFatboiShowing = true;
            addFrame.addFrame.setVisible(false); //?
            mainFrame.mainFrame.setVisible(false); //?
            mainFrame.addExtraSongs("SLEEP");
        }else if(addFrame.isSleepShowing == true && addFrame.isFatboiShowing == true){
            mainFrame.createMainFrame(true,true);
        }else if(addFrame.isSleepShowing == true && addFrame.isFatboiShowing == false){
            mainFrame.createMainFrame(false, true);
        }
    }
}

