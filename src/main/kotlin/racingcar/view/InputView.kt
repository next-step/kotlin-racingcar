package racingcar.view

import racingcar.input.RaceSettingInput

class InputView {
    companion object {
        fun getInput(): RaceSettingInput {
            val numberOfCar = getNumberOfCarInput()
            val totalCountOfRound = getTotalCountOfRoundInput()

            return RaceSettingInput(numberOfCar, totalCountOfRound)
        }

        private fun getNumberOfCarInput(): Int {
            println("자동차 대수는 몇 대인가요?")

            return readLine()?.toIntOrNull() ?: 0
        }

        private fun getTotalCountOfRoundInput(): Int {
            println("시도할 횟수는 몇 회인가요?")

            return readLine()?.toIntOrNull() ?: 0
        }
    }
}
