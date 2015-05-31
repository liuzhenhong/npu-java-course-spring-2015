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

/**
 * {@link View} generates outputs to the user.
 *
 * @author Samael Wang <freesamael@gmail.com>
 */
public class View extends AllView{

    private final String mName;
    private final Window mWindow;
    private final Model mModel;
     /**
     * view的抽象類別 有下列參數的建構式
     * @param name 
     * @param window 
     * @param model 
     */

    public View(String name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
        mModel.attach(this);
    }
    /**
     *把View加入Window類別中View陣列裡 
     */
    /**
     * Invalidate the view, which indicates it needs to be redrawn later.
     */
    public void invalidate() {
        mWindow.schduleRedraw(this);
    }

    /**
     * Show the content of the model on the console.
     */
    public void onDraw() {
        System.out.println("View (" + mName + "): " + mModel.getData());
    }
    /**
     * Model的資料有新增的話, 就會呼叫View
     */ 
    @Override
    public void update() {
        invalidate();
    }
}
