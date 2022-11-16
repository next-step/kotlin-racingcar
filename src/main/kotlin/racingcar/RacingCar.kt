package racingcar

import racingcar.data.Car
import racingcar.ui.InputView
import racingcar.ui.ResultView
import java.security.SecureRandom

object RacingCar {
    fun startRace() {
        val inputView = InputView()
        val carCount = inputView.inputCarCount()
        val tryCount = inputView.inputTryCount()

        val resultView = ResultView()
        resultView.printInitResult()

        val carList = createCars(carCount)

        for (i in 0 until tryCount) {
            moveCars(carList)

            for (car in carList) {
                resultView.printCarMoveCount(car.moveCount)
            }

            if (i < tryCount - 1) {
                resultView.printLineSpacing()
            }
        }
    }

    private fun createCars(count: Int): List<Car> =
        ArrayList<Car>().apply {
            for (i in 0 until count) {
                add(Car())
            }
        }

    private fun moveCars(carList: List<Car>) {
        for (car in carList) {
            if (checkMoveValue(createRandomInt())) {
                car.moveCount ++
            }
        }
    }

    fun createRandomInt(): Int = SecureRandom.getInstanceStrong().nextInt(10)

    fun checkMoveValue(value: Int): Boolean = value >= 4

    fun getMoveString(moveCount: Int): String = ResultView().getMoveString(moveCount)
}
