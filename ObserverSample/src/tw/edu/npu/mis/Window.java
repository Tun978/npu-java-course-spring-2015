/*
 * Copyright (c) 2015, Samael Wang <freesamael@gmail.com>
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

import java.util.ArrayList;
import java.util.List;

/**
 * Simulate Window objects in GUI toolkits.
 * 有Controller的類別Showable的陣列
 * 偵測輸入的方法 startEventLoop
 * 加入顯示排程的方法 schduleRedraw
 * @author Samael Wang <freesamael@gmail.com>
 */
public class Window {

    private Controller mController;
    private List<Showable> mInvalidViews = new ArrayList<>();

    /**
     * Start the event loop.
     *偵測controller是否有輸入
     * 輸入有值View就顯示
     * 顯示完就歸還Showable空間
     * @param c The controller.
     */
    
    public void startEventLoop(Controller c) {
        mController = c;

        // Simulate how an event loop works.
        while (true) {
            mController.readInput();
            for (Showable v : mInvalidViews) {
                v.onDraw();
            }
            mInvalidViews.clear();
        }
    }

    
    
    /**
     * Add a view to a queue for redraw on screen later.
     *加入顯示排程
     * @param v View to redraw.
     */
    public void schduleRedraw(Showable v) {
        mInvalidViews.add(v);
    }
}
