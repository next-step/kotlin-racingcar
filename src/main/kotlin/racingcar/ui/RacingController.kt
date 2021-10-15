package racingcar.ui

import racingcar.domain.Cars
import racingcar.domain.Record
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(private val inputView: InputView, private val record: Record) {
    fun start() {
        moveCars(creatCars())
        showResult()
    }

    private fun showResult() {
        OutputView(record).showResult()
    }

    private fun creatCars(): Cars {
        val carCount = inputView.askNumberOfCars()
        return Cars().createCars(carCount)
    }

    private fun moveCars(cars: Cars) {
        val triesCount = inputView.askTryCount()
        var recordCars = cars
        for (count in FIRST_GAME..triesCount) {
            recordCars = recordCars.move()
            record.add(count, recordCars)
        }
    }

    companion object {
        private const val FIRST_GAME = 1
    }
}
