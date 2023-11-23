package racingcar.view

import racingcar.domain.Car
import racingcar.domain.CarResultProvider

class ConsoleCarResultView : CarResultProvider {

    override fun printCars(cars: List<Car>) {
        cars.forEach { println("${it.name} : " + "-".repeat(it.moveCount)) }
        println()
    }

    override fun printWinners(cars: List<Car>) {
        println("${cars.joinToString { it.name }}가 최종 우승했습니다.")
    }
}
