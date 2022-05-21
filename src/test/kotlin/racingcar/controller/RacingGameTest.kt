package racingcar.controller

import org.junit.jupiter.api.BeforeEach
import racingcar.domain.strategy.AlwaysTrueMoveStrategy
import racingcar.domain.strategy.MoveStrategy
import racingcar.domain.strategy.NameStrategy
import racingcar.domain.strategy.TestNameStrategy

class RacingGameTest {
    lateinit var moveStrategy: MoveStrategy
    lateinit var nameStrategy: NameStrategy

    @BeforeEach
    fun initStrategy() {
        moveStrategy = AlwaysTrueMoveStrategy()
        nameStrategy = TestNameStrategy()
    }
}
