package racing.ui

import racing.domain.Car
import racing.dto.CarDto

object ResultView {
    // fun showCarRoute(cars: List<CarDto>, num : Int) {
    //     for (car in cars) {
    //         println("${car.name} : ${printRoute(car.route)}")
    //     }
    //     println()
    // }

    fun showCarRoute(cars: List<CarDto>, num: Int) {
        for ((index, car) in cars.withIndex()) {
            println("${car.name} : ${printRoute(car.route)}")

            // num 번째마다 추가적인 줄바꿈을 수행
            if ((index + 1) % num == 0) {
                println()
            }
        }
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
            transform = { car -> car.name.name }
        ) + "가 최종 우승했습니다."
    }
}
