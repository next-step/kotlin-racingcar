package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

internal class RacingGameTest {
    @Test
    internal fun `모든 자동차의 게임결과가 전진이 나왔을 때 score가 전부 1이 되었는지 확인`() {
        val game = RacingGame(CarFactory.manufacture(listOf("aaa", "bbb", "abc")))
        game.play(TestMoveStrategy(true))

        SoftAssertions.assertSoftly {
            assertThat(game.cars.size).isEqualTo(3)
            assertThat(game.cars[0].score).isEqualTo(1)
            assertThat(game.cars[1].score).isEqualTo(1)
            assertThat(game.cars[2].score).isEqualTo(1)
        }
    }

    @Test
    internal fun `모든 자동차의 게임 결과가 전진이 나오지 않았을 때 score가 전부 0이 되었는지 확인`() {
        val game = RacingGame(CarFactory.manufacture(listOf("aaa", "bbb")))
        game.play(TestMoveStrategy(false))

        SoftAssertions.assertSoftly {
            assertThat(game.cars.size).isEqualTo(2)
            assertThat(game.cars[0].score).isEqualTo(0)
            assertThat(game.cars[1].score).isEqualTo(0)
        }
    }

    @Test
    internal fun `가장 큰 score를 가진 자동차가 우승자로 결정난다`() {
        val game = RacingGame(CarFactory.manufacture(listOf("aaa", "bbb", "abc")))
        game.cars[0].move(TestMoveStrategy(true))

        SoftAssertions.assertSoftly {
            assertThat(game.cars[0].score).isEqualTo(1)
            assertThat(game.cars[1].score).isEqualTo(0)
            assertThat(game.cars[2].score).isEqualTo(0)
            assertThat(game.getWinners().joinToString(",") { it.name }).isEqualTo("aaa")
        }
    }

    @Test
    internal fun `우승자는 2명이상일 수 있다`() {
        val game = RacingGame(CarFactory.manufacture(listOf("aaa", "bbb", "abc")))
        game.cars[0].move(TestMoveStrategy(true))
        game.cars[1].move(TestMoveStrategy(true))

        SoftAssertions.assertSoftly {
            assertThat(game.cars[0].score).isEqualTo(1)
            assertThat(game.cars[1].score).isEqualTo(1)
            assertThat(game.cars[2].score).isEqualTo(0)
            assertThat(game.getWinners().joinToString(",") { it.name }).isEqualTo("aaa,bbb")
        }
    }
}
