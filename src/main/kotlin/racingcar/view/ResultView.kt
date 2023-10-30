package racingcar.view

import racingcar.model.Car

object ResultView {
    private const val COLON_SEPARATOR = " : "
    private const val MOVE_GRAPHIC = "-"
    private const val COMMA_SEPARATOR = ", "
    private const val RESULT_MESSAGE = "\n실행 결과"
    private const val WINNER_MESSAGE = "가 최종 우승했습니다."

    fun printHeader() {
        println(RESULT_MESSAGE)
    }

    fun showProgress(cars: List<Car>) {
        for (car in cars) {
            println(car.name + COLON_SEPARATOR + MOVE_GRAPHIC.repeat(car.position))
        }
        println()
    }

    fun showWinner(cars: List<Car>) {
        println(cars.joinToString(COMMA_SEPARATOR) { it.name } + WINNER_MESSAGE)
    }
}
