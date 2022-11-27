package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    @Test
    fun `input으로 입력되는 이름들을 가지고 자동차를 만든다`() {
        // given
        val cars = listOf(
            Car("pobi", Position(5)),
            Car("crong", Position(3)),
            Car("honux", Position(3)),
        )

        // when
        val actual = RacingGame.create(cars).value == cars

        // then
        assertThat(actual).isTrue
    }

    @Test
    fun `레이싱게임 단일 우승자를 찾는다`() {
        // given
        val game = RacingGame(
            listOf(
                Car("pobi", Position(5)),
                Car("crong", Position(3)),
                Car("honux", Position(3)),
            )
        )

        // when
        val actual = AwardsStrategy.FIND_WINNERS.awards(game)

        // then
        val result = listOf(Car("pobi", Position(5)))
        assertThat(actual).isEqualTo(result)
    }

    @Test
    fun `레이싱 게임 공동 우승자를 찾는다`() {
        // given
        val game = RacingGame(
            listOf(
                Car("pobi", Position(5)),
                Car("crong", Position(5)),
                Car("honux", Position(3)),
            )
        )

        // when
        val actual = AwardsStrategy.FIND_WINNERS.awards(game)

        // then
        val result = listOf(
            Car("pobi", Position(5)),
            Car("crong", Position(5)),
        )
        assertThat(actual).isEqualTo(result)
    }
}