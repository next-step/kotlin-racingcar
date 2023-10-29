package step3.carRacing.model

import step3.carRacing.RaceRule
import step3.carRacing.view.InputView
import step3.carRacing.view.OutputView
import step3.carRacing.view.SystemInputReader
import step3.carRacing.view.SystemPrint
import kotlin.random.Random


class CarRacing {

    fun start() {
        val (carCount, tryCount) = InputView.getInputInfo(SystemInputReader())
        val raceOrganizer = RaceOrganizer(cars = CarGenerator.generate(carCount))
        raceOrganizer.startRace(tryCount) { RaceRule.over4CanGo }
        OutputView.renderRace(raceOrganizer.getRaceResult(), SystemPrint)
    }
}
