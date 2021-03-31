package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingResultTest {

    private val car1 = Car(Name("car1"))
    private val car2 = Car(Name("car2"), Distance(1))
    private val car3 = Car(Name("car3"), Distance(1))
    private val cars = Cars(listOf(car1, car2, car3))

    @Test
    fun `결과에서 winners 찾기`() {
        val result = RacingResult()
        result.add(cars)

        val winners = result.winners()
        assertThat(winners).isEqualTo(Winners(listOf(car2, car3)))
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        val result = RacingResult()
        result.add(cars)

        val winners = result.winners()

        assertThat(winners.elements.size).isGreaterThanOrEqualTo(2)
    }
}
