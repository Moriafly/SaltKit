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
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint

object BitmapKit {

    private const val PAINT_FLAGS = Paint.DITHER_FLAG or Paint.FILTER_BITMAP_FLAG

    private val defaultPaint: Paint = Paint(PAINT_FLAGS)

    /**
     * Create a color bitmap
     */
    @UnstableSaltKitApi
    fun createBitmapFullColor(
        width: Int,
        height: Int,
        color: Int,
        config: Bitmap.Config
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, config)
        val canvas = Canvas(bitmap)
        canvas.drawColor(color)
        canvas.setBitmap(null)
        return bitmap
    }

    /**
     * Center crop bitmap
     * This api build with Glide/TransformationUtils.java and ImageView/Bitmap.createScaledBitmap
     */
    @UnstableSaltKitApi
    fun centerCrop(
        bitmap: Bitmap,
        width: Int,
        height: Int
    ): Bitmap {
        if (bitmap.width == width && bitmap.height == height) {
            return bitmap
        }
        // From ImageView/Bitmap.createScaledBitmap
        val scale: Float
        val dx: Float
        val dy: Float
        val matrix = Matrix()
        if (bitmap.width * height > width * bitmap.height) {
            scale = height.toFloat() / bitmap.height.toFloat()
            dx = (width - bitmap.width * scale) * 0.5f
            dy = 0f
        } else {
            scale = width.toFloat() / bitmap.width.toFloat()
            dx = 0f
            dy = (height - bitmap.height * scale) * 0.5f
        }

        matrix.setScale(scale, scale)
        matrix.postTranslate((dx + 0.5f).toInt().toFloat(), (dy + 0.5f).toInt().toFloat())

        val result = Bitmap.createBitmap(width, height, bitmap.config ?: Bitmap.Config.ARGB_8888)
        val canvas = Canvas(result)
        canvas.drawBitmap(bitmap, matrix, defaultPaint)
        canvas.setBitmap(null)
        return result
    }

    /**
     * Cut bitmap into a square, and take only the middle part of a rectangular bitmap
     */
    @UnstableSaltKitApi
    fun square(bitmap: Bitmap): Bitmap {
        val width = bitmap.width
        val height = bitmap.height
        if (width == height) {
            return bitmap
        }
        val clipWidth = if (width > height) height else width
        val x = (width - clipWidth) / 2
        val y = (height - clipWidth) / 2
        return Bitmap.createBitmap(bitmap, x, y, clipWidth, clipWidth)
    }

}

@UnstableSaltKitApi
fun Bitmap.centerCrop(width: Int, height: Int): Bitmap = BitmapKit.centerCrop(this, width, height)

@UnstableSaltKitApi
fun Bitmap.toSquare(): Bitmap = BitmapKit.square(this)