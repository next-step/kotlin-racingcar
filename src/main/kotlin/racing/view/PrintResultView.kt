package racing.view

import racing.model.Car

object PrintResultView {
    private const val COMMA_SEPERATOR = ","
    private const val WINNING_CAR_NAME_SENTENCE = "가 최종 우승했습니다."

    fun printResult(winningCars: List<Car>) {
        print("${ winningCars.joinToString(separator = COMMA_SEPERATOR) { it.name }} ${WINNING_CAR_NAME_SENTENCE}")
    }
}
