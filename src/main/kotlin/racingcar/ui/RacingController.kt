package racingcar.ui

import racingcar.domain.Cars
import racingcar.domain.Names
import racingcar.domain.Record
import racingcar.domain.Winners
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(private val inputView: InputView, private var record: Record) {
    fun start() {
        moveCars(creatCars())
        showResult()
    }

    private fun showResult() {
        val lastResult = record[record.getSize()]
        val winners = lastResult?.let { Winners.findWinners(it) }
        OutputView(record, winners).showResult()
    }

    private fun creatCars(): Cars {
        val carNames = Names.generateNames(inputView.askNamesOfCars())
        return Cars.createCars(carNames)
    }

    private fun moveCars(cars: Cars) {
        val triesCount = inputView.askTryCount()
        var recordCars = cars.copy()
        for (count in FIRST_GAME..triesCount) {
            recordCars = recordCars.move()
            record = record.add(Pair(count, recordCars))
        }
    }

    companion object {
        private const val FIRST_GAME = 1
    }
}
