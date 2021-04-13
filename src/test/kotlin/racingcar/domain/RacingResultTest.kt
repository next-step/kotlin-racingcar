package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingResultTest {

    private val winner1 = Car(Name("car2"), Distance(1))
    private val winner2 = Car(Name("car3"), Distance(1))
    private val cars = Cars(listOf(Car(Name("car1")), winner1, winner2))
    private val result = RacingResult(listOf(cars))
    private val winners = result.winners()

    @Test
    fun `결과에서 winners 찾기`() {
        assertThat(winners).isEqualTo(Winners(listOf(winner1, winner2)))
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        assertThat(winners.elements.size).isGreaterThanOrEqualTo(2)
    }
}
