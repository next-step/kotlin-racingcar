package carRacing.model

import carRacing.RaceRule
import carRacing.view.InputView
import carRacing.view.OutputView
import carRacing.view.SystemInputReader
import carRacing.view.SystemPrint


class CarRacing {
    fun start() {
        val (cars, tryCount) = InputView.getInputInfo(inputReader = SystemInputReader())
        val raceOrganizer = RaceOrganizer(cars)
        raceOrganizer.startRace(tryCount, RaceRule.over4CanGo)
        OutputView.renderRace(raceOrganizer.getRaceResult(), SystemPrint)
    }
}
