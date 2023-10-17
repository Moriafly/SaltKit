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
 * Compares Strings (or any other CharSequence subclass) using the
 * [natural sort](http://blog.codinghorror.com/sorting-for-humans-natural-sort-order/) /
 * [alphanum algorithm](http://www.davekoelle.com/alphanum.html) which gives a more
 * "natural" ordering when presenting the sorted list of strings to humans.
 *
 * This is a fast implementation of the original algorithm which produces no garbage during its run.
 * There is also a case-insensitive variant you might want to use:
 * CaseInsensitiveSimpleNaturalComparator. This is a fully self-contained implementation
 * compiled with Java 1.6 for maximum compatibility which does not add any additional dependencies
 * to your project.
 *
 * There are still limitations of this implementation to be aware of (which hopefully will be
 * addressed in future releases):
 *
 * Does not play nice with Unicode, especially characters which are outside of the BMP (ie.
 * codepoints with values larger than [Character.MAX_VALUE]).
 * Does not handle fractions or grouping characters properly.
 * Only understands integer values up to 2^64-1.
 */
object NaturalComparator : AbstractNaturalComparator(), Comparator<CharSequence> {

    override fun compareChars(c1: Char, c2: Char): Int {
        return c1.code - c2.code
    }

}