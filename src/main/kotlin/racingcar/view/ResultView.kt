package racingcar.view

import racingcar.domain.Car
import racingcar.domain.WinnerNames

object ResultView {

    fun carPositionPrints(cars: List<Car>) {
        cars.forEach {
            print("${it.carName.name} : ")
            carPositionPrint(it)
        }
    }

    fun winnerPrints(winnerNames: List<String>) {
        val result = racingWinnerName(winnerNames)
        print("${result}가 최종 우승했습니다.")
    }

    private fun racingWinnerName(winnerNames: List<String>): String {
        return WinnerNames.combineWinnerNames(winnerNames)
    }

    private fun carPositionPrint(car: Car) {
        println("-".repeat(car.carPosition()))
    }
}
