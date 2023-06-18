package racingCarMVC.domain

import racingCarMVC.domain.dto.GameResult
import racingCarMVC.domain.dto.InputData

class RacingService {
    private val inputIO = InputIO()

    fun inputCarNames(): List<String> {
        return inputIO.inputCarNames()
    }

    fun inputGameCount(): Int {
        return inputIO.inputGameCount()
    }

    fun racingStart(inputData: InputData): List<GameResult> {
        val racingField = RacingField(inputData.carNames.toTypedArray(), inputData.gameCount)
        return racingField.racingStart(RandomNumberGenerator())
    }
}