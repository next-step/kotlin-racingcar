package ractingCar.ui

import ractingCar.constants.Messages
import ractingCar.lib.Validation

class InputView {
    fun getInput(): List<Int> {
        println(Messages.NUMBER_OF_CAR)
        val numOfCars = Validation().isNumber(readln())

        println(Messages.NUMBER_OF_MOVES)
        val numOfMoves = Validation().isNumber(readln())
        return listOf<Int>(numOfCars, numOfMoves)
    }
}