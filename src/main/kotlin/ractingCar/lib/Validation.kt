package ractingCar.lib

import ractingCar.constants.Messages.INPUT_NOT_NUMBER

class Validation {

    fun isNumber(s: String): Int {
        s.forEach { c: Char ->
            if (!c.isDigit()) throw IllegalArgumentException(INPUT_NOT_NUMBER)
        }
        return s.toInt()
    }
}