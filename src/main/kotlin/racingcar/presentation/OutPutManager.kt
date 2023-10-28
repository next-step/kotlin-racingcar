package racingcar.presentation

import racingcar.domain.Car
import racingcar.domain.DriveConditionImpl

class OutPutManager {

    fun printCarList(carList: List<Car>) {
        carList.forEach {
            println("-".repeat(it.distance))
        }
    }

    fun printBeginResultMessage() {
        println(PRINT_BEGIN_RESULT_MESSAGE)
    }

    companion object {
        const val PRINT_BEGIN_RESULT_MESSAGE = "실행 결과"
    }
}
