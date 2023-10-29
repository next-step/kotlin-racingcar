package step3.carRacing.model

import step3.carRacing.view.InputView
import step3.carRacing.view.SystemInputReader


class CarRacing {

    fun start() {
        val (carCount, tryCount) = InputView.getInputInfo(SystemInputReader())
        RaceOrganizer(cars = CarGenerator.generate(carCount)).startRace(tryCount)
    }
}
