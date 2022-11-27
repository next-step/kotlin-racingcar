package racingcar.presentation

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.domain.RaceResult
import racingcar.exception.IncorrectGameSettingException
import racingcar.service.CarNameParseService
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceGameController {
    fun main(args: Array<String>) {
        val nameOfCarInput = InputView.getNameOfCarInput()
        val totalCountOfRoundInput = InputView.getTotalCountOfRoundInput()

        validateGameStartCondition(nameOfCarInput, totalCountOfRoundInput)
        val cars = initiateCars(nameOfCarInput)
        val raceResult = runRace(cars, totalCountOfRoundInput)

        ResultView.printResult(raceResult)
    }

    private fun validateGameStartCondition(numberOfCarInput: String, totalCountOfRoundInput: Int) {
        if (numberOfCarInput == "" || totalCountOfRoundInput < 1) throw IncorrectGameSettingException()
    }

    private fun initiateCars(nameOfCarInput: String): List<Car> {
        val parsedCarNames = CarNameParseService.parse(nameOfCarInput)

        return parsedCarNames.map { carName -> Car(carName) }
    }

    private fun runRace(cars: List<Car>, totalCountOfRoundInput: Int): RaceResult {
        return Race(cars, totalCountOfRoundInput).run()
    }
}
