package racing.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.Car

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
        val carNames = listOf("tom", "jerry", "bull")
        val tries = 3
        val carRacing = CarRacing(carNames, tries)
        val expected = listOf(
            Car("tom"),
            Car("jerry"),
            Car("bull")
        )

        //when
        val result = carRacing.start()

        //then
        assertThat(result.get(firstRoundNo))
            .extracting("cars")
            .isEqualTo(expected)
    }
}