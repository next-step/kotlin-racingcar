package com.jay.racingcar.domain

class RandomStrategy : MovingStrategy {
    override fun canMove(): Boolean {
        val movingJudgementNumber = (RANDOM_START_RANGE..RANDOM_END_RANGE).random()
        return movingJudgementNumber > MOVING_THRESHOLD
    }

    companion object {
        private const val MOVING_THRESHOLD = 4
        private const val RANDOM_START_RANGE = 0
        private const val RANDOM_END_RANGE = 9
    }
}
