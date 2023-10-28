package step3.carRacing.model

import step3.carRacing.contoller.RaceController
import step3.carRacing.view.InputView


class CarRacing {
    private val raceController = RaceController()
    fun start() {
        val (carCount, tryCount) = InputView.getInputInfo()
        raceController.startRace(tryCount, cars = CarGenerator.generate(carCount))
    }
}
