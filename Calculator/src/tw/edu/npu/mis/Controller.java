/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 *
 * @author STP
 */
public class Controller implements java.awt.event.ActionListener{
    
        Calculator mModel;
        View mView;
        
        public void actionPerformed(java.awt.event.ActionEvent e){
            String s = e.getSource().toString().substring(e.getSource().toString().indexOf("text=")+5, e.getSource().toString().lastIndexOf(","));
            mModel.setEvent(s);
	}
    
        public void addModel(Calculator m){
		this.mModel = m;
	}
    
        public void addView(View v){
		this.mView = v;
	}
}
