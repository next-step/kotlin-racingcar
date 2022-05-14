package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.car.exception.GameOverException
import racingcar.car.strategy.MoveStrategy
import racingcar.car.strategy.NameStrategy

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

    @Test
    fun `게임이 진행 가능 횟수 이상으로 게임을 하면, exception을 던진다`() {
        val correctRacingGameInit = RacingGame(listOf("car1", "car2"), 1, moveStrategy, nameStrategy)
        val badRacingGameInitCase = RacingGame(listOf("car1", "car2"), 0, moveStrategy, nameStrategy)
        val badRacingGameInitCase2 = RacingGame(listOf("car1", "car2"), -1, moveStrategy, nameStrategy)

        assertThat(correctRacingGameInit.isPlayable()).isTrue
        assertThatThrownBy { badRacingGameInitCase.isPlayable() }.isInstanceOf(GameOverException::class.java)
        assertThatThrownBy { badRacingGameInitCase2.isPlayable() }.isInstanceOf(GameOverException::class.java)
    }

    @Test
    fun `게임이 진행되면 횟수가 감소한다`() {
        val racingGame = RacingGame(listOf("car1", "car2", "car3"), 5, moveStrategy, nameStrategy)
        racingGame.play()
        assertThat(racingGame.trialCount).isEqualTo(4)
    }
}
