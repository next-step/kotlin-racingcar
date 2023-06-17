package racingcar.domain

import racingcar.domain.move.RandomMoveStrategy
import racingcar.dto.RaceRequest
import racingcar.view.InputViewProtocol
import racingcar.view.OutputViewProtocol

/**
 * 자동차 게임 지휘자 객체
 */
class RacingGame(
    private val inputView: InputViewProtocol,
    private val outputView: OutputViewProtocol
) {

    fun start() {
        val (carNumber, roundNumber) = getInput()
        val cars = initCars(carNumber = carNumber)
        startEachRound(cars = cars, roundNumber = roundNumber)
    }

    private fun getInput(): RaceRequest {
        val carNumber = inputView.getCarNumber()
        val roundNumber = inputView.getRoundNumber()
        return RaceRequest(carNumber = carNumber, roundNumber = roundNumber)
    }

    private fun initCars(carNumber: Int): List<Car> {
        val cars: MutableList<Car> = mutableListOf()
        for (i in 0 until carNumber) {
            cars.add(Car(RandomMoveStrategy()))
        }
        return cars.toList()
    }

    private fun startEachRound(cars: List<Car>, roundNumber: Int) {
        val round = Round()
        for (i in 0 until roundNumber) {
            round.execute(cars)
            printResult(cars)
        }
    }

    private fun printResult(cars: List<Car>) {
        for (car in cars) {
            outputView.printValue(car.location)
        }
        println()
    }
}
