package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `가장 앞을 달리고 있는 차를 구할 수 있다`() {
        // given
        val round = Round()
        val cars = listOf(Car("a", 2), Car("b", 3), Car("c", 3))
        round.saveResult(cars)

        // when
        val winners = round.winner()

        // then
        assertThat(winners).allMatch { it.distance == 3 && listOf("b", "c").contains(it.name) }
    }
}