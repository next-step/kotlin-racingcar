package racingcar.presentation

import racingcar.domain.Car

class OutPutManager {

    fun printCarList(carList: List<Car>) {
        carList.forEach {
            println("-".repeat(it.distance))
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
