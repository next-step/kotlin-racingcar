package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Record
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController(private val inputView: InputView, private val record: Record) {

    companion object {
        private const val INIT_GAME = 1
    }

    fun startGame() {
        moveCars(generateCars())
        showResult()
    }

    private fun showResult() {
        ResultView(record).showResult()
    }

    private fun generateCars(): Cars {
        val carCount = inputView.inputCar()
        return Cars(carCount)
    }

    private fun moveCars(cars: Cars) {
        val triesCount = inputView.inputCount()
        var recordCars = cars
        for (count in INIT_GAME..triesCount) {
            recordCars = recordCars.dashOver()
            record.add(count, recordCars)
        }
    }
}
