package raicing

import raicing.model.RaceCar
import raicing.processor.RaceProcessor
import raicing.view.InputView
import raicing.view.OutputView

fun main() {
    val carInfos = InputView.readStrAndConvertToList(Const.OutputMsg.CAR_NAME_MSG)
    val initCars = RaceCar.of(carInfos)

    val raceCount = InputView.readStrAndConvertToNaturalNum(Const.OutputMsg.RACE_COUNT_MGS)

    val raceProcessor = RaceProcessor()
    val raceResults = raceProcessor.race(initCars, raceCount.toInt())

    OutputView.resultOutput(raceResults)
}
