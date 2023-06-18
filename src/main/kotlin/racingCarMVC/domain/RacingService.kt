package racingCarMVC.domain

import racingCarMVC.domain.dto.GameResult
import racingCarMVC.domain.dto.InputData

class RacingService {
    fun racingStart(inputData: InputData): List<GameResult> {
        val racingField = RacingField(inputData.carNames.toTypedArray(), inputData.gameCount)
        return racingField.startRacing(RandomNumberGenerator())
    }
}
