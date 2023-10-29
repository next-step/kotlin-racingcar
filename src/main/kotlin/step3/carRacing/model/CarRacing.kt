package step3.carRacing.model

import step3.carRacing.view.InputView
import step3.carRacing.view.OutputView
import step3.carRacing.view.SystemInputReader
import step3.carRacing.view.SystemPrint
import kotlin.random.Random


class CarRacing {

    fun start() {
        val (carCount, tryCount) = InputView.getInputInfo(SystemInputReader())
        val raceOrganizer = RaceOrganizer(cars = CarGenerator.generate(carCount))
        raceOrganizer.startRace(tryCount) { Random.nextInt(0, 10) in 4 until 10 }
        OutputView.renderRace(raceOrganizer.getRaceResult(), SystemPrint)
    }
}
