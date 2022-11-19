package racingcar

import racingcar.domain.RaceSetting
import racingcar.view.InputView

class RacingCarGame {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val raceSettingInput = InputView.getInput()

            val numberOfCarInput = raceSettingInput.numberOfCar
            val totalCountOfRoundInput = raceSettingInput.totalCountOfRound

            if (numberOfCarInput < 1 || totalCountOfRoundInput < 1) throw IllegalArgumentException("올바르지 않은 게임 세팅값입니다.")

            val raceSetting = RaceSetting(numberOfCarInput, totalCountOfRoundInput)
        }
    }
}
