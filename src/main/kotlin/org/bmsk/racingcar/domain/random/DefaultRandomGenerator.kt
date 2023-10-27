package org.bmsk.racingcar.domain.random

internal class DefaultRandomGenerator : RandomGenerator {
    override fun generate(): Int {
        return (0..9).random()
    }
}
