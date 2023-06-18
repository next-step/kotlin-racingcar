package racingCarMVC.domain

import racingCarMVC.domain.dto.InputData
import racingCarMVC.domain.dto.RacingResult

class RacingService {
    fun racingStart(inputData: InputData): RacingResult {
        val racingField = RacingField(inputData.carNames.toTypedArray(), inputData.gameCount)
        return racingField.startRacing(RandomNumberGenerator())
    }
}
