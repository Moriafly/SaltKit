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

/**
 * Cut bitmap into a square, and take only the middle part of a rectangular bitmap
 */
fun Bitmap.toSquare(): Bitmap {
    if (width == height) {
        return this
    }
    // min of width and height
    val clipWidth = width.coerceAtMost(height)
    val x = (width - clipWidth) / 2
    val y = (height - clipWidth) / 2
    return Bitmap.createBitmap(this, x, y, clipWidth, clipWidth)
}