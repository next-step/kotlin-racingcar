package org.bmsk.racingcar.ui.input

class RacingCarInputView {
    fun inputNumberOfAttempts(): Int = readln().toInt()

    fun inputNamesOfCars(): List<String> = readln().split(",")
}
