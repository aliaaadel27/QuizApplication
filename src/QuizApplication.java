import java.awt.event.*;
import javax.swing.*;

class QuizApplication extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton[] jb =new JRadioButton[5];
    JButton b1;
    ButtonGroup bg;
    int count=0,current=0;
    QuizApplication(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b1.addActionListener(this);
        add(b1);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==4)
            {
                b1.setEnabled(true);
                b1.setText("Result");
            }
        }


        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"correct ans="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1:Which sorting algorithm has the best time complexity?");
            jb[0].setText("Bubble Sort");
            jb[1].setText("Quick Sort");
            jb[2].setText("Heap Sort");
            jb[3].setText("Merge Sort");

        }
        if(current==1)
        {
            l.setText("Que2:Which of the following is NOT a fundamental data structure?");
            jb[0].setText("Array");
            jb[1].setText("Linked List");
            jb[2].setText("Tree");
            jb[3].setText("Variable");
        }
        if(current==2)
        {
            l.setText("Que3:What is the purpose of an algorithm?");
            jb[0].setText("To execute tasks");
            jb[1].setText("To test software");
            jb[2].setText("To solve problems");
            jb[3].setText("To write code");
        }
        if(current==3)
        {
            l.setText("Que4:What does SQL stand for?");
            jb[0].setText("Structured Query Language");
            jb[1].setText("System Query Language");
            jb[2].setText("Sequential Query Language");
            jb[3].setText("Structured Question Language");
        }
        if(current==4)
        {
            l.setText("Que5:What does TCP stand for?");
            jb[0].setText("Transmission Control Protocol");
            jb[1].setText("Transfer Control Protocol");
            jb[2].setText("Text Control Protocol");
            jb[3].setText("Time Control Protocol");
        }

        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[3].isSelected());
        if(current==1)
            return(jb[3].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[0].isSelected());

        return false;
    }
    public static void main(String[] args)
    {
        new QuizApplication("Computer Science Fundamentals Quiz");
    }
}