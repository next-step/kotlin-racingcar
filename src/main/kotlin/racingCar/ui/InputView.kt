package racingCar.ui

import racingCar.constants.Messages
import racingCar.lib.UserInputData
import racingCar.lib.Validation

class InputView {
    fun getInput(): UserInputData {
        //todo: 더 좋은 return 방법 -> dataclass 생성
        return UserInputData(getNumOfCarsInput(), getNumOfMovesInput())
    }

    private fun getNumOfCarsInput(): Int {
        println(Messages.NUMBER_OF_CAR)
        return Validation().isNumber(readln())
    }

    private fun getNumOfMovesInput(): Int {
        println(Messages.NUMBER_OF_MOVES)
        return Validation().isNumber(readln())
    }
}