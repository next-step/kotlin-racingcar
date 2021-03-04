package racinggame

import racinggame.car.domain.V8Engine
import racinggame.car.domain.toRacingCars
import racinggame.car.domain.CarFactory
import racinggame.record.domain.Recorder
import racinggame.ui.inputCarAmount
import racinggame.ui.inputTrialAmount
import racinggame.ui.showResult

class RacingGame {
    fun start() {
        val carRequest = CarFactory(inputCarAmount())
        val trialAmount = inputTrialAmount()

        val racingCars = carRequest.toRacingCar(V8Engine())
            .toRacingCars()
        val recorder = Recorder.create()
        racingCars.move(trialAmount, recorder)

        showResult(recorder)
    }
}
