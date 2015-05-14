/*
 * WatchItem.java
 *
 * Copyright (c) 2015 DeNA Co., Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.dena.app.usage.watcher.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.dena.app.usage.watcher.util.WatchUtil;

public class WatchItem {

    public WatchItem(Context context, String packageName, int sec) {
        mPackageName = packageName;
        mSec = sec;
        mAppName = WatchUtil.searchAppName(context, packageName);
        mAppIcon = WatchUtil.searchAppIcon(context, packageName);
    }

    public void addSec(int sec) {
        mSec += sec;
    }

    public Drawable getAppIcon() {
        return mAppIcon;
    }

    public String getAppName() {
        return mAppName;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public int getSec() {
        return mSec;
    }

    public String getSecString() {
        int _minute = mSec / 60;
        int second = mSec % 60;
        int hour = _minute / 60;
        int minute = _minute % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    private Drawable mAppIcon;
    private String mAppName;
    private String mPackageName;
    private int mSec;
}