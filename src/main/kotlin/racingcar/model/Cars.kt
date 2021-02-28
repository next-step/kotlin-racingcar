package racingcar.model

import racingcar.ui.OutputView

class Cars(
    private val cars: ArrayList<Car> = arrayListOf()
) {
    private val outputView = OutputView()
    private val randomNumber = RandomNumber()

    fun addCar(numberOfCar: Int) {
        repeat(numberOfCar) {
            cars.add(Car())
        }
    }

    fun playGameOneRound() {
        repeat(cars.size) {
            val randomNumber = randomNumber.generateRandomNumber()
            if (cars[it].checkPossibleToMove(randomNumber)) {
                cars[it].moveForward()
            }
        }
    }

    fun printOneRoundGameResult() {
        repeat(cars.size) {
            val currentCarProgress = cars[it].getProgress()
            println(outputView.getStringProgress(currentCarProgress))
        }
        println()
    }
}
