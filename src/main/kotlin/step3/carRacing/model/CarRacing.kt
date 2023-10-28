package step3.carRacing.model

import step3.carRacing.contoller.RaceController
import step3.carRacing.view.InputView
import step3.carRacing.view.SystemInputReader


class CarRacing {
    private val raceController = RaceController()
    fun start() {
        val (carCount, tryCount) = InputView.getInputInfo(SystemInputReader());
        raceController.startRace(tryCount, cars = CarGenerator.generate(carCount))
    }
}
