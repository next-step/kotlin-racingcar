package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RaceResultEstimator
import racingcar.domain.Round
import racingcar.domain.move.RandomMoveStrategy
import racingcar.dto.RaceRequest
import racingcar.view.InputViewProtocol
import racingcar.view.OutputViewProtocol

class RacingGameController(
    private val inputView: InputViewProtocol,
    private val outputView: OutputViewProtocol
) {

    fun start() {
        val (carNameList, roundNumber) = createRaceRequest()
        val cars = initCars(carNameList = carNameList)
        startEachRound(cars = cars, roundNumber = roundNumber)
        printRaceWinner(cars)
    }

    private fun createRaceRequest(): RaceRequest {
        val carNameList = inputView.getCarNames()
        val roundNumber = inputView.getRoundNumber()
        return RaceRequest(carNameList = carNameList, roundNumber = roundNumber)
    }

    private fun initCars(carNameList: List<String>): List<Car> {
        val cars: MutableList<Car> = mutableListOf()

        carNameList.map { cars.add(Car(name = it, movable = RandomMoveStrategy())) }

        return cars.toList()
    }

    private fun startEachRound(cars: List<Car>, roundNumber: Int) {
        val round = Round()
        outputView.printNextLine()
        for (i in 0 until roundNumber) {
            round.execute(cars)
            printEachRoundResult(cars)
        }
    }

    private fun printEachRoundResult(cars: List<Car>) {
        for (car in cars) {
            outputView.printCar(name = car.name, location = car.location)
        }
        outputView.printNextLine()
    }

    private fun printRaceWinner(cars: List<Car>) {
        val raceResultEstimator = RaceResultEstimator()
        val raceResult = raceResultEstimator.estimate(cars)
        outputView.printRaceWinner(raceResult)
    }
}
