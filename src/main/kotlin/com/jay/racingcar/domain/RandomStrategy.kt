package com.jay.racingcar.domain

class RandomStrategy : MovingStrategy {
    override fun canMove(): Boolean {
        val random = (0..9).random()
        return random > MOVING_THRESHOLD
    }

    companion object {
        private const val MOVING_THRESHOLD = 4
    }
}
