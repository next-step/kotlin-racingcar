package me.parker.nextstep.kotlinracingcar.utils

object RandomNumberGenerator {
    fun generate(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1)).toInt() + min
    }
}