package Song_Library.Song_library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;


//TODO Ha add song utan kivalasztjuk a zenet akkor az abalk zarodjon be es az elozo fo ablak is

public class Library{
    boolean isSleepShowing = false;
    boolean isFatboiShowing = false;
    public static void main(String[] args) {
        Library library = new Library();
        makeGUI gui = library.new makeGUI();

        gui.addGui();
        
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
    
    class Fatboinew implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            makeGUI gui = new makeGUI();
            AddButton add = new AddButton();
               
            if(isFatboiShowing == false){
                isFatboiShowing = true;
                add.addFrame.setVisible(false);  //Problem here
                gui.firstFrame.setVisible(false);//Problem here
                gui.addGui();
            }else if(isFatboiShowing == true){
                gui.addGui();
            }
        }
    
    }
    
    class Sleepnew implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e){
    
            makeGUI gui = new makeGUI();
            AddButton add = new AddButton();
            
            if(isSleepShowing == false){
                isSleepShowing = true;
                isSleepShowing = true;
                add.addFrame.setVisible(false);   //Problem here
                gui.firstFrame.setVisible(false); //Problem here
                gui.addGui();
            }else if(isSleepShowing == true){
                gui.addGui();
            }
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
    
    class AddButton implements ActionListener{

        JFrame addFrame = new JFrame();
        JPanel addPanel = new JPanel();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton fatboi = new JButton("Fatboi");
            JButton sleep = new JButton("Sleep");
            fatboi.addActionListener(new Fatboinew());
            sleep.addActionListener(new Sleepnew());
    
            addPanel.setLayout(new GridLayout(0, 1));
            addPanel.add(fatboi);
            addPanel.add(sleep);
    
            addFrame.add(addPanel);
            addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
            addFrame.setVisible(true);
            addFrame.pack();
        }
    }
    
    class makeGUI{

        JFrame firstFrame = new JFrame();
        JPanel firstPanel = new JPanel();
        
        public void addGui(){
            JButton franchise = new JButton("Franchise");
            JButton tsubasa = new JButton("Tsubasa");
            JButton addButton = new JButton("Add music");
            JButton sleep = new JButton("Sleep");
            JButton fatboi = new JButton("Fatboi");

            firstPanel.remove(franchise);
            firstPanel.remove(tsubasa);
            firstPanel.remove(addButton);
            firstPanel.remove(sleep);
            firstPanel.remove(fatboi);

    
            franchise.addActionListener(new Franchise());
            tsubasa.addActionListener(new Tsubasa());
            addButton.addActionListener(new AddButton());
            fatboi.addActionListener(new Fatboi());
            sleep.addActionListener(new Sleep());
    
            firstPanel.setLayout(new GridLayout(0, 1));
            firstPanel.add(franchise);
            firstPanel.add(tsubasa);
    
            if(isSleepShowing == true){
                firstPanel.add(sleep);
            }
            if(isFatboiShowing == true){
                firstPanel.add(fatboi);
            }
    
            firstPanel.add(addButton);
    
            firstFrame.add(firstPanel);
            firstFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            firstFrame.setVisible(true);
            firstFrame.pack();
        }
    }
}