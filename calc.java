import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
class calc implements ActionListener
{
    JFrame base;
    JTextField inputText;
    JButton nums[]= new JButton[10];
    JButton addB,sub,mul,div,dec,eql,del,clr;
    JPanel panel;
    double num1=0,num2=0,result=0;
    int neg=0;
    char op='N';
    calc()
    {
        base=new JFrame("Calculator");
        base.setDefaultCloseOperation(base.EXIT_ON_CLOSE);
        base.setSize(400,600);
        base.setLayout(null);
        
        
    }   
    void addButtons()
    {
        panel=new JPanel();//adding panel for numbers
        panel.setBounds(20,90,360,360);
        panel.setLayout(new GridLayout(4,4,10,10));
        base.add(panel);
        inputText=new JTextField("");//setting textbox
        inputText.setEditable(false);
        inputText.setBounds(20,15,360, 60);
        base.add(inputText);
        for(int i=0;i<10;i++)//creating number buttons
        {
            nums[i]=new JButton(Integer.toString(i));
            nums[i].addActionListener(this);
            nums[i].setFocusable(false);
            nums[i].setFont(new Font("SansSerif",Font.PLAIN,20));
        }
        addB= new JButton("+");
        addB.addActionListener(this);
        sub=new JButton("-");
        sub.addActionListener(this);
        mul=new JButton("X");
        mul.addActionListener(this);
        div=new JButton("/");
        div.addActionListener(this);
        dec=new JButton(".");
        dec.addActionListener(this);
        dec.setFocusable(false);
        eql=new JButton("=");
        eql.addActionListener(this);
        del=new JButton("Delete");
        del.addActionListener(this);
        del.setBounds(110,470,85,85);
        clr=new JButton("Clear");
        clr.addActionListener(this);
        clr.setBounds(208,470,85,85);
        panel.add(nums[1]);
        panel.add(nums[2]);
        panel.add(nums[3]);
        panel.add(addB);
        panel.add(nums[4]);
        panel.add(nums[5]);
        panel.add(nums[6]);
        panel.add(sub);
        panel.add(nums[7]);
        panel.add(nums[8]);
        panel.add(nums[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(nums[0]);
        panel.add(eql);
        panel.add(div);
        base.add(del);
        base.add(clr);
        base.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)//adding numbers to the textbox
        {
            if(e.getSource()==nums[i])
            {
                inputText.setText(inputText.getText().concat(Integer.toString(i)));
            }
        }   
        if(e.getSource()==addB)//add button pressed
        {
            op='+';
            // if(num1!=0)
            // {
            //     num2=Double.parseDouble(inputText.getText());
            //     num1=num1+num2;
            //     num2=0;
            // }
            // else
            num1=Double.parseDouble(inputText.getText());
            inputText.setText("");
            
        }
        if(e.getSource()==sub)//subtract button pressed
        {
            if(inputText.getText().equalsIgnoreCase(""))//negative numbers
            {
                inputText.setText("-");
            }
            else{
                op='-';
            //     if(num1!=0)
            // {
            //     num2=Double.parseDouble(inputText.getText());
            //     num1=num1-num2;
            //     num2=0;
            // }
            // else
            num1=Double.parseDouble(inputText.getText());
            
            inputText.setText("");
            }
        }
        if(e.getSource()==mul)//multiplication pressed
        {
            op='*';
            // if(num1!=0)
            // {
            //     num1=Double.parseDouble(inputText.getText());
            //     num1=num1*num2;
            //     num2=0;
            // }
            // else
            
            num1=Double.parseDouble(inputText.getText());
            
            inputText.setText("");
        }
        if(e.getSource()==div)//division pressed
        {
            op='/';
            // if(num1!=0)
            // {
            //     num2=Double.parseDouble(inputText.getText());
            //     num1=num1/num2;
            //     num2=0;
            // }
            // else
            num1=Double.parseDouble(inputText.getText());
            inputText.setText("");
        }
        if(e.getSource()==dec)//decimal point added
        {
            inputText.setText(inputText.getText().concat("."));
        }
        if(e.getSource()==del)
        {
            inputText.setText(inputText.getText().substring(0,inputText.getText().length()-1));
        }
        if(e.getSource()==clr)
        {
            op='N';
            num1=0;
            num2=0;
            inputText.setText("");
        }
        if(e.getSource()==eql)
        {
            try{
            num2=Double.parseDouble(inputText.getText());
            switch(op)
            {
                case '+':result=num1+num2;
                break;
                case '-':result=num1-num2;
                break;
                case '*':result=num1*num2;
                break;
                case '/':result=num1/num2;
                break;
                case 'N':result=num1;
                break;
            }
            inputText.setText(Double.toString(result));
            num1=result;
            num2=0;
            result=0;
        }
        catch(ArithmeticException e1)
        {
            num1=0;
            num2=0;
            op='N';
            inputText.setText("ERROR!");
        }
        }
    }
    public Double getResult(int n1,int n2)
    {
        return 0.0;
    }

     
    
    public static void main(String args[])
    {
       calc obj=new calc();
       obj.addButtons();

    }
}