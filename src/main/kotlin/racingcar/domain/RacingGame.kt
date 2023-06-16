package racingcar.domain

import racingcar.view.InputViewProtocol
import racingcar.view.OutputViewProtocol

/**
 * 자동차 게임 지휘자 객체
 */
class RacingGame(
    private val inputView: InputViewProtocol,
    private val outputView: OutputViewProtocol
) {

    private val round: Round = Round()
    private val cars: MutableList<Car> = mutableListOf()

    fun start() {
        val (carNumber, roundNumber) = getInput()
        initCars(cars = cars, carNumber = carNumber)
        startEachRound(cars = cars, roundNumber = roundNumber)
    }

    private fun getInput(): Pair<Int, Int> {
        val carNumber = inputView.getCarNumber()
        val roundNumber = inputView.getRoundNumber()
        return Pair(carNumber, roundNumber)
    }

    private fun initCars(cars: MutableList<Car>, carNumber: Int) {
        for (i in 0 until carNumber)
            cars.add(Car(RandomMoveStrategy()))
    }

    private fun startEachRound(cars: MutableList<Car>, roundNumber: Int) {
        for (i in 0 until roundNumber) {
            round.execute(cars)
            printResult(cars)
        }
    }

    private fun printResult(cars: MutableList<Car>) {
        for (car in cars) {
            outputView.printValue(car.location)
        }
        println()
    }
}
