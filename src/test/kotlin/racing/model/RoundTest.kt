package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoundTest {
    @Test
    fun `next round have same number of prev round cars`() {
        val cars = listOf(Car("test1"), Car("test2"), Car("test3"))
        val round = Round(cars)
        assertThat(round.next())
            .extracting("cars")
            .extracting("size")
            .isEqualTo(cars.size)
    }
}