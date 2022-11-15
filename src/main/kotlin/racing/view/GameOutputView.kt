package racing.view

import racing.domain.Car

const val POSITION_MARK = "-"

object GameOutputView {

    fun printStartGame() {
        println()
        println("실행 결과")
    }

    fun printRaceStatus(cars: List<Car>) {
        cars.forEach { printPositions(it) }
        println()
    }

    fun printPositions(car: Car) {
        println("${car.name} : ${POSITION_MARK.repeat(car.position)}")
    }

    fun printRaceWinner(winnerCars: List<Car>) {
        println("${winnerCars.joinToString { it.name }}가 최종 우승했습니다.")
    }
}
