package study.racingcar.domain.racing

import study.racingcar.domain.generator.Generator

internal class AlwaysMoveGenerator : Generator {
    override fun generate(): Int {
        return FORWARD_NUMBER
    }

    companion object {
        private const val FORWARD_NUMBER = 4
    }
}
