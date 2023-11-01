package org.bmsk.racingcar.ui.input

class RacingCarInputView {
    fun inputNumberOfCars(): Int = readln().toInt()

    fun inputNumberOfAttempts(): Int = readln().toInt()

    fun inputNamesOfCars(): List<String> = readln().split(",")
}
