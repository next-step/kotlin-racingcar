package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarRacingTest {

    @Test
    fun `get random value between 0 - 9`() {
        repeat(100) {
            assertThat(CarRacing.getRandom())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9)
        }
    }

    @Test
    fun `first round do initialization test`() {
        val carRacing = CarRacing(3, 3)
        assertThat(carRacing.eachRoundMap)
            .isEmpty()

        carRacing.round(1)
        val expected = List(3) { Car() }

        assertThat(carRacing.eachRoundMap[1])
            .isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "3, 3",
        "10, 20",
        "23, 15",
        "1231, 1"
    )
    fun `start method create each round result`(numberOfCars: Int, tries: Int) {
        val carRacing = CarRacing(numberOfCars, tries)
        carRacing.start()

        val expectedKeys = Array(tries) { it }
        val expectedValue = List(numberOfCars) { Car() }
        assertThat(carRacing.eachRoundMap)
            .containsKeys(*expectedKeys)
            .containsEntry(0, expectedValue)
    }
}
