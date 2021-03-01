package racing.ui

import racing.domain.Car

/**
 * @author tae-heon.song<taeheon.song@linecorp.com>
 * @since 2021. 02. 28.
 */
object ResultView {

    private const val SYMBOL_ONE_STEP = "-"
    private const val NOTICE_RESULT_START = "실행결과"

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
}
