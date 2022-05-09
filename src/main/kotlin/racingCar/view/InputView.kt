package racingCar.view

import racingCar.constants.Message

/**
 * 입력을 받고 로직을 시작하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class InputView {
    fun getNumberOfCars(): Int {
        printHowManyCars()
        return getInput()
    }

    private fun printHowManyCars() {
        println(Message.PrintingMessage.HOW_MANY_CAR)
    }

    fun getNumberOfRaces(): Int {
        printHowManyTimesRace()
        return getInput()
    }

    private fun printHowManyTimesRace() {
        println(Message.PrintingMessage.HOW_MANY_TIMES_RACE)
    }

    private fun getInput(): Int {
        return changeStringToInt(readlnOrNull())
    }

    private fun changeStringToInt(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(Message.ExceptionMessage.IS_NULL_OR_BLANK)
        }
        val output = input.toIntOrNull() ?: throw IllegalArgumentException(Message.ExceptionMessage.IS_NOT_INTEGER)
        if (output < CAN_VALID_NUMBER) {
            throw IllegalArgumentException(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
        }
        return output
    }

    companion object {
        private const val CAN_VALID_NUMBER = 1
    }
}
