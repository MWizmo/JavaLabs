import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

class DigitButtonListener implements ActionListener {
    private JButton btn;
    private JLabel label;

    DigitButtonListener(JButton btn, JLabel label){
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
    private String error;

    public Calculator(){
        setContentPane(panel1);
        error = "No";
        setTitle("Калькулятор");
        setSize(500,450);
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
        button14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                double res = countResult(screen.getText());
                if(error.equals("No"))
                    screen.setText(" " + String.valueOf(res));
                else{
                    showError();
                    screen.setText(" ");
                    error = "No";
                }
            }
        });
    }

    private void showError(){
        JOptionPane.showMessageDialog(this, error,"Ошибка при вычислении", JOptionPane.ERROR_MESSAGE);
    }

    private double countResult(String expression){
        expression = expression.trim();
        ArrayList<String> polish = reversePolishNotation(expression);
        if(!error.equals("No")){
            return 0.0;
        }
        Stack<Double> stack = new Stack<>();
        for(String elem:polish){
            if(isDouble(elem))
                stack.push(Double.parseDouble(elem));
            else{
                double second = stack.pop();
                double first = stack.pop();
                if(second==0 && elem.equals("/")){
                    error = "Деление на ноль";
                    return 0.0;
                }
                stack.push(calculate(first,second,elem));
            }
        }
        return stack.pop();
    }

    private double calculate(double first, double second, String sign){
        switch (sign){
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            case "^":
                return Math.pow(first,second);
        }
        return 0;
    }

    private boolean isDouble(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private ArrayList<String> reversePolishNotation(String expression){
        ArrayList<String> output = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = expression.toCharArray();
        int start = 0;
        if(chars[0]=='-') {
            str.append('-');
            start = 1;
        }
        else if(!Character.isDigit(chars[0])) {
            error = "Недопустимое начало выражения";
            return output;
        }
        for(int i=start; i<chars.length; i++){
            if(Character.isDigit(chars[i]))
                str.append(chars[i]);
            else if(chars[i]=='.')
                if(!Character.isDigit(chars[i-1])){
                    error = "Недопустимое использование \".\"";
                    return new ArrayList<>();
                }
                else
                    str.append(chars[i]);
            else {
                if (!Character.isDigit(chars[i-1])) {
                    error = "Неправильная расстановка арифметических знаков";
                    return new ArrayList<>();
                }
                if(str.length()>0){
                    output.add(str.toString());
                    str = new StringBuilder();
                }
                if(stack.empty() || getPriority(stack.peek())<getPriority(chars[i]))
                    stack.push(chars[i]);
                else{
                    while(!stack.empty() && getPriority(stack.peek())>=getPriority(chars[i])){
                        output.add(stack.pop().toString());
                    }
                    stack.push(chars[i]);
                }
            }
        }
        if(str.length()==0) {
            error = "Недопустимое окончание выражения";
            return new ArrayList<>();
        }
        output.add(str.toString());
        while(!stack.empty())
            output.add(stack.pop().toString());
        return output;
    }

    private int getPriority(char sign){
        int res = 1;
        switch (sign){
            case '+':
            case '-':
                res = 1;
                break;
            case '*':
            case '/':
                res = 2;
                break;
            case '^':
                res = 3;
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args){
        new Calculator();
    }
}
