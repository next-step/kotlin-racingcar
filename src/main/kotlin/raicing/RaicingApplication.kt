package raicing

import raicing.model.RaceCar
import raicing.processor.RaceProcessor
import raicing.view.InputView
import raicing.view.OutputView

fun main() {
    val carCount = InputView.readStrAndConvertToNaturalNum(Const.OutputMsg.CAR_COUNT_MSG)
    val raceCount = InputView.readStrAndConvertToNaturalNum(Const.OutputMsg.RACE_COUNT_MGS)
    val initCars = RaceCar.of(carCount)

    val raceProcessor = RaceProcessor()
    val raceResults = raceProcessor.race(initCars, raceCount.toInt())

    OutputView.resultOutput(raceResults)
}
