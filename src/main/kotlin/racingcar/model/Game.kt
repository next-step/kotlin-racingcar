package racingcar.model

import racingcar.ui.InputView
import racingcar.ui.OutputView
import kotlin.random.Random

class Game {
    private val listOfCar: ArrayList<Car> = arrayListOf()
    private val outputView: OutputView = OutputView()

     fun createCar(numberOfCar: Int) {
        for (times in 1..numberOfCar) {
            listOfCar.add(Car())
        }
    }

    fun getListOfCar(): ArrayList<Car> {
        return listOfCar
    }

     fun executeOneCycle() {
        repeat(listOfCar.size) {
            val randomNumber = generateRandomNumber()
            val currentCar = listOfCar[it]
            checkCarPossibleToMove(randomNumber, currentCar)
        }
    }

    fun printOneCycle() {
        var oneCycleProgress = ""
        repeat(listOfCar.size) {
            val currentCarProgress = listOfCar[it].getProgress()
            oneCycleProgress += outputView.getStringProgress(currentCarProgress)
            oneCycleProgress += "\n"
        }

        println(oneCycleProgress)
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
