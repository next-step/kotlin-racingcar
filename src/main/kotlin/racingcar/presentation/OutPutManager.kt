package racingcar.presentation

import racingcar.domain.Car

class OutPutManager {

    fun printCarList(cars: List<Car>) {
        cars.forEach {
            println(it.name.value + ":" + "-".repeat(it.distance))
        }
        println()
    }

    fun printBeginResultMessage() {
        println(PRINT_BEGIN_RESULT_MESSAGE)
    }

    companion object {
        const val PRINT_BEGIN_RESULT_MESSAGE = "실행 결과"
    }
}
