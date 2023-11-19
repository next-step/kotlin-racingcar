package racing.ui

import racing.Car
import racing.Cars

object ResultView {
    fun showCarRoute(cars: Cars) {
        for (car in cars.carList) {
            println("${car.name} : ${printRoute(car.route)}")
        }
        println()
    }

    private fun printRoute(moveCount: Int): String {
        return "-".repeat(moveCount)
    }

    fun printFinalResult(winnerList: List<Car>) {
        println(printRacingGame(winnerList))
    }

    private fun printRacingGame(winnerList: List<Car>): String {
        return winnerList.joinToString(
            separator = ", ",
            transform = { car -> car.name }
        ) + "가 최종 우승했습니다."
    }
}
