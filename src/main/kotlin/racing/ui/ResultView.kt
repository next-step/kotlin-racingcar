package racing.ui

import racing.domain.Car
import racing.domain.CarHistory
import racing.domain.Cars

object ResultView {
    fun getRacingResult(carHistorys: List<CarHistory>, cars: List<Car>) {
        showCarRoute(carHistorys, cars.size)
        printFinalResult(Cars(cars).winner)
    }

    private fun showCarRoute(cars: List<CarHistory>, num: Int) {
        for ((index, car) in cars.withIndex()) {
            println("${car.name} : ${printRoute(car.route)}")

            if ((index + 1) % num == 0) {
                println()
            }
        }
    }

    private fun printRoute(moveCount: Int): String {
        return "-".repeat(moveCount)
    }

    private fun printFinalResult(winnerList: List<Car>) {
        println(printRacingGame(winnerList))
    }

    private fun printRacingGame(winnerList: List<Car>): String {
        return winnerList.joinToString(
            separator = ", ",
            transform = { car -> car.name.name }
        ) + "가 최종 우승했습니다."
    }
}
