package racing.controller

import racing.car.Car
import racing.car.CarRace
import racing.car.Cars
import racing.moveprovider.RandomMoveProvider
import racing.ui.InputView
import racing.ui.ResultView

class RacingCircuit {
    private val carRace: CarRace = CarRace()
    private val inputView = InputView()
    private val resultView = ResultView()
    fun race() {
        val (carNumber, tryNumber) = inputView.getInputView()
        val cars = Cars(carNumber)

        println("레이스 스타트")
        val roundCars: MutableList<Cars> = carRace.start(cars, tryNumber, RandomMoveProvider())
        resultView.resultViewWithoutName(roundCars)
    }

    fun raceWithWinner() {
        val (carNames, tryNumber) = inputView.getInputViewWithName()

        val carList = carNames.split(",")
            .map { Car(name = it) }

        val cars = Cars(carList)

        println("실행 결과")
        val roundCars: MutableList<Cars> = carRace.start(cars, tryNumber, RandomMoveProvider())
        resultView.resultViewWithWinner(roundCars)
    }
}

fun main() {
    val racingCircuit = RacingCircuit()
    racingCircuit.raceWithWinner()
}
