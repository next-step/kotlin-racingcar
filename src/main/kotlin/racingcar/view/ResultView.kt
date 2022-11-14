package racingcar.view

import racingcar.Car
import racingcar.Cars

object ResultView {
    private const val SPACE = "-"
    private const val SEPARATOR = ", "

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printCarDistance(cars: Cars) {
        cars.getCars().forEach {
            println("${it.getName()}: ${SPACE.repeat(it.getDistance())}")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        if (cars.isEmpty()) {
            println("우승자가 없습니다.")
        }

        val names = cars.joinToString(SEPARATOR) { it.getName() }
        print("$names 가 최종 우승했습니다.")
    }
}
