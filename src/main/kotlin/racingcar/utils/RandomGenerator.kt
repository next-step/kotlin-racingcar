package racingcar.utils

import racingcar.domain.RandomMoveStrategy

class RandomGenerator {
    companion object {
        fun generateRandomNum(begin: Int, end: Int) :Int {
            return (begin..end).random()
        }
    }
}