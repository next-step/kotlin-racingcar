package racingcar.car

import racingcar.domain.strategy.NameStrategy

class TestNameStrategy : NameStrategy {
    override fun validateName(name: String) {
        // do nothing
    }
}
