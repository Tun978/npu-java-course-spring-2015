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
		//mModel.appendDigit(1);
                mModel.incrementValue();
	}
    
        public void addModel(Calculator m){
		this.mModel = m;
	}
    
        public void addView(View v){
		this.mView = v;
	}
        
        public void initModel(int x){
		mModel.setValue(x);
	}
}
