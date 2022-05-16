package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RoundTest {

    @ParameterizedTest
    @MethodSource("generateData")
    fun `next test`(numberOfCar: Int, randomNumbers: List<Int>, expected: List<Car>) {
        //given
        val cars = List(numberOfCar) { Car() }
        val round = Round(cars)

        //when
        val result = round.next(randomNumbers).cars

        //then
        assertThat(result)
            .isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    5,
                    listOf(5, 8, 1, 2, 4),
                    listOf(Car().go(), Car().go(), Car(), Car(), Car().go())),
                Arguments.of(
                    2,
                    listOf(1, 4),
                    listOf(Car(), Car().go())),
                Arguments.of(
                    3,
                    listOf(2, 8, 4),
                    listOf(Car(), Car().go(), Car().go())),
                Arguments.of(
                    5,
                    listOf(1, 1, 1, 5, 4),
                    listOf(Car(), Car(), Car(), Car().go(), Car().go())),
                Arguments.of(
                    4,
                    listOf(6, 3, 6, 8),
                    listOf(Car().go(), Car(), Car().go(), Car().go())),
            )
        }
    }
}
