package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnersTest {

    @Test
    fun `가장 멀리간 우승자를 리턴한다`() {
        // given
        val car1 = Car(Name("a"), Position(1))
        val car2 = Car(Name("b"), Position(3))
        val givenCars = Cars(listOf(car1, car2))

        // when
        val winners = Winners.findWinners(givenCars)

        // then
        assertThat(winners.cars).containsExactly(car2)
    }

    @Test
    fun `우승자가 두대 이상인 경우의 우승자 목록을 리턴한다`() {
        // given
        val car1 = Car(Name("a"), Position(1))
        val car2 = Car(Name("b"), Position(3))
        val car3 = Car(Name("c"), Position(3))
        val givenCars = Cars(listOf(car1, car2, car3))

        // when
        val winners = Winners.findWinners(givenCars)

        // then
        assertThat(winners.cars).containsExactly(car2, car3)
    }
}
