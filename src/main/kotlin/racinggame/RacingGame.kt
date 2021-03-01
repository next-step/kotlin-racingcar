package racinggame

import racinggame.car.V8Engine
import racinggame.car.toRacingCars
import racinggame.spec.CarFactory
import racinggame.ui.inputCarAmount
import racinggame.ui.inputTrialAmount
import racinggame.ui.showResult

class RacingGame {
    fun start() {
        val carRequest = CarFactory(inputCarAmount())
        val trialAmount = inputTrialAmount()

        val racingCars = carRequest.toRacingCar(V8Engine())
            .toRacingCars()
        racingCars.move(trialAmount)

        showResult(racingCars.recorder)
    }
}
