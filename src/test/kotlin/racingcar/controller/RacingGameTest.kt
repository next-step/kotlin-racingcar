package racingcar.controller

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.domain.Drivers
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

    @Test
    fun `레이싱게임 우승자는 드라이버 우승자와 같다`() {
        val racer = listOf("pang", "yohan", "lucy")
        val trialCount = 5
        val drivers = Drivers(racer, nameStrategy)
        val racingGame = RacingGame(drivers, trialCount, moveStrategy)

        racingGame.play()
        val winnersFromRacingGame = racingGame.getWinners()

        // then
        Assertions.assertThat(winnersFromRacingGame).isEqualTo(drivers.getWinnerResults())
    }
}
