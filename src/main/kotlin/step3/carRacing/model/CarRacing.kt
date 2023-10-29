package step3.carRacing.model

import step3.carRacing.view.InputView
import step3.carRacing.view.OutputView
import step3.carRacing.view.SystemInputReader
import step3.carRacing.view.SystemPrint


class CarRacing {

    fun start() {
        val (carCount, tryCount) = InputView.getInputInfo(SystemInputReader())
        val raceOrganizer = RaceOrganizer(cars = CarGenerator.generate(carCount))
        raceOrganizer.startRace(tryCount)
        val raceResults = raceOrganizer.getRaceResult();
        OutputView.renderRace(raceResults, SystemPrint)
    }
}
