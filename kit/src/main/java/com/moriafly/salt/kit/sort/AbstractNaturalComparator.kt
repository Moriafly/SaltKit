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

package com.moriafly.salt.kit.sort

/**
 * Based on <a href="https://github.com/gpanther/java-nat-sort">...</a> under Apache-2.0 license
 * Improved sorting of punctuation and letters
 */
abstract class AbstractNaturalComparator: Comparator<CharSequence> {

    override fun compare(o1: CharSequence, o2: CharSequence): Int {
        val len1 = o1.length
        val len2 = o2.length
        var idx1 = 0
        var idx2 = 0
        while (idx1 < len1 && idx2 < len2) {
            val c1 = o1[idx1++]
            val c2 = o2[idx2++]
            val isDigit1 = c1.isDigit()
            val isDigit2 = c2.isDigit()

            when {
                isDigit1 && !isDigit2 -> return -1
                !isDigit1 && isDigit2 -> return 1
                isDigit1 && isDigit2 -> {
                    var num1 = parse(c1)
                    while (idx1 < len1) {
                        val digit = o1[idx1++]
                        num1 = if (digit.isDigit()) {
                            num1 * 10 + parse(digit)
                        } else {
                            idx1--
                            break
                        }
                    }
                    var num2 = parse(c2)
                    while (idx2 < len2) {
                        val digit = o2[idx2++]
                        num2 = if (digit.isDigit()) {
                            num2 * 10 + parse(digit)
                        } else {
                            idx2--
                            break
                        }
                    }
                    if (num1 != num2) {
                        return compareUnsigned(num1, num2)
                    }
                }

                else -> {
                    val c = compareChars(c1, c2)
                    if (c != 0) {
                        return c
                    }
                }
            }
        }

        return when {
            idx1 < len1 -> 1
            idx2 < len2 -> -1
            else -> 0
        }
    }

    /**
     * Compare with not digit char
     */
    abstract fun compareChars(c1: Char, c2: Char): Int

    private fun compareUnsigned(num1: Long, num2: Long): Int {
        return compare(num1 + Long.MIN_VALUE, num2 + Long.MIN_VALUE)
    }

    private fun compare(x: Long, y: Long): Int {
        return x.compareTo(y)
    }

    private fun parse(c: Char): Long {
        return (c.code - '0'.code).toLong()
    }

}