package racing.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.model.Car
import racing.model.Round

internal class CarRacingTest {

    @Test
    fun `get random value between 0 - 9`() {
        repeat(100) {
            //given
            val numberOfRandomInt = it + 1
            val randomValueFrom = 0
            val randomValueTo = 9

            //when
            val result = CarRacing
                .getRandom(numberOfRandomInt)
                .first()

            //then
            assertThat(result)
                .isGreaterThanOrEqualTo(randomValueFrom)
                .isLessThanOrEqualTo(randomValueTo)
        }
    }

    @Test
    fun `first round do initialization test`() {
        //given
        val firstRoundNo = 0
        val numberOfCars = 3
        val tries = 3
        val carRacing = CarRacing(numberOfCars, tries)
        val expected = List(numberOfCars) { Car() }

        //when
        val result = carRacing.start()

        //then
        assertThat(result[firstRoundNo])
            .extracting("cars")
            .isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "3, 3",
        "10, 20",
        "23, 15",
        "1231, 1"
    )
    fun `start method create round result`(numberOfCars: Int, tries: Int) {
        //given
        val expectedKeys = Array(tries) { it }
        val expectedValue = Round(List(numberOfCars) { Car() })

        //when
        val racingResult = CarRacing(numberOfCars, tries).start()

        //then
        assertThat(racingResult)
            .containsKeys(*expectedKeys)
            .containsEntry(0, expectedValue)
    }
}
