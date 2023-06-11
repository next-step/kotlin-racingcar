package racingcar.io

import racingcar.domain.Input

class InputView {
    fun getInput(): Input {
        println(CAR_COUNT_INPUT_MESSAGE)
        val carCount = readlnOrNull()!!.toInt()

        println(ROUND_COUNT_INPUT_MESSAGE)
        val rounds = readlnOrNull()!!.toInt()

        return Input(carCount, rounds)
    }

    companion object {
        private const val CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
