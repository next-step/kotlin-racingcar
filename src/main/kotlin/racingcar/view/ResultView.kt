package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Winner

object ResultView {
    private const val SPACE = "-"

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printResult(recordCars: List<Cars>) {
        recordCars.forEach {
            printCarDistance(it.getCars())
        }
    }

    private fun printCarDistance(cars: List<Car>) {
        cars.forEach {
            println("${it.getName()}: ${SPACE.repeat(it.getDistance())}")
        }
        println()
    }

    fun printWinners(winners: Winner) {
        if (winners.getWinners().isEmpty()) {
            println("우승자가 없습니다.")
            return
        }

        val names = winners.getWinners().joinToString() { it.getName() }
        print("$names 가 최종 우승했습니다.")
    }
}
