/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import javax.swing.JButton;

/**
 *
 * @author Perfect978
 */
public class ActionButton extends JButton{
    ActionButton(String name)
    {
        this.setText(name);
        //this.addActionListener(controller);
    }
}
