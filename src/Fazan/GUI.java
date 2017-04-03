package Fazan;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI extends JFrame{
    private drawBackground panel;
    private JPanel panel2;
    private final JButton BOpen;
    private final JButton BPlay;
    private final JLabel BStop;
    private final Icon icon1;
    private final Icon icon2;
    private final Icon icon3;
    private final Icon icon4;
    private final Icon icon5;
    private final Icon icon6;
    private JButton btn;
    private JLabel Alphabet;
    private boolean repeta=true;
    private String abc="";
    private int n;
    private final JLabel you;
    private final JLabel cpu;
    private final JTextField tf1;
    private final JTextField tf2;
    private final String[] dict = new String[100000];
    private final DefaultListModel dlm = new DefaultListModel();
    private boolean autoscroll;
    private JScrollPane sp;
    private JLabel BSkip;
    private JPanel fazan_panel1;
    private JPanel fazan_panel2;
    private JTextField fazan_tf1;
    private JList list;
    private JTextField fazan_tf2;
    private short cpu_score=0;
    private short player_score=0;
    private int highest_score;
    private JLabel winnerlabel;
    public JButton reset;
    private JButton score;
    private JButton about;
    private boolean prima_tura=false;
    private int SCOR=0;
    public GUI(){
            // Initialize
            setLayout(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Fazan");
            setSize(700,700);
            setResizable(false);
            setVisible(true);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2 - this.getSize().width/2, dim.height/2 - this.getSize().height/2 );
            
            setIconImage(Toolkit.getDefaultToolkit().getImage("icn.png"));
                
            // -- Button Open --
            
            BOpen = new JButton("Insert dictionary");
            BOpen.setBounds(20,20,130,30);
            add(BOpen);
            
            // -- Button Open --
            
            // -- Button Play --
            
            BPlay = new JButton("Play");
            BPlay.setEnabled((false));
            BPlay.setBounds(151,20,130,30);
            add(BPlay);
            
            // -- Reset Button --
            
            reset = new JButton("Reset");
            reset.setBounds(282,20,130,30);
            add(reset);
            
            // --end of reset --
            
            // -- Score button --
            score = new JButton("Highest score");
            score.setBounds(413,20,130,30);
            add(score);
            // -- end of score button --
            
            // -- about button --
            about = new JButton("About");
            about.setBounds(544,20,131,30);
            add(about);
            
            // --end of about button --
            
            // -- end of Button Play --
            winnerlabel = new JLabel("Score : 0"); //   Score : 0 
            winnerlabel.setForeground(new Color(230,180,55));
            winnerlabel.setFont(new Font("Wide Latin",Font.BOLD,25));
            winnerlabel.setBounds(80,55,570,50);
            add(winnerlabel);
            // -- Winner Label
            
            
            // -- end of winner label
            
            // -- JPanel with gradient and its items-- 
            
            panel = new drawBackground(); // Vezi creearea background-ului
            panel.setBounds(20,100,655,560);
            
            icon1 = new ImageIcon(getClass().getResource("Stop_1.png"));
            icon2 = new ImageIcon(getClass().getResource("Stop_2.png"));
            icon3 = new ImageIcon(getClass().getResource("Stop_3.png"));
            BStop = new JLabel(icon1);
            BStop.setBounds(40,110,65,45);
            add(BStop);
            
            you = new JLabel ("YOU :");
            you.setBounds(40,180,85,25);
            you.setFont(new Font("Ravie",Font.BOLD,23));
            add(you);
            
            tf1 = new JTextField();
            tf1.setEditable(false);
            tf1.setBounds(40,210,150,30);
            tf1.setBackground(new Color(197,170,11));
            tf1.setFont(new Font("Century",Font.BOLD,15));
            tf1.setBorder( BorderFactory.createLoweredSoftBevelBorder());
            add(tf1);
            
            cpu = new JLabel("CPU :");
            cpu.setBounds(505,180,85,25);
            cpu.setFont(new Font("Ravie",Font.BOLD,23));
            add(cpu);
            
            tf2 = new JTextField();
            tf2.setBounds(505,210,150,30);
            tf2.setBackground(new Color(197,170,11));
            tf2.setFont(new Font("Century",Font.BOLD,15));
            tf2.setEditable(false);
            tf2.setBorder( BorderFactory.createLoweredSoftBevelBorder());
            add(tf2);

            list = new JList(dlm);

            list.setSelectionBackground(new Color(252,150,76));
            list.setBounds(202,215,290,425);
            list.setOpaque(false);
            list.setBackground(new Color(0, 0, 0, 0));
            list.setForeground(Color.WHITE);
            list.setBorder(BorderFactory.createLoweredSoftBevelBorder()); 
            list.setFont(new Font("Tempus Sans ITC",Font.BOLD,20));
            list.setForeground(Color.LIGHT_GRAY);
            
            sp = new JScrollPane(list);
            sp.setBounds(202,215,290,425);
            sp.setOpaque(false);
            sp.getViewport().setOpaque(false);
            sp.setBorder(BorderFactory.createEmptyBorder());
            autoscroll = true;
            
            sp.getVerticalScrollBar().addAdjustmentListener( new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged(AdjustmentEvent e) {
                    if(autoscroll)
                    e.getAdjustable().setValue(e.getAdjustable().getMaximum());
                }
            });
            
            sp.addMouseWheelListener(new MouseWheelListener(){

                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    if( e.getWheelRotation() > 0 ) // down scroll
                        autoscroll=true;
                    else autoscroll=false;
                        
                        }
            });

            sp.getVerticalScrollBar().setOpaque(false);
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(sp);
            
            fazan_panel1 = new JPanel();
            fazan_panel1.setOpaque(false);
            fazan_panel1.setBounds(40,605,150,40);
            add(fazan_panel1);
            
            
            fazan_tf1 = new JTextField("");
            fazan_tf1.setFont(new Font("Wide Latin",Font.BOLD,19));
            fazan_tf1.setForeground(new Color(248,197,14));
           // fazan_tf1.setBackground(new Color(248,197,14));
            
            fazan_tf1.setOpaque(false);
            fazan_tf1.setPreferredSize(new Dimension(130,30));
            fazan_tf1.setBorder(BorderFactory.createEmptyBorder());
            //fazan_tf1.enable(false);
            fazan_tf1.setEditable(false);
            fazan_panel1.add(fazan_tf1);
            // panel de jos in care scrie FAZAN
            
            fazan_panel2 = new JPanel();
            fazan_panel2.setOpaque(false);
            fazan_panel2.setBounds(505,605,150,40);
            add(fazan_panel2);
            
            fazan_tf2 = new JTextField("");
            fazan_tf2.setOpaque(false);
            fazan_tf2.setFont(new Font("Wide Latin",Font.BOLD,19));
            fazan_tf2.setForeground(new Color(248,197,14));
            fazan_tf2.setBorder(BorderFactory.createEmptyBorder());
            fazan_tf2.setOpaque(false);
            fazan_tf2.setPreferredSize(new Dimension(130,30));
            fazan_tf2.setEditable(false);
            fazan_panel2.add(fazan_tf2);
            
            
            icon4 = new ImageIcon(getClass().getResource("Skip_1.png"));
            icon5 = new ImageIcon(getClass().getResource("Skip_2.png"));
            icon6 = new ImageIcon(getClass().getResource("Skip_3.png"));
            BSkip = new JLabel(icon4);
            BSkip.setBounds(110,110,65,45);
            add(BSkip);
            // --end of JPanel--
            // 110 , 115, 555, 38
                    
            // -- JPanel for Alphabet --
            panel2 = new JPanel();
            panel2.setOpaque(false);
            panel2.setBounds(180,110,475,40);
            add(panel2);
            // -- end of JPanel --

            Listeners();
            
            add(panel);
            pack();
            setSize(700,700);
    } 

    private void pc_turn(){
        
       int index;
       
                repeta=false;
                try{
                while(1!=0){
                    Random r = new Random();
                    index =  r.nextInt()%n;
                    index = java.lang.Math.abs(index);
                    String last = (String) dlm.lastElement();
                    char[] last_chars = { last.charAt(last.length()-2) , last.charAt(last.length()-1) };
                    String last_chars_string = new String( new StringBuilder().append(last_chars));
                    if(dict[index].startsWith(last_chars_string))
                    {
                        tf2.setText(dict[index]);
                        dlm.addElement(dict[index]);
                        
                        break;
                    }
                }}
                catch(Exception e){
                    cpu_score++;
                    switch(cpu_score){
                        case 1 : {fazan_tf2.setText("F");break;}
                        case 2 : {fazan_tf2.setText("FA");break;}
                        case 3 : {fazan_tf2.setText("FAZ");break;}
                        case 4 : {fazan_tf2.setText("FAZA");break;}
                        case 5 : {fazan_tf2.setText("FAZAN");break;}
                    }
                    if(cpu_score==5){
                        
                        winnerlabel.setText("You have won! Score : "+SCOR );
                        
                        try {
                FileReader fr = new FileReader("Score.txt");
                BufferedReader br = new BufferedReader(fr);
               // JOptionPane.showMessageDialog(null, "The highest score is : " + br.readLine(),"Highest score",JOptionPane.INFORMATION_MESSAGE);
                highest_score = Integer.valueOf(br.readLine());
                fr.close();
                br.close();
                
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        
                        try {
                                PrintWriter pw = new PrintWriter("Score.txt","UTF-8");
                                if(highest_score<SCOR)
                                pw.write( String.valueOf(SCOR) );
                                //System.out.println(sc);
                                else pw.write( String.valueOf(highest_score));
                                pw.close();
                                
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                    else{
                    BPlay.setEnabled(true);
                    BPlay.doClick();
                            }
                }
                
    }
    
    private void Listeners() {
        
        BSkip.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(repeta==false){
               player_score++;
                        switch(player_score){
                        case 1 : {fazan_tf1.setText("F");break;}
                        case 2 : {fazan_tf1.setText("FA");break;}
                        case 3 : {fazan_tf1.setText("FAZ");break;}
                        case 4 : {fazan_tf1.setText("FAZA");break;}
                        case 5 : {fazan_tf1.setText("FAZAN");break;}  
                    }
                        if(player_score==5)
                        {    winnerlabel.setText("You have lost! Score : "+SCOR);
                            
                         try {
                FileReader fr = new FileReader("Score.txt");
                BufferedReader br = new BufferedReader(fr);
               // JOptionPane.showMessageDialog(null, "The highest score is : " + br.readLine(),"Highest score",JOptionPane.INFORMATION_MESSAGE);
                highest_score = Integer.valueOf(br.readLine());
                fr.close();
                br.close();
                
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        
                        
                        try {
                                PrintWriter pw = new PrintWriter("Score.txt","UTF-8");
                                if(highest_score<SCOR)
                                pw.write( String.valueOf(SCOR) );
                                else pw.write( String.valueOf(highest_score));
                                //System.out.println(sc);
                                pw.close();
                                
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else{
                        BPlay.setEnabled(true);
                        BPlay.doClick();;
                        }
                        tf1.setText("");}
            }

            @Override
            public void mousePressed(MouseEvent e) {
                BSkip.setIcon(icon6);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                BSkip.setIcon(icon5);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                BSkip.setIcon(icon5);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BSkip.setIcon(icon4);
            }
        });
        
        tf1.addActionListener(new ActionListener(){
            
            @Override
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e){
                String last = (String) dlm.lastElement();
                //System.out.println(last);
                char[] last_chars = { last.charAt(last.length()-2), last.charAt(last.length()-1) };
                //System.out.println(last_chars);
                String last_chars2 = new String( new StringBuilder().append(last_chars) );
                //System.out.println(last_chars2);
                
                
                if(tf1.getText().toUpperCase().startsWith(last_chars2))
                {
                    //int pos = Arrays.binarySearch(dict, tf1.getText().toUpperCase() );
                        int pos = -1;
                        for(int i=0;i<n;i++)
                            if( tf1.getText().toUpperCase().equals(dict[i]))
                            { pos = i ; break; }
                    
                    //System.out.println(pos);
                    if(pos<0)
                    JOptionPane.showMessageDialog(null, "Please try again","Invalid word !",JOptionPane.INFORMATION_MESSAGE);
                    else
                    {
                        dlm.addElement(tf1.getText().toUpperCase());
                        tf1.setText("");
                        SCOR++;
                        winnerlabel.setText("   Score : "+SCOR);
                        pc_turn();
                    }
                }
                
                else {
                new Thread(){
                    @Override
                    public void run(){
                        if( JOptionPane.showConfirmDialog(null , "Do you want to skip your turn ?", "You have entered a wrong word!", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION )
                        {
                        player_score++;
                        switch(player_score){
                        case 1 : {fazan_tf1.setText("F");break;}
                        case 2 : {fazan_tf1.setText("FA");break;}
                        case 3 : {fazan_tf1.setText("FAZ");break;}
                        case 4 : {fazan_tf1.setText("FAZA");break;}
                        case 5 : {fazan_tf1.setText("FAZAN");break;}  
                    }
                        if(player_score==5)
                        {    winnerlabel.setText("You have lost! Score : "+SCOR);
                        
                        try {
                FileReader fr = new FileReader("Score.txt");
                BufferedReader br = new BufferedReader(fr);
               // JOptionPane.showMessageDialog(null, "The highest score is : " + br.readLine(),"Highest score",JOptionPane.INFORMATION_MESSAGE);
                highest_score = Integer.valueOf(br.readLine());
                fr.close();
                br.close();
                
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                        
                            try {
                                
                                PrintWriter pw = new PrintWriter("Score.txt","UTF-8");
                                if(highest_score<SCOR)
                                pw.write( String.valueOf(SCOR) );
                                //System.out.println(sc);
                                else pw.write( String.valueOf(highest_score));
                                pw.close();
                                
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else{
                        BPlay.setEnabled(true);
                        BPlay.doClick();;
                        }
                        tf1.setText("");
                        }        
                            
                            
                    }
                }.start();
                }
            }
        });
        
        BOpen.addActionListener(new ActionListener(){
            @Override
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e){
                new Thread(){
                   public void run(){
                JFileChooser filechooser = new JFileChooser();
                filechooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
                
                if(filechooser.showOpenDialog(null) == JFileChooser.OPEN_DIALOG){
                    try {
                        
                        FileReader filereader = new FileReader ( filechooser.getSelectedFile() );
                        BufferedReader br = new BufferedReader(filereader);
                        int i=1;
                        while (( dict[i++] = br.readLine())!=null); 
                        //System.out.println(i + " cuvinte");
                        n=i-1;
                        BOpen.setEnabled(false);
                        BPlay.setEnabled(true);
                       // System.out.println(dict[n-1]); // ultimul cuvant
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "File Not Found Exception has been thrown!", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "File couldn't be read!","Error",JOptionPane.ERROR_MESSAGE);
                    }finally{
                       ;// Arrays.sort(dict);
                    }
                }}
                }.start();
                
                
            }
        });
        
        BPlay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    prima_tura=true;
                    BPlay.setEnabled(false);
                    repeta=true;
                    tf1.setEditable(false);
                    abc="";
                    Alphabet = new JLabel("");
                    panel2.removeAll();
                    panel2.repaint();
                    panel2.add(Alphabet);
                    Alphabet.setFont(new Font("Comic Sans MS",Font.PLAIN,21));
                    Alphabet.setForeground(new Color(18,114,20));
                   // Alphabet.setBackground(Color.BLACK);
                    
                Thread t = new Thread(){
                    
                    @Override
                    public void run(){
                        for(int i=65;i<=90;i++)
                        if(repeta==true)
                        {
                        try {
                            sleep(50);
                            panel2.removeAll();
                            Alphabet.removeAll();
                            Alphabet=null;
                            sleep(50);
                            abc = abc + (char)i + " " ;
                            
                            Alphabet =  new JLabel(abc);
                            panel2.add(Alphabet);
                            Alphabet.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
                            Alphabet.setForeground(new Color(18,114,20));
                           // System.out.println(abc);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        }
                        else break;
                        if(repeta==true)
                        try {
                            sleep(50);
                        abc = "";
                        Alphabet.removeAll();
                        panel2.removeAll();;
                        panel2.repaint();  // Pot aparea bug-uri de la vechile JLabel-uri
                        //panel2.revalidate();
                        }catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(repeta==true)
                            run();
                    }
                };
                
                t.start();
               
                
            }
            });

        BStop.addMouseListener(new MouseListener(){
            @Override
            public void mouseEntered(MouseEvent e){
                BStop.setIcon(icon2);
            }
            
            @Override
            @SuppressWarnings("empty-statement")
            public void mouseClicked(MouseEvent e) {
                if(tf1.isEditable()==false && prima_tura==true){
                int index;
                
                repeta=false;
                char c = abc.charAt(abc.length()-2);
                c+=1;   // Un decalaj de o litera...
                
                //System.out.println(c);
                
                while(1!=0){
                    Random r = new Random();
                    index =  r.nextInt()%n;
                    index = java.lang.Math.abs(index);
                    if( dict[index].startsWith(c+"") ){
                        tf2.setText(dict[index]);
                        dlm.addElement(dict[index]);
                        break;
                    }
                }
                tf1.setEditable(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                BStop.setIcon(icon3);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               BStop.setIcon(icon2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               BStop.setIcon(icon1);
            } 
        });
        
        reset.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev){
            dlm.clear();
            fazan_tf1.setText("");
            fazan_tf2.setText("");
            player_score = 0;
            cpu_score = 0;
            BPlay.setEnabled(true);
            prima_tura = false;
            winnerlabel.setText("Score : 0");
            repeta=false;
            Alphabet.removeAll();
            panel2.removeAll();
            panel2.repaint();
            tf2.setText("");
            SCOR=0;
        }
        });
        score.addActionListener(new ActionListener()
        {@Override
        public void actionPerformed(ActionEvent e){
            try {
                FileReader fr = new FileReader("Score.txt");
                BufferedReader br = new BufferedReader(fr);
                JOptionPane.showMessageDialog(null, "The highest score is : " + br.readLine(),"Highest score",JOptionPane.INFORMATION_MESSAGE);
                fr.close();
                br.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }});
        
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "This game was created in Java.\nAuthor: Ilie Octavian\nRelease Date: 11/08/2014","About",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
    }

}
