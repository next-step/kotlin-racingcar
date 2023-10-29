package racingcar.domain.race

import util.RandomNumberGenerator

object RandomRacePolicy : RacePolicy {
    override val moveAmount = 1
    override val moveCondition = { RandomNumberGenerator.generate(RANDOM_NUMBER_RANGE) >= MIN_RANDOM_NUMBER }

    private const val MIN_RANDOM_NUMBER = 4
    private val RANDOM_NUMBER_RANGE = IntRange(0, 9)
}
