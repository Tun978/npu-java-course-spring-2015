/*
 * Copyright (c) 2015, Perfect978
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package tw.edu.npu.mis;

/**
 * 有名稱屬性 Window類別 Model類別
 * 有加入顯示排程的方法 invalidate
 * 顯示內容的方法 onDraw
 * 更新資料方法 upData
 * 文字反向顯示方法 show
 * @author Perfect978
 */
public class AlternatioveView extends AbstractView{

    private final String mName;
    private final Window mWindow;
    private final Model mModel;
    
    
    /**
     * AlternatioveView建構值
     * @param name 傳入要取的名稱
     * @param window 傳入Window類別
     * @param model 傳入Model類別
     */
    public AlternatioveView(String name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
        mModel.attach(this);
    }
    
    /**
     * 加入顯示排程
     * Invalidate the view, which indicates it needs to be redrawn later.
     */
    public void invalidate() {
        mWindow.schduleRedraw(this);
    }
    
    /**
     * 文字反向顯示方法
     */
    public void show()
    {
        System.out.println("View (" + mName + "): " + new StringBuilder(mModel.getData()).reverse());
    }

    /**
     * 顯示內容
     * Show the content of the model on the console.
     */
    public void onDraw() {
        show();
    }
}
