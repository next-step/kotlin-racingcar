package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoundTest {

    @Test
    fun `next test`() {
        //given
        val numberOfCar = 5
        val randomNumbers = listOf(5, 8, 1, 2, 4)
        val expected = listOf(
            Car("testName").go(),
            Car("testName").go(),
            Car("testName"),
            Car("testName"),
            Car("testName").go()
        )
        val cars = List(numberOfCar) { Car("testName") }
        val round = Round(cars)

        //when
        val result = round.next(randomNumbers).cars

        //then
        assertThat(result)
            .isEqualTo(expected)
    }
}
