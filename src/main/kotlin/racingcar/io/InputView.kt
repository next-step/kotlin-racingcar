package racingcar.io

import racingcar.domain.RacingGameParam

class InputView {
    fun getGameParam(): RacingGameParam {
        val carCount = getCarCount()
        val rounds = getRoundCount()

        return RacingGameParam(carCount, rounds)
    }

    private fun getCarCount(): Int {
        println(CAR_COUNT_INPUT_MESSAGE)
        return readlnOrNull()!!.toInt()
    }

    private fun getRoundCount(): Int {
        println(ROUND_COUNT_INPUT_MESSAGE)
        return readlnOrNull()!!.toInt()
    }

    companion object {
        private const val CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val ROUND_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
