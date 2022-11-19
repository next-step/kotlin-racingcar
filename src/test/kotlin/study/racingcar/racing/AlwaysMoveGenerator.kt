package study.racingcar.racing

import study.racingcar.generator.Generator

internal class AlwaysMoveGenerator : Generator {
    override fun generate(): Int {
        return FORWARD_NUMBER
    }

    companion object {
        private const val FORWARD_NUMBER = 4
    }
}
