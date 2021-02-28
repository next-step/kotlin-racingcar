package racingcar.model

import racingcar.ui.InputView
import racingcar.ui.OutputView
import kotlin.random.Random

class Game {

    private val inputView = InputView()
    private val outputView = OutputView()
    private var numberOfCar: Int = 0
    private var numberOfTimes: Int = 0
    private val listOfCar: ArrayList<Car> = arrayListOf()

    fun gameStart() {
        numberOfCar = inputView.inputNumberOfCar()
        numberOfTimes = inputView.inputNumberOfTimes()
        createCar(numberOfCar)

        println("[실행 결과]")
        repeat(numberOfTimes) {
            executeOneCycle()
            printOneCycle()
            println()
        }
    }

    private fun createCar(numberOfCar: Int) {
        for (times in 1..numberOfCar) {
            listOfCar.add(Car())
        }
    }

    private fun executeOneCycle() {
        repeat(listOfCar.size) {
            val randomNumber = generateRandomNumber()
            val currentCar = listOfCar[it]
            checkCarPossibleToMove(randomNumber, currentCar)
        }
    }

    private fun printOneCycle() {
        repeat(listOfCar.size) {
            val currentCarProgress = listOfCar[it].getProgress()
            println(outputView.getStringProgress(currentCarProgress))
        }
    }

    private fun checkCarPossibleToMove(randomNumber: Int, car: Car) {
        if (randomNumber >= 4) {
            car.moveForward()
        }
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(1, 10)
    }
}
