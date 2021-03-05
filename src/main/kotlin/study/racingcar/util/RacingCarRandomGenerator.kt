package study.racingcar.util

import study.racingcar.common.GameConfig

object RacingCarRandomGenerator : RandomGenerator {
    override fun random(): Int = (GameConfig.RACE_MIN_RANDOM_NUMBER..GameConfig.RACE_MAX_RANDOM_NUMBER).random()
}
