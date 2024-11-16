package racingcar.service

import racingcar.model.Forward
import racingcar.model.RacingCar
import racingcar.model.TryCount
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarService {
    var tryCount: TryCount = TryCount()
    var forward: Forward = Forward()

    fun startNumberCars(): Int {
        InputView.readNumberCars()
        return readln().toInt()
    }

    fun startTryCount(): Int {
        InputView.readTryCount()
        val userInput: Int = readln().toInt()
        return tryCount.getTryCount(userInput)
    }

    fun startRace(
        numberCars: Int,
        tryCount: Int,
    ): List<RacingCar> {
        ResultView.showRacingStart()

        val raceCars = (1..numberCars).map { RacingCar(it) }

        for (i in 0 until tryCount) {
            raceCars.forEach { car ->
                car.race { forward.pickRandomNumberInRange() >= 4 }
            }
            ResultView.showRacingResult(raceCars)
        }

        return raceCars
    }
}
