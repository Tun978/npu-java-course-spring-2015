/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 * Controller
 * 實作 java.awt.event.ActionListener
 * 有 Model View
 * @author STP
 */
public class Controller implements java.awt.event.ActionListener{
    
        private Calculator mModel;
        private View mView;
        
        /**
         * 行動事件
         * 取得行動的按鈕 Test
         * 傳入 Model 裡 setEvent方法
         * @param e 傳入行動
         */
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e){
            String s = e.getSource().toString().substring(e.getSource().toString().indexOf("text=")+5, e.getSource().toString().lastIndexOf(","));
            mModel.setEvent(s);
	}
    
        /**
         * 加入 Model
         * @param m 傳入 Model
         */
        public void addModel(Calculator m){
		this.mModel = m;
	}
    
        /**
         * 加入View
         * @param v 傳入 View
         */
        public void addView(View v){
		this.mView = v;
	}
}
