package racing.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racing.model.Car
import racing.model.Round
import java.util.stream.Stream

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

    @ParameterizedTest
    @MethodSource("generateData")
    fun `start method create round result`(carNamesStr:List<String>, tries: Int, cars: List<Car>) {
        //given
        val expectedKeys = Array(tries) { it }
        val expectedValue = Round(cars)

        //when
        val racingResult = CarRacing(carNamesStr, tries).start()

        //then
        assertThat(racingResult.roundMap)
            .containsKeys(*expectedKeys)
            .containsEntry(0, expectedValue)
    }

    companion object {
        @JvmStatic
        private fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf("test1","test2","test3","test4","test5"),
                    5,
                    listOf(
                        Car("test1"),
                        Car("test2"),
                        Car("test3"),
                        Car("test4"),
                        Car("test5")
                    )
                ),
                Arguments.of(
                    listOf("test1","test2"),
                    2,
                    listOf(
                        Car("test1"),
                        Car("test2")
                    )
                ),
                Arguments.of(
                    listOf("test1","test2","test3"),
                    3,
                    listOf(
                        Car("test1"),
                        Car("test2"),
                        Car("test3")
                    )
                ),
                Arguments.of(
                    listOf("test1","test2","test3","test4"),
                    4,
                    listOf(
                        Car("test1"),
                        Car("test2"),
                        Car("test3"),
                        Car("test4")
                    )
                ),
            )
        }
    }
}