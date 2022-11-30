package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceGameController {
    fun main(args: Array<String>) {
        val numberOfCarInput = InputView.getNumberOfCarInput()
        val totalCountOfRoundInput = InputView.getTotalCountOfRoundInput()

        if (numberOfCarInput < 1 || totalCountOfRoundInput < 1) throw IllegalArgumentException("올바르지 않은 게임 세팅값입니다.")

        val cars = List(numberOfCarInput) { Car() }
        val race = Race(cars, totalCountOfRoundInput)
        val raceResult = race.run()

        ResultView.printResult(raceResult)
    }
}
