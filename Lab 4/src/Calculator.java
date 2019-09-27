import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DigitButtonListener implements ActionListener {
    private JButton btn;
    private JLabel label;

    public DigitButtonListener(JButton btn, JLabel label){
        this.btn = btn;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        label.setText(label.getText() + btn.getText());
    }
}

public class Calculator extends JFrame{
    private JButton a1Button;
    private JPanel panel1;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button4;
    private JButton a4Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button9;
    private JButton button10;
    private JButton a9Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton button14;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JButton button6;
    private JLabel screen;

    public Calculator(){
        setContentPane(panel1);
        setTitle("Калькулятор");
        setSize(400,450);
        setLocation(500,150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        screen.setText(" ");
        a1Button.addActionListener(new DigitButtonListener(a1Button, screen));
        a2Button.addActionListener(new DigitButtonListener(a2Button, screen));
        a3Button.addActionListener(new DigitButtonListener(a3Button, screen));
        a4Button.addActionListener(new DigitButtonListener(a4Button, screen));
        a5Button.addActionListener(new DigitButtonListener(a5Button, screen));
        a6Button.addActionListener(new DigitButtonListener(a6Button, screen));
        a7Button.addActionListener(new DigitButtonListener(a7Button, screen));
        a8Button.addActionListener(new DigitButtonListener(a8Button, screen));
        a9Button.addActionListener(new DigitButtonListener(a9Button, screen));
        a0Button.addActionListener(new DigitButtonListener(a0Button, screen));
        button1.addActionListener(new DigitButtonListener(button1, screen));
        button2.addActionListener(new DigitButtonListener(button2, screen));
        button3.addActionListener(new DigitButtonListener(button3, screen));
        button5.addActionListener(new DigitButtonListener(button5, screen));
        button6.addActionListener(new DigitButtonListener(button6, screen));
        button9.addActionListener(new DigitButtonListener(button9, screen));
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(!screen.getText().equals(" "))
                    screen.setText(screen.getText().substring(0,screen.getText().length()-1));
            }
        });
        button10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                screen.setText(" ");
            }
        });
    }

    public static void main(String[] args){
        new Calculator();
    }
}
