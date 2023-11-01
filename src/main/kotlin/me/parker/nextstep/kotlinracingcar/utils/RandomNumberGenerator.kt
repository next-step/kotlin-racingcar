package me.parker.nextstep.kotlinracingcar.utils

import java.util.Random

object RandomNumberGenerator {
    fun generate(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }
}