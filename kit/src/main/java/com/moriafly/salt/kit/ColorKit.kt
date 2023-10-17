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

import android.graphics.Color

object ColorKit {

    /**
     * Mix color
     */
    @UnstableSaltKitApi
    fun mix(vararg colors: Int): Int {
        var red = 0
        var green = 0
        var blue = 0
        colors.forEach {
            red += Color.red(it)
            green += Color.green(it)
            blue += Color.blue(it)
        }
        red /= colors.size
        green /= colors.size
        blue /= colors.size
        return Color.rgb(red, green, blue)
    }

}