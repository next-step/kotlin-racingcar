package step4.carRacingWinner.model

import step4.carRacingWinner.RaceRule
import step4.carRacingWinner.view.InputView
import step4.carRacingWinner.view.OutputView
import step4.carRacingWinner.view.SystemInputReader
import step4.carRacingWinner.view.SystemPrint


class CarRacing {
    fun start() {
        val (cars, tryCount) = InputView.getInputInfo(inputReader = SystemInputReader())
        val raceOrganizer = RaceOrganizer(cars)
        raceOrganizer.startRace(tryCount) { RaceRule.over4CanGo() }
        OutputView.renderRace(raceOrganizer.getRaceResult(), SystemPrint)
    }
}
