package me.parker.nextstep.kotlinracingcar.rule

import me.parker.nextstep.kotlinracingcar.utils.RandomNumberGenerator

class RandomRacingGameMoveRule : RacingGameMoveRule {
    companion object {
        private const val MIN_BOUND = 0
        private const val MAX_BOUND = 9
        private const val FORWARD_STANDARD = 4
    }

    override fun isForward(): Boolean {
        return RandomNumberGenerator.generate(MIN_BOUND, MAX_BOUND) >= FORWARD_STANDARD
    }
}