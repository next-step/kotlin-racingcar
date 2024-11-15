package racingcar.controller

import racingcar.model.Forward
import racingcar.model.TryCount
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController {
    private var tryCount: TryCount = TryCount()
    private var forward: Forward = Forward()

    fun start() {
        val numberCars = startNumberCars()
        val tryCount = startTryCount()
        startRace(numberCars, tryCount)
    }

    private fun startNumberCars(): Int {
        InputView.readNumberCars()
        return readln().toInt()
    }

    private fun startTryCount(): Int {
        InputView.readTryCount()
        val userInput: Int = readln().toInt()
        return tryCount.getTryCount(userInput)
    }

    private fun calculateForward(
        numberCar: Int,
        raceMap: MutableMap<Int, Int>,
    ) {
        val randomNumber: Int = forward.pickRandomNumberInRange()
        if (forward.isForward(randomNumber)) {
            raceMap[numberCar] = raceMap[numberCar]!! + 1
        }
    }

    private fun startRace(
        numberCars: Int,
        tryCount: Int,
    ): MutableMap<Int, Int> {
        ResultView.showRacingStart()

        val raceMap = (1..numberCars).associateWith { 0 }.toMutableMap()

        for (i in 0 until tryCount) {
            raceMap.keys.forEach { numberCar ->
                calculateForward(numberCar, raceMap)
            }
            ResultView.showRacingResult(raceMap)
        }

        return raceMap
    }
}
