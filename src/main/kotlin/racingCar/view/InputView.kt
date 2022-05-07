package racingCar.view

import racingCar.etc.Message

/**
 * 입력을 받고 로직을 시작하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class InputView {
    fun printHowManyCars() {
        println(Message.PrintingMessage.HOW_MANY_CAR)
    }

    fun printHowManyTimesRace() {
        println(Message.PrintingMessage.HOW_MANY_TIMES_RACE)
    }

    fun getNumber(): Int {
        val input = readlnOrNull() ?: throw IllegalArgumentException(Message.ExceptionMessage.IS_NULL_OR_BLANK)
        return input.toIntOrNull() ?: throw IllegalArgumentException(Message.ExceptionMessage.IS_NOT_INTEGER)
    }
}
