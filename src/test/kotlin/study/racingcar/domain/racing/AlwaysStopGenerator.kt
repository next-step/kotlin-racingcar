package study.racingcar.domain.racing

import study.racingcar.domain.generator.Generator

internal class AlwaysStopGenerator : Generator {
    override fun generate(): Int {
        return NON_FORWARD_NUMBER
    }

    companion object {
        private const val NON_FORWARD_NUMBER = 3
    }
}
