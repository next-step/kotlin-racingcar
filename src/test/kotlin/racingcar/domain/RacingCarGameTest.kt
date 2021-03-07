package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class RacingCarGameTest {

    @Test
    fun `자동차 게임 생성`() {
        val carNames = listOf<CarName>(CarName("a"))
        val roundCount = PositiveCount(2)
        val result = RacingCarGame(carNames, roundCount)

        assertThat(result).isNotNull
    }

    @Test
    fun `자동차 이름이 빈리스트라면 자동차 게임을 생성할 수 없다`() {
        // given
        val emptyCarNames = emptyList<CarName>()
        val dummyRoundCount = PositiveCount(5)
        val expectedMessage = "자동차 이름이 존재하지 않습니다."

        // when
        val result = assertThrows<IllegalArgumentException> { RacingCarGame(emptyCarNames, dummyRoundCount) }

        // then
        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
