/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;	//for CloseListener()
import java.awt.event.WindowAdapter;	//for CloseListener()
import javax.swing.JButton;

/**
 *
 * @author Perfect978
 */
public class View implements java.util.Observer{
    private TextField mTextField;
    private JButton[] mButtonArray; 
    private JButton mButton;
    //private JFrame mFrame;
    
    public View()
    {
        mButtonArray = new JButton[50];
        JFrame mFrame = new JFrame("Calculator");
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container ContentPane = mFrame.getContentPane();
        ContentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(5,5,5,5);

        int count = 0;
        String[] buttonTextArray = {"MC","MR","MS","M+","M-","←","CE","C","±","√","7","8","9","/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};
        for(int i = 1; i <= 6; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                
                gbc.gridx = j;
                gbc.gridy = i;
                
                if(count == 24)gbc.gridheight = 2;
                else if(count == 25)
                {
                    gbc.gridheight = 1;
                    gbc.gridwidth = 2;
                }
                //mButtonArray[count] = new Button(buttonTextArray[count]);
                mButtonArray[count] = new JButton("0");
                mButtonArray[count].setSize(new Dimension(50, 30));
                if(count == 24)
                {
                    gbc.gridheight = 2;
                }
                else if(count == 25)
                {
                    gbc.gridheight = 1;
                    gbc.gridwidth = 2;
                }
                ContentPane.add(mButtonArray[count], gbc);
                gbc.gridwidth = 1;
                
                if(count == 25) j++;
                count++;
            }
        }
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        mTextField = new TextField(15);
        ContentPane.add(mTextField, gbc);
        
        mButton = new JButton("Test");
        gbc.gridx = 0;
        gbc.gridy = 8;
        ContentPane.add(mButton, gbc);
        
        mFrame.setSize(200,100);
	mFrame.setLocation(100,100);
        mFrame.pack();
        mFrame.setVisible(true);
    }
    
    public void update(Observable obs, Object obj) {
        mTextField.setText("" + ((Integer)obj).intValue());
    }
    
    public void addController(ActionListener controller){
        //for(int i = 0; i <= 28; i++)mButtonArray[i].addActionListener(controller);
        mButton.addActionListener(controller);
    }
}
