package step4.racingcar.controller

import step4.racingcar.domain.CarRacing
import step4.racingcar.domain.RandomNumber
import step4.racingcar.view.InputView
import step4.racingcar.view.ResultView

class CarRacingController {
    companion object {
        fun play() {
            val racers = InputView.racers()
            val movementCount = InputView.movementCount()

            val carRacing = CarRacing.of(racers, movementCount)
            carRacing.execute(RandomNumber)
            ResultView.view(carRacing.gameResult)
        }
    }
}
