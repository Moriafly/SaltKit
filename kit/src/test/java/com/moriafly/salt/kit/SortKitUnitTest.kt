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

import com.moriafly.salt.kit.sort.SortKit
import org.junit.Test

class SortKitUnitTest {

    @OptIn(UnstableSaltKitApi::class)
    @Test
    fun sortNatural() {
        val list = listOf(
            "【完善",
            "_您好",
            "As",
            "?a",
            "?",
            ".",
            "0",
            "9",
            "Z",
            "w",
            "123",
            "{"
        )
        val sorted = SortKit.sortedByNatural(list) {
            it
        }
        println(sorted.joinToString())
    }

}