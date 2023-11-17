package racingcar.service

import racingcar.domain.Cars
import racingcar.view.OutputView
import racingcar.view.inputTryCount

class RacingService {
    fun play(racingCars: Cars): Cars {
        repeat(inputTryCount()) {
            racingCars.move()
            OutputView.printRacing(racingCars)
        }
        return racingCars
    }
}
