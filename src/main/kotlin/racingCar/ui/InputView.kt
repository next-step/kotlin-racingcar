package racingCar.ui

import racingCar.constants.Messages
import racingCar.lib.Validation

class InputView {
    fun getNumOfCarsInput(): Int {
        println(Messages.NUMBER_OF_CAR)
        return Validation().isNumber(readln())
    }

    fun getNumOfMovesInput(): Int {
        println(Messages.NUMBER_OF_MOVES)
        return Validation().isNumber(readln())
    }
}