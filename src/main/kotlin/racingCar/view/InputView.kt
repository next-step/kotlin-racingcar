package racingCar.view

import racingCar.constants.Message

/**
 * 입력을 받고 로직을 시작하는 object
 * Created by Jaesungchi on 2022.05.07..
 */
object InputView {
    fun getNumberOfCars(readStringValue: () -> String? = { readlnOrNull() }): Int {
        printHowManyCars()
        return changeStringToInt(readStringValue())
    }

    private fun printHowManyCars() {
        println(Message.PrintingMessage.HOW_MANY_CAR)
    }

    fun getNumberOfRaces(readStringValue: () -> String? = { readlnOrNull() }): Int {
        printHowManyTimesRace()
        return changeStringToInt(readStringValue())
    }

    private fun printHowManyTimesRace() {
        println(Message.PrintingMessage.HOW_MANY_TIMES_RACE)
    }

    private fun changeStringToInt(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(Message.ExceptionMessage.IS_NULL_OR_BLANK)
        }
        return input.toIntOrNull() ?: throw IllegalArgumentException(Message.ExceptionMessage.IS_NOT_INTEGER)
    }
}
