import javax.swing.*;

public class Event extends JFrame implements {
    JButton jb;
    JTextField txt1,txt2;
    JLabel lbl;

    Event(){

        txt1 = new JTextField("Enter First number");
        txt1 = new JTextField("Enter second number");
        jb= new JButton("sum");
        jb.addActionListener(this);

    }

    public void mouseClicked(ActionEvent e){
        int a,b,sum;
        a= Integer.parseInt(txt1.getInt());
        b= Integer.parseInt(txt2.getInt());
        sum = a +b ;
        lbl.setText("Sum of your NUmber is :" +sum);



}
