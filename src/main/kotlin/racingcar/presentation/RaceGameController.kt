package racingcar.presentation

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.service.CarNameParseService
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceGameController {
    fun main(args: Array<String>) {
        val nameOfCarInput = InputView.getNameOfCarInput()
        val totalCountOfRoundInput = InputView.getTotalCountOfRoundInput()

        validateGameStartCondition(nameOfCarInput, totalCountOfRoundInput)

        val parsedCarNames = CarNameParseService.parse(nameOfCarInput)
        val cars = parsedCarNames.map { carName -> Car(carName) }

        val race = Race(cars, totalCountOfRoundInput)
        val raceResult = race.run()

        ResultView.printResult(raceResult)
    }

    private fun validateGameStartCondition(numberOfCarInput: String, totalCountOfRoundInput: Int) {
        if (numberOfCarInput == "" || totalCountOfRoundInput < 1) throw IllegalArgumentException("올바르지 않은 게임 세팅값입니다.")
    }
}
