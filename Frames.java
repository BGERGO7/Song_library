import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;

public class Frames{
 
	public boolean isHajnaliNegyShowing = false;
	public boolean isFalaFelShowing = false;

	JFrame mainFrame = new JFrame();
	JFrame addFrame = new JFrame();

	JButton franchise = new JButton("Franchise");
	JButton hajnaliNegy = new JButton("Hajnali Negy");
	JButton falaFel = new JButton("Fala fel");
	JButton addButton = new JButton("Add Song");

	JButton hajnaliNegyAdd = new JButton("Hajnali Negy");
	JButton falaFelAdd = new JButton("Fala Fel");

	public static void main(String[] args) {
		Frames frames = new Frames();

		frames.showMainFrame();
	}

	public void showMainFrame(){
		mainFrame mainFrame = new mainFrame();

		mainFrame.createMainFrame(false, false);
	}

	class mainFrame {

		public void createMainFrame(boolean HajnaliNegy, boolean FalaFel) {
			franchise.addActionListener(new Franchise());
			hajnaliNegy.addActionListener(new hajnaliNegy());
			falaFel.addActionListener(new falaFel());
			addButton.addActionListener(new AddFrame());

			mainFrame.setSize(200,200);
			mainFrame.setName("Song Library");
		
			mainFrame.add(franchise);
			if (HajnaliNegy == true) {
				mainFrame.add(hajnaliNegy);
			}
			if (FalaFel == true) {
				mainFrame.add(falaFel);
			}
			mainFrame.add(addButton);

			mainFrame.setLayout(new GridLayout(0, 1));
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setVisible(true);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//mainFrame.pack();

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

		public void openFranchise() throws Exception {
			d.browse(new URI("https://www.youtube.com/watch?v=_VRyoaNF9sk"));
		}
	}

	class hajnaliNegy implements ActionListener {
		Desktop d = Desktop.getDesktop();

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				openHajnaliNegy();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void openHajnaliNegy() throws Exception {
			d.browse(new URI("https://www.youtube.com/watch?v=8fw9k3Brr7o"));
		}
	}

	class falaFel implements ActionListener {
		Desktop d = Desktop.getDesktop();

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				openFalaFel();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		public void openFalaFel() throws Exception {
			d.browse(new URI("https://www.youtube.com/watch?v=dn6f5VMcmoA"));
		}
	}

	class AddFrame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			hajnaliNegyAdd.addActionListener(new addHajnaliNegy());
			falaFelAdd.addActionListener(new addFalaFel());

			addFrame.add(hajnaliNegyAdd);
			addFrame.add(falaFelAdd);

			addFrame.setSize(200,200);
			addFrame.setName("Add Song");

			addFrame.setLayout(new GridLayout(0, 1));
			addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addFrame.setVisible(true);
			//addFrame.pack();
		}

	}

	class addHajnaliNegy implements ActionListener {
			mainFrame mainFrame = new mainFrame();
		@Override
		public void actionPerformed(ActionEvent e) {

			if (isHajnaliNegyShowing == false && isFalaFelShowing == false) {
				isHajnaliNegyShowing = true;
				addFrame.setVisible(false);
				mainFrame.createMainFrame(true,false);
			}else if(isHajnaliNegyShowing == true && isFalaFelShowing == true){
				addFrame.setVisible(false);
				mainFrame.createMainFrame(true,true);
			}else if(isHajnaliNegyShowing == true && isFalaFelShowing == false){
				addFrame.setVisible(false);
				mainFrame.createMainFrame(true,false);
			}else if(isHajnaliNegyShowing == false && isFalaFelShowing == true){	
				isHajnaliNegyShowing = true;
				addFrame.setVisible(false);
				mainFrame.createMainFrame(false,true);
			}
	
		}
		
	}
	
	
	class addFalaFel implements ActionListener{
			mainFrame mainFrame = new mainFrame();
		@Override
		public void actionPerformed(ActionEvent e) {

			
			if (isHajnaliNegyShowing == false && isFalaFelShowing == false) {
				isFalaFelShowing = true;
				addFrame.setVisible(false);
				mainFrame.createMainFrame(false,true);
			}else if(isHajnaliNegyShowing == true && isFalaFelShowing == true){
				addFrame.setVisible(false);
				mainFrame.createMainFrame(true, true);
			}else if(isHajnaliNegyShowing == false && isFalaFelShowing == true){
				addFrame.setVisible(false);
				mainFrame.createMainFrame(false,true);
			}else if(isHajnaliNegyShowing == true && isFalaFelShowing == false){	
				isFalaFelShowing = true;
				addFrame.setVisible(false);
				mainFrame.createMainFrame(true,false);
			}
		}
		
	}
}
