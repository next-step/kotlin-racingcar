package racingcar.view

import racingcar.domain.CarRaceProperties

interface RaceInput {
    fun input(): CarRaceProperties
}

class ConsoleRaceInput : RaceInput {
    override fun input(): CarRaceProperties = CarRaceProperties(
        participantCount = inputRaceCarCount(),
        maxRound = inputRaceCarRound()
    )

    private fun inputRaceCarCount(): Long {
        println(RACE_CAR_COUNT_ASK_MESSAGE)
        return readLine().toLong()
    }

    private fun inputRaceCarRound(): Long {
        println(RACE_CAR_ROUND_ASK_MESSAGE)
        return readLine().toLong()
    }

    companion object {
        private const val RACE_CAR_COUNT_ASK_MESSAGE = "자동차 대수는 몇 대인가요?"
        private const val RACE_CAR_ROUND_ASK_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
}
