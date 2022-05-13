package raicing

import raicing.processor.RaceProcessor
import raicing.view.InputView
import raicing.view.OutputView

fun main() {
    val carCount = InputView.readStrAndConvertToInt(Const.OutputMsg.CAR_COUNT_MSG)
    val raceCount = InputView.readStrAndConvertToInt(Const.OutputMsg.RACE_COUNT_MGS)

    val raceProcessor = RaceProcessor()
    val initCars = raceProcessor.initCars(carCount)
    val raceResults = raceProcessor.race(initCars, raceCount)

    OutputView.resultOutput(raceResults)
}
