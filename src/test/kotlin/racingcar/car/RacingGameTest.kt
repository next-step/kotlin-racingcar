package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.controller.RacingGame
import racingcar.domain.MoveStrategy
import racingcar.domain.NameStrategy
import racingcar.exception.GameOverException

class RacingGameTest {
    lateinit var moveStrategy: MoveStrategy
    lateinit var nameStrategy: NameStrategy

    @BeforeEach
    fun initStrategy() {
        moveStrategy = AlwaysTrueMoveStrategy()
        nameStrategy = object : NameStrategy {
            override fun validateName(name: String) {
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1, true", "0, false", "-1, false"])
    fun `게임이 진행 가능 횟수가 0 초과할 때 게임을 할 수 있다`(testTrialCount: Int, result: Boolean) {
        val correctRacingGameInit = RacingGame(listOf("car1", "car2"), testTrialCount, moveStrategy, nameStrategy)
        assertThat(correctRacingGameInit.isPlayable()).isEqualTo(result)
    }

    @Test
    fun `게임이 진행되면 횟수가 감소한다`() {
        val racingGame = RacingGame(listOf("car1", "car2", "car3"), 5, moveStrategy, nameStrategy)
        racingGame.play()
        assertThat(racingGame.trialCount).isEqualTo(4)
    }

    @Test
    fun `게임 진행 횟수가 없으면 GameOverException을 발생시킨다`() {
        val isOver = RacingGame(listOf("car1", "car2"), 0, moveStrategy, nameStrategy)
        assertThrows<GameOverException> { isOver.play() }
    }
}
