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
 *
 * @author Perfect978
 */
public class AlternatioveView implements AllView,Showable{

    private final String mName;
    private final Window mWindow;
    private final Model mModel;
    String s = "";
    
    public AlternatioveView(String name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
    }
    
    public void invalidate() {
        mWindow.schduleRedraw(this);
    }
    
    public void show()
    {
        String s = mModel.getData();
        String schange = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            schange += s.substring(i, i+1);
        }
        System.out.println("View (" + mName + "): " + schange);
        
    }

    //@Override
    public void onDraw() {
        Updata();
    }
    
    public void Updata()
    {
        if(!s.equals(mModel.getData())) show();
        s = mModel.getData();
    }
}
