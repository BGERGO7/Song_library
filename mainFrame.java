import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;

public class mainFrame{

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

