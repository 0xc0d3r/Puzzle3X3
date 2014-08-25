import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Puzzle3X3 extends JFrame implements ActionListener {
    public static String player = "Player";
    public static int moves = 0;
    JMenuBar mb;
    JMenu New,Help,Contact;
    JMenuItem newgame,help,contact,quit,keyboard;
    JLabel l1,l2,l3;
    JTextField tf1,tf2;
    JButton b[] = new JButton[9];
    JButton nextGame;
    JTable jt;
    Puzzle3X3() {
        super("Puzzle Game");
        this.constructBoard();
        newgame = new JMenuItem("New Game",KeyEvent.VK_N);
        quit=new JMenuItem("Quit",KeyEvent.VK_Q);
        help = new JMenuItem("help",KeyEvent.VK_L);
        keyboard = new JMenuItem("Shortcut Keys",KeyEvent.VK_K);
        contact = new JMenuItem("Developer",KeyEvent.VK_D);
        newgame.addActionListener(this);
        quit.addActionListener(this);
        help.addActionListener(this);         
        keyboard.addActionListener(this);
        contact.addActionListener(this);
        mb=new JMenuBar();
        mb.setBounds(5,3,150,20);
        New = new JMenu("Game");
        New.setMnemonic(KeyEvent.VK_G);
        Help = new JMenu("Help");
        Help.setMnemonic(KeyEvent.VK_H);
        Contact = new JMenu("Contact");
        Contact.setMnemonic(KeyEvent.VK_C);
        New.add(newgame);
        New.add(quit);
        help.setAccelerator(KeyStroke.getKeyStroke("F1"));
        Help.add(help);
        Help.add(keyboard);
        Contact.add(contact);
        mb.add(New);
        mb.add(Help);
        mb.add(Contact);
        add(mb);
        l1 = new JLabel("Name :");
        l1.setBounds(250,50,130,20);
        tf1=new JTextField("Anesh");
        tf1.setBounds(300,50,130,20);
        l2 = new JLabel("Moves:");
        tf2=new JTextField("0");
        tf2.setEditable(false);
        l2.setBounds(250,90,130,20);
        tf2.setBounds(310,90,30,20);
        tf1.setBackground(Color.magenta);
        tf1.setForeground(Color.white);
        tf2.setBackground(Color.magenta);
        tf2.setForeground(Color.white);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        setSize(500,300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void constructBoard() {
        int x=30,y=50,col=0;
        for(int i=0,lbl=1;i<=8;i++,x+=55,lbl++,col++) {
            if(i==1) {
                b[i] = new JButton(" ");
                lbl--;
            }
            else b[i] = new JButton(Integer.toString(lbl));
            if(col==3) {
                x=30;
                col=0;
                y+=45;
            }
            b[i].setBounds(x,y,50,40);
            b[i].addActionListener(this);
            add(b[i]);
        }
        nextGame=new JButton(new ImageIcon("NewGame.png"));
        nextGame.setMnemonic(KeyEvent.VK_N);
        nextGame.setBounds(60,210,85,30);
        nextGame.addActionListener(this);
        add(nextGame);
    }
    public void newBoard() {
        tf2.setText("0");
        Puzzle3X3.moves = 0;
        String l = b[8].getLabel();
        b[8].setLabel(b[0].getLabel());
        b[0].setLabel(l);
        l = b[6].getLabel();
        b[6].setLabel(b[1].getLabel());
        b[1].setLabel(l);
        l = b[7].getLabel();
        b[7].setLabel(b[3].getLabel());
        b[3].setLabel(l);
        l = b[4].getLabel();
        b[4].setLabel(b[2].getLabel());
        b[2].setLabel(l);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quit) {
            System.exit(0);
        }
        if(e.getSource() == keyboard) {
            final JDialog jd =new JDialog(Puzzle3X3.this,"Puzzle Game - Keyboard Shortcuts",false);
            JButton alt,key,fn;
            JLabel NG,H,plus,title;
            jd.setLayout(null);
            jd.setSize(400,350);
            jd.setVisible(true);
            title = new JLabel("Puzzle Game ShortCut Keys");
            title.setBounds(85,10,240,20);
            title.setVisible(true);
            jd.add(title);
            NG = new JLabel("New Game");
            plus = new JLabel("+");
            H = new JLabel("Help");
            NG.setBounds(70,80,80,20);
            plus.setBounds(240,75,20,20);
            H.setBounds(80,160,100,20);
            NG.setVisible(true);
            plus.setVisible(true);
            H.setVisible(true);
            alt = new JButton("Alt");
            key = new JButton("N");
            fn = new JButton("F1");
            alt.setBounds(160,60,60,50);
            key.setBounds(270,60,60,50);
            fn.setBounds(160,150,60,50);
            alt.setBackground(Color.black);
            alt.setForeground(Color.white);
            key.setBackground(Color.black);
            key.setForeground(Color.white);
            fn.setBackground(Color.black);
            fn.setForeground(Color.white);
            alt.setVisible(true);
            key.setVisible(true);
            fn.setVisible(true);
            jd.add(NG);
            jd.add(alt);
            jd.add(plus);
            jd.add(key);
            jd.add(H);
            jd.add(fn);
            JButton close=new JButton("CLOSE");
            close.setMnemonic(KeyEvent.VK_C);
            close.setBounds(145,250,100,40);
            close.setVisible(true);
            jd.add(close);
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jd.setVisible(false);
                }
            }); 
        }
        if(e.getSource() == help) {
            final JDialog jd =new JDialog(Puzzle3X3.this,"Puzzle Game - Help",false);
            jd.setLayout(new FlowLayout());
            jd.setSize(350,240);
            jd.setVisible(true);
            jd.add(new JLabel("Puzzle Game Help Menu"));
            String helpMenu = "1)Arrange the numbers in ascending order.\n\n"+
            "2)The last box should be empty at last.\n\n"+
            "3)Click on the number which you want to move.\n\n"+
            "4)Click on the \"New Game\" button to play new game.";
            JTextArea jta = new JTextArea(helpMenu,10,10);
            jta.setEditable(false);
            jta.setBackground(Color.black);
            jta.setForeground(Color.green);
            jta.setVisible(true);
            jd.add(jta);
            JButton close=new JButton("CLOSE");
            close.setMnemonic(KeyEvent.VK_C);
            close.setBounds(150,250,100,40);
            close.setVisible(true);
            jd.add(close);
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jd.setVisible(false);
                }
            });
        }  
        if(e.getSource() == contact) {
            final JDialog jd =new JDialog(Puzzle3X3.this,"Puzzle Game - Contact",false);
            jd.setLayout(new FlowLayout());
            jd.setSize(300,250);
            jd.setVisible(true);
            jd.add(new JLabel("About Developer"));
            String abtDev = "\n\nDeveloper : Anesh Parvatha\n\nN090977,CSE-03\n\nContact me at n090977@nuz.rgukt.in";
            JTextArea jta = new JTextArea(abtDev,10,10);
            jta.setEditable(false);
            jta.setBackground(Color.black);
            jta.setForeground(Color.green);
            jta.setVisible(true);
            jd.add(jta);
            JButton close=new JButton("CLOSE");
            close.setMnemonic(KeyEvent.VK_C);
            close.setBounds(150,250,100,40);
            close.setVisible(true);
            jd.add(close);
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    jd.setVisible(false);
                }
            });
            
        } 
        if(e.getSource() == nextGame) {
            newBoard();
        }
        if(e.getSource() == newgame) {
            newBoard();
        }
        if(e.getSource() == b[0]) {
            moves++;
            String l1 = b[0].getLabel();
            if(b[3].getLabel().equals(" ")) {
                b[0].setLabel(b[3].getLabel());
                b[3].setLabel(l1);
            }
            else if(b[1].getLabel().equals(" ")) {
                b[0].setLabel(b[1].getLabel());
                b[1].setLabel(l1);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[2]) {
            moves++;
            String l3 = b[2].getLabel();
            if(b[5].getLabel().equals(" ")) {
                b[2].setLabel(b[5].getLabel());
                b[5].setLabel(l3);
            }
            else if(b[1].getLabel().equals(" ")) {
                b[2].setLabel(b[1].getLabel());
                b[1].setLabel(l3);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[6]) {
            moves++;
            String l7 = b[6].getLabel();
            if(b[3].getLabel().equals(" ")) {
                b[6].setLabel(b[3].getLabel());
                b[3].setLabel(l7);
            }
            else if(b[7].getLabel().equals(" ")) {
                b[6].setLabel(b[7].getLabel());
                b[7].setLabel(l7);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[8]) {
            moves++;
            String l9 = b[8].getLabel();
            if(b[5].getLabel().equals(" ")) {
                b[8].setLabel(b[5].getLabel());
                b[5].setLabel(l9);
            }
            else if(b[7].getLabel().equals(" ")) {
                b[8].setLabel(b[7].getLabel());
                b[7].setLabel(l9);
            }
            isGameDone();
        }
        if(e.getSource() == b[1]) {
            moves++;
            String l2 = b[1].getLabel();
            if(b[0].getLabel().equals(" ")) {
                b[1].setLabel(b[0].getLabel());
                b[0].setLabel(l2);
            }
            else if(b[2].getLabel().equals(" ")) {
                b[1].setLabel(b[2].getLabel());
                b[2].setLabel(l2);
            }
            else if(b[4].getLabel().equals(" ")) {
                b[1].setLabel(b[4].getLabel());
                b[4].setLabel(l2);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[3]) {
            moves++;
            String l4 = b[3].getLabel();
            if(b[0].getLabel().equals(" ")) {
                b[3].setLabel(b[0].getLabel());
                b[0].setLabel(l4);
            }
            else if(b[6].getLabel().equals(" ")) {
                b[3].setLabel(b[6].getLabel());
                b[6].setLabel(l4);
            }
            else if(b[4].getLabel().equals(" ")) {
                b[3].setLabel(b[4].getLabel());
                b[4].setLabel(l4);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[5]) {
            moves++;
            String l6 = b[5].getLabel();
            if(b[8].getLabel().equals(" ")) {
                b[5].setLabel(b[8].getLabel());
                b[8].setLabel(l6);
            }
            else if(b[2].getLabel().equals(" ")) {
                b[5].setLabel(b[2].getLabel());
                b[2].setLabel(l6); 
            }
            else if(b[4].getLabel().equals(" ")) {
                b[5].setLabel(b[4].getLabel());
                b[4].setLabel(l6);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[7]) {
            moves++;
            String l8 = b[7].getLabel();
            if(b[6].getLabel().equals(" ")) {
                b[7].setLabel(b[6].getLabel());
                b[6].setLabel(l8);
            }
            else if(b[8].getLabel().equals(" ")) {
                b[7].setLabel(b[8].getLabel());
                b[8].setLabel(l8);
            }
            else if(b[4].getLabel().equals(" ")) {
                b[7].setLabel(b[4].getLabel());
                b[4].setLabel(l8);
            }
            tf2.setText(Integer.toString(moves));
        }
        if(e.getSource() == b[4]) {
            moves++;
            String l5 = b[4].getLabel();
            if(b[1].getLabel().equals(" ")) {
                b[4].setLabel(b[1].getLabel());
                b[1].setLabel(l5);
            }
            else if(b[3].getLabel().equals(" ")) {
                b[4].setLabel(b[3].getLabel());
                b[3].setLabel(l5);
            }
            else if(b[5].getLabel().equals(" ")) {
                b[4].setLabel(b[5].getLabel());
                b[5].setLabel(l5);
            }
            else if(b[7].getLabel().equals(" ")) {
                b[4].setLabel(b[7].getLabel());
                b[7].setLabel(l5);
            }
            tf2.setText(Integer.toString(moves));
        }
    }
    private void isGameDone(){
        boolean row1 = b[0].getLabel().equals("1") && b[1].getLabel().equals("2") && b[2].getLabel().equals("3");
        boolean row2 = b[3].getLabel().equals("4") && b[4].getLabel().equals("5") && b[5].getLabel().equals("6");
        boolean row3 = b[6].getLabel().equals("7") && b[7].getLabel().equals("8") && b[8].getLabel().equals(" ");
        if(row1 && row2 && row3) {
            player = tf1.getText();
            if(player.equals("")) player = "Player"; 
            String msg = "You won..!! "+player+"..!\nYou done it in "+moves+" moves";
            JOptionPane.showMessageDialog(Puzzle3X3.this,msg);
        }
        tf2.setText(Integer.toString(moves));
    }
    public static void main(String []cla) {
        new Puzzle3X3();
    }
}
