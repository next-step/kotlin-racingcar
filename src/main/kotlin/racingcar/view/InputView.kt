package racingcar.view

import racingcar.value.RacingCarGameInput

class InputView {
    companion object {
        fun getInput(): RacingCarGameInput {
            val numberOfCar = getNumberOfCarInput()
            val totalCountOfRound = getTotalCountOfRoundInput()

            return RacingCarGameInput(numberOfCar, totalCountOfRound)
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
