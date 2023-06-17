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
        val (carNameList, roundNumber) = getInput()
        val cars = initCars(carNameList = carNameList)
        startEachRound(cars = cars, roundNumber = roundNumber)
    }

    private fun getInput(): RaceRequest {
        val carNameList = inputView.getCarNames()
        val roundNumber = inputView.getRoundNumber()
        return RaceRequest(carNameList = carNameList, roundNumber = roundNumber)
    }

    private fun initCars(carNameList: List<String>): List<Car> {
        val cars: MutableList<Car> = mutableListOf()

        for (carName in carNameList) {
            cars.add(Car(name = carName, movable = RandomMoveStrategy()))
        }

        return cars.toList()
    }

    private fun startEachRound(cars: List<Car>, roundNumber: Int) {
        val round = Round()
        println()
        for (i in 0 until roundNumber) {
            round.execute(cars)
            printResult(cars)
        }
    }

    private fun printResult(cars: List<Car>) {
        for (car in cars) {
            outputView.printName(car.name)
            outputView.printLocation(car.location)
        }
        println()
    }
}
