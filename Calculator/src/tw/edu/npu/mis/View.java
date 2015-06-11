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
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * View
 * 實作 java.util.Observer
 * 內有 28個JButton 1個JTextField 1個JLabel
 * @author Perfect978
 */
public class View implements java.util.Observer{
    private final JTextField mTextField;
    private final JButton[] mButtonArray;
    private final JLabel mLabel;
    
    /**
     * 設計JFrame畫面
     * 放入 28個JButton 1個JTextField 1個JLabel
     */
    public View()
    {
        mButtonArray = new JButton[28];
        JFrame mFrame = new JFrame("Calculator");
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container ContentPane = mFrame.getContentPane();
        ContentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(5,5,5,5);

        int count = 0;
        String[] buttonTextArray = {"MC","MR","MS","M+","M-","←","CE","C","±","√","7","8","9","/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};
        for(int i = 2; i <= 7; i++)
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
                else if(count == 28) break;
                mButtonArray[count] = new JButton(buttonTextArray[count]);
                mButtonArray[count].setSize(new Dimension(50, 30));

                ContentPane.add(mButtonArray[count], gbc);
                gbc.gridwidth = 1;
                
                if(count == 25) j++;
                count++;
            }
        }
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        mLabel = new JLabel(" ");
        ContentPane.add(mLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        mTextField = new JTextField(15);
        mTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ContentPane.add(mTextField, gbc);
        
        mFrame.pack();
        mFrame.setVisible(true);
    }
    
    /**
     * 更新顯示畫面內容
     * 判斷是否有 M
     * 有 M Label 顯示 M
     * 沒有 Label 顯示 空白
     * @param obs 接收 Observable 物件
     * @param obj 接收 Observable 的 notifyObservers 內容
     */
    @Override
    public void update(Observable obs, Object obj) {
        if(obj.toString().indexOf("M") >= 0)
        {
            mLabel.setText("M");
            mTextField.setText(obj.toString().substring(1, obj.toString().length()));
        }
        else 
        {
            mLabel.setText(" ");
            mTextField.setText(obj.toString());
            
        }
        
    }
    
    /**
     * 28個按鈕加入 Controller 行動事件
     * @param controller 傳入 Controller
     */
    public void addController(ActionListener controller){
        for(int i = 0; i < 28; i++)mButtonArray[i].addActionListener(controller);
    }
}
