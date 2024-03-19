package racingcar.domain

import racingcar.domain.Engine

class FixedEngine(
    private val power: Int
): Engine {

    override fun getPower(): Int {
        return power
    }
}