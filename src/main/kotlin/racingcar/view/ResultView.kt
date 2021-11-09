package racingcar.view

import racingcar.domain.Car

object ResultView {

    fun carPositionPrints(car: List<Car>) {
        car.forEach {
            carPositionPrint(it)
        }
    }

    fun winnerPrints(winners: String) {
        print("${winners}가 최종 우승했습니다.")
    }

    private fun carPositionPrint(car: Car) {
        println("-".repeat(car.carPosition()))
    }
}
