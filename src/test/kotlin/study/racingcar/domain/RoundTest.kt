package study.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RoundTest {

    @Test
    fun `Round에서 winner는 순서에 관계 없다`() {
        val carA = Car("a", 100)
        val carB = Car("b", 100)
        val carC = Car("c")

        val cars = listOf(carA, carB, carC)
        val round = Round(1, cars)

        assertThat(round.winners()).isEqualTo(setOf(carB, carA))
    }

    @ParameterizedTest
    @MethodSource("carsArguments")
    fun `Round Winner를 가져올 수 있다`(cars: List<Car>, size: Int) {
        val round = Round(1, cars)

        assertThat(round.winners()).hasSize(size)
    }

    companion object {
        @JvmStatic
        fun carsArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(Car("a", 100), Car("b", 100), Car("c", 100)),
                    3
                ),
                Arguments.of(
                    listOf(Car("a", 100), Car("b", 100), Car("c")),
                    2
                ),
                Arguments.of(
                    listOf(Car("a", 100), Car("b"), Car("c")),
                    1
                )
            )
        }
    }
}
