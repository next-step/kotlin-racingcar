package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.WinnerCar
import racingcar.inputCarName
import racingcar.inputTryCount
import racingcar.view.printRacing
import racingcar.view.printWinner

class RacingController {
    fun join(): Cars = Cars.of(inputCarName().split(","))

    fun play(racingCars: Cars): Cars {
        repeat(inputTryCount()) {
            racingCars.move()
            printRacing(racingCars)
        }
        return racingCars
    }

    fun winner(playRacingCar: Cars) {
        printWinner(WinnerCar.from(playRacingCar))
    }
}
