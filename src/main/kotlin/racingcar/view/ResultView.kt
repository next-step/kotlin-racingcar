package racingcar.view

import racingcar.domain.Car

object ResultView {

    fun carPositionPrints(cars: List<Car>) {
        cars.forEach {
            print("${it.carName.name} : ")
            carPositionPrint(it)
        }
    }

    fun winnerPrints(winners: List<Car>) {
        val winnerNames = winners.joinToString {
            it.carName.name
        }
        print("${winnerNames}가 최종 우승했습니다.")
    }

    private fun carPositionPrint(car: Car) {
        println("-".repeat(car.carPosition()))
    }
}
