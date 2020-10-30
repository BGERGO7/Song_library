import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;

public class Frames{

	//Ha masodjara akarok hozzaadni egy zenet akkor nem engedelyezi. 
	//TODO: Megnezni az if-else sorokat az addSong-nal mert valoszinuleg ott van a hiba

	public boolean isHajnaliNegyShowing = false;
	public boolean isFalaFelShowing = false;

	public static void main(String[] args) {
		Frames frames = new Frames();

		frames.showMainFrame();
	}

	public void showMainFrame(){
		mainFrame mainFrame = new mainFrame();

		mainFrame.createMainFrame(false, false);
	}

	class mainFrame {
		JFrame mainFrame = new JFrame();

		public void createMainFrame(boolean HajnaliNegy, boolean FalaFel) {
			JButton franchise = new JButton("Franchise");
			JButton hajnaliNegy = new JButton("Hajnali 4");
			JButton falaFel = new JButton("Fala fel");
			JButton addButton = new JButton("Add Song");

			franchise.addActionListener(new Franchise());
			hajnaliNegy.addActionListener(new hajnaliNegy());
			falaFel.addActionListener(new falaFel());
			addButton.addActionListener(new AddFrame());

			mainFrame.add(franchise);
			if (HajnaliNegy == true) {
				mainFrame.add(hajnaliNegy);
			}
			if (FalaFel == true) {
				mainFrame.add(falaFel);
			}
			mainFrame.add(addButton);

			mainFrame.setLayout(new GridLayout(0, 1));
			mainFrame.setVisible(true);
			mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainFrame.pack();

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
		JFrame addFrame = new JFrame();

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton hajnaliNegy = new JButton("Hajnali Negy");
			JButton falaFel = new JButton("Fala Fel");

			hajnaliNegy.addActionListener(new addHajnaliNegy());
			falaFel.addActionListener(new addFalaFel());

			addFrame.add(hajnaliNegy);
			addFrame.add(falaFel);

			addFrame.setLayout(new GridLayout(0, 1));
			addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addFrame.setVisible(true);
			addFrame.pack();
		}

	}

	class addHajnaliNegy implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame mainFrame = new mainFrame();

			if (isHajnaliNegyShowing == false && isFalaFelShowing == false) {
				isHajnaliNegyShowing = true;
				mainFrame.createMainFrame(true,false);
			}else if(isHajnaliNegyShowing == true && isFalaFelShowing == true){
				mainFrame.createMainFrame(true,true);
			}
	
		}
		
	}
	
	
	class addFalaFel implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {

			mainFrame mainFrame = new mainFrame();
			
			if (isHajnaliNegyShowing == false && isFalaFelShowing == false) {
				isFalaFelShowing = true;
				mainFrame.createMainFrame(false,true);
			}else if(isHajnaliNegyShowing == true && isFalaFelShowing == true){
				mainFrame.createMainFrame(true, true);
			}
		}
		
	}
}

