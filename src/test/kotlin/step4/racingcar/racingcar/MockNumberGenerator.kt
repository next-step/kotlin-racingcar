package step4.racingcar.racingcar

import step4.racingcar.racingcar.domain.NumberGenerator

object MockNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return 6
    }
}
