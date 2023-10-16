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
): Bitmap? {
    if (width <= 0 || height <= 0) return null

    val sourceWidth = this.width
    val sourceHeight = this.height

    if (sourceWidth <= 0 || sourceHeight <= 0) return null

    val scaleX = width.toFloat() / sourceWidth
    val scaleY = height.toFloat() / sourceHeight
    val scaleFactor = if (scaleX > scaleY) scaleX else scaleY
    val scaledWidth = (sourceWidth * scaleFactor).toInt()
    val scaledHeight = (sourceHeight * scaleFactor).toInt()

    val x = (scaledWidth - width) / 2
    val y = (scaledHeight - height) / 2

    if (x + width > scaledWidth) {
        // 裁剪的范围超出了源位图的宽度
        return null
    }

    if (y + height > scaledHeight) {
        // 裁剪的范围超出了源位图的高度
        return null
    }

    val scaledBitmap = Bitmap.createScaledBitmap(this, scaledWidth, scaledHeight, true)

    return Bitmap.createBitmap(scaledBitmap, x, y, width, height)
}