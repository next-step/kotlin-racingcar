package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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

    @ParameterizedTest
    @CsvSource(value = ["1, true", "0, false", "-1, false"])
    fun `게임이 진행 가능 횟수가 0 초과할 때 게임을 할 수 있다`(testTrialCount: Int, result: Boolean) {
        val correctRacingGameInit = RacingGame(listOf("car1", "car2"), testTrialCount, moveStrategy, nameStrategy)
        assertThat(correctRacingGameInit.isPlayable()).isEqualTo(result)
    }
}
