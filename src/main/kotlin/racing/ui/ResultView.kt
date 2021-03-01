package racing.ui

import racing.domain.Car

/**
 * @author tae-heon.song<taeheon.song@linecorp.com>
 * @since 2021. 02. 28.
 */
object ResultView {

    private const val SYMBOL_ONE_STEP = "-"
    private const val NOTICE_RESULT_START = "실행결과"
    private const val NAME_DELIMETER_FOR_DISPLAY = ", "
    private const val EXCEPTION_MESSAGE_EMPTY_LIST = "리스트의 값이 존재하지 않습니다."

    fun printResultNotice() {
        println(NOTICE_RESULT_START)
    }

    fun printAllPosition(cars: List<Car>) {
        for (car in cars) {
            printCarStates(car)
        }
        println()
    }

    private fun printCarStates(car: Car) {
        print("${car.name} : ")
        repeat(car.position) {
            print(SYMBOL_ONE_STEP)
        }
        println()
    }

    fun printWinners(cars: List<Car>) {

        if (cars.isEmpty()) {
            throw IllegalArgumentException(EXCEPTION_MESSAGE_EMPTY_LIST)
        }

        val winnerNames = cars.joinToString(NAME_DELIMETER_FOR_DISPLAY) { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
