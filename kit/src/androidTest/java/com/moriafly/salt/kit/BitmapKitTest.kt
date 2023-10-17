@file:Suppress("UNUSED")

/**
 * SaltKit
 * Copyright (C) 2023 Moriafly
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */

package com.moriafly.salt.kit

import android.graphics.Bitmap
import android.graphics.Color
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BitmapKitTest {

    @OptIn(UnstableSaltKitApi::class)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.moriafly.salt.kit.test", appContext.packageName)

        val b1 = BitmapKit.createBitmapFullColor(500, 1, Color.WHITE, Bitmap.Config.ARGB_8888)
        val bn1 = BitmapKit.centerCrop(b1, 500, 500)
        println("bn1 w = ${bn1.width} h = ${bn1.height}")

        val b2 = BitmapKit.createBitmapFullColor(500, 300, Color.WHITE, Bitmap.Config.ARGB_8888)
        val bn2 = BitmapKit.centerCrop(b2, 500, 500)
        println("bn2 w = ${bn2.width} h = ${bn2.height}")

        val b3 = BitmapKit.createBitmapFullColor(1000, 3000, Color.WHITE, Bitmap.Config.ARGB_8888)
        val bn3 = BitmapKit.centerCrop(b3, 500, 500)
        println("bn3 w = ${bn3.width} h = ${bn3.height}")

        val b4 = BitmapKit.createBitmapFullColor(20000, 15000, Color.WHITE, Bitmap.Config.RGB_565)
        val bn4 = BitmapKit.centerCrop(b4, 500, 500)
        println("bn4 w = ${bn4.width} h = ${bn4.height}")
    }

}