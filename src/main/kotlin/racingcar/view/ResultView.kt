package racingcar.view

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.racing.CarsHistory

class ResultView {

    fun printResult(carsHistory: CarsHistory, winners: List<Car>) {
        printTitle()
        printCarsHistory(carsHistory)
        printWinners(winners)
    }

    private fun printCarsHistory(carsHistory: CarsHistory) {
        carsHistory.forEach(::printEachTurn)
    }

    private fun printTitle() {
        println("실행 결과")
    }

    private fun printEachTurn(cars: Cars) {
        cars.forEach(::printCar)
        println()
    }

    private fun printWinners(winners: List<Car>) {
        println("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    private fun printCar(car: Car) {
        println("${car.name} : ${"-".repeat(car.movedDistance)}")
    }
}
