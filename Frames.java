import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;


public class Frames{

    public boolean isFatboiShowing = false;
    public boolean isSleepShowing = false;

    class mainFrame{
        
        JFrame mainFrame = new JFrame();
        JLabel mainLabel = new JLabel();

        public void createMainFrame(boolean isSleepShowing, boolean isFatboiShowing){
            
            JButton franchise = new JButton("Franchise");
            JButton tsubasa = new JButton("Tsubasa");
            JButton addButton = new JButton("Add music");
            JButton sleep = new JButton("Sleep");
            JButton fatboi = new JButton("Fatboi");
    
            franchise.addActionListener(new Franchise());
            tsubasa.addActionListener(new Tsubasa());
            addButton.addActionListener(new addFrame());
            sleep.addActionListener(new Sleep());
            fatboi.addActionListener(new Fatboi());
            
            mainLabel.add(franchise);
            mainLabel.add(tsubasa);
            mainLabel.add(addButton);
    
            if(isSleepShowing == true){
                mainLabel.add(sleep);
            }
            if(isFatboiShowing == true){
                mainLabel.add(fatboi);
            }
    
            mainFrame.add(mainLabel);
            mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mainFrame.setVisible(true);
            mainFrame.pack();
        }
    }

    public void displayMainFrame(){
        mainFrame mainFrame = new mainFrame();
        mainFrame.createMainFrame(false, false);
    }

    class Franchise implements ActionListener{

        Desktop d = Desktop.getDesktop();

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                 openFranchise();
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
        }

        public void openFranchise() throws Exception{ 
            d.browse(new URI("https://www.youtube.com/watch?v=_VRyoaNF9sk"));
        }

    }

    class Tsubasa implements ActionListener{

        Desktop d = Desktop.getDesktop();

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                 openTsubasa();
             } catch (Exception ex) {
                 ex.printStackTrace();
             }
        }

        public void openTsubasa() throws Exception{ 
            d.browse(new URI("https://www.youtube.com/watch?v=7iiLO8vZlLg&t=83s"));
        }

    }

    class addFrame implements ActionListener{
        
        JFrame addFrame = new JFrame();
        JPanel addPanel = new JPanel();
        
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

        addFrame addFrame = new addFrame();
        mainFrame mainFrame = new mainFrame();
    
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(isFatboiShowing == false){
                isFatboiShowing = true;
                addFrame.addFrame.dispose();//?
                mainFrame.mainFrame.dispose();//?
                mainFrame.createMainFrame(false, true);
            }else if(isSleepShowing == true && isFatboiShowing == true){  //Lehet hogy nem kell ez az if!
                mainFrame.createMainFrame(true,true);
            }
        }
    
    }

    class Sleepnew implements ActionListener{

        addFrame addFrame = new addFrame();
        mainFrame mainFrame = new mainFrame();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isSleepShowing == false){
                isSleepShowing = true;
                addFrame.addFrame.dispose();
                mainFrame.mainFrame.dispose();
                mainFrame.createMainFrame(true, false);
            }else if(isSleepShowing == true && isFatboiShowing == true){ //Lehet hogy nem kell ez az if!
                mainFrame.createMainFrame(true, true);
            }
        }

    }

    class Sleep implements ActionListener {
        
        Desktop d = Desktop.getDesktop();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openSleep();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        public void openSleep() throws Exception{
            d.browse(new URI("https://www.youtube.com/watch?v=B1ti2uNeYYI"));
        }
        
    }

    class Fatboi implements ActionListener{
        Desktop d = Desktop.getDesktop();

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openFatboi();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        public void openFatboi() throws Exception{
            d.browse(new URI("https://www.youtube.com/watch?v=wPK0QwK9y2w"));
        }
        
    }
}


















































/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;

public class Frames{

    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();

    addFrane addFrame = new addFrane();
    
    

    public void createMainFrame(boolean isFatboiShowing, boolean isSleepShowing){

        JButton franchise = new JButton("Franchise");
        JButton tsubasa = new JButton("Tsubasa");
        JButton addButton = new JButton("Add music");
        JButton sleep = new JButton("Sleep");
        JButton fatboi = new JButton("Fatboi");

        sleep.addActionListener(new Sleep());
        fatboi.addActionListener(new Fatboi());
        addButton.addActionListener(new addFrane());
        tsubasa.addActionListener(new Tsubasa());
        franchise.addActionListener(new Franchise());
    
        mainPanel.add(franchise);
        mainPanel.add(tsubasa);

        if(isSleepShowing == true){
            mainPanel.add(sleep);
        }
        if(isFatboiShowing == true){
            mainPanel.add(fatboi);
        }

        mainPanel.add(addButton);
    
        mainFrame.add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainFrame.setVisible(true);
        mainFrame.pack();
    }

    public void addExtraSongs(String song){
        if(song == "SLEEP"){
            createMainFrame(false,true);
        }
        if(song == "FATBOI"){
            createMainFrame(true,false);
        }
    }

    class Sleep implements ActionListener{
    
        Desktop d = Desktop.getDesktop();
    
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openSleep();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
        public void openSleep() throws Exception{ 
            d.browse(new URI("https://www.youtube.com/watch?v=B1ti2uNeYYI"));
        } 
    }

    class Fatboi implements ActionListener{
    
        Desktop d = Desktop.getDesktop();
    
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openFatboi();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
        public void openFatboi() throws Exception{ 
            d.browse(new URI("https://www.youtube.com/watch?v=wPK0QwK9y2w"));
        }
        
    }

    class Tsubasa implements ActionListener {
        
        Desktop d = Desktop.getDesktop();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openTsubasa();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
        public void openTsubasa() throws Exception{ 
            d.browse(new URI("https://www.youtube.com/watch?v=7iiLO8vZlLg&t=83s"));
        }
    }

    class Franchise implements ActionListener {
        
        Desktop d = Desktop.getDesktop();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                openFranchise();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
        public void openFranchise() throws Exception{ 
            d.browse(new URI("https://www.youtube.com/watch?v=_VRyoaNF9sk"));
        }
    }

    class addFrane implements ActionListener{
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
    
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(addFrame.isFatboiShowing == false){
                addFrame.isFatboiShowing = true;
                addFrame.addFrame.dispose();//?
                mainFrame.dispose();//?
                addExtraSongs("FATBOI");
            }else if(addFrame.isSleepShowing == true && addFrame.isFatboiShowing == true){
                createMainFrame(true,true);
            }else if(addFrame.isSleepShowing == false && addFrame.isFatboiShowing == false){
                createMainFrame(true, false);
            }
            
        }
    
    }

    
class Sleepnew implements ActionListener{
    
    addFrane addFrame = new addFrane();

    @Override
    public void actionPerformed(ActionEvent e){
        if(addFrame.isSleepShowing == false){
            addFrame.isFatboiShowing = true;
            addFrame.addFrame.setVisible(false); //?
            mainFrame.setVisible(false); //?
            addExtraSongs("SLEEP");
        }else if(addFrame.isSleepShowing == true && addFrame.isFatboiShowing == true){
            createMainFrame(true,true);
        }else if(addFrame.isSleepShowing == true && addFrame.isFatboiShowing == false){
            createMainFrame(false, true);
        }
    }
}
}
*/