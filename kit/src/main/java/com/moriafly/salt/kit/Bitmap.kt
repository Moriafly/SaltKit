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
    val clipWidth = if (width > height) height else width
    val x = (width - clipWidth) / 2
    val y = (height - clipWidth) / 2
    return Bitmap.createBitmap(this, x, y, clipWidth, clipWidth)
}

/**
 * Center crop bitmap
 */
fun Bitmap.centerCrop(
    width: Int,
    height: Int
): Bitmap {
    val scaleX = width.toFloat() / this.width
    val scaleY = height.toFloat() / this.height
    val scaleFactor = if (scaleX > scaleY) scaleX else scaleY
    val scaledWidth = (this.width * scaleFactor).toInt()
    val scaledHeight = (this.height * scaleFactor).toInt()
    val x = (scaledWidth - width) / 2
    val y = (scaledHeight - height) / 2
    return Bitmap.createBitmap(this, x, y, width, height)
}