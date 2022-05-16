package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceResultTests {
    @Test
    fun `자동차 a, b, c의 위치가 0, 3, 2 인 경우는 우승자가 b 1명이다`() {
        val raceResult = RaceResult(
            listOf(
                RaceCar(
                    listOf(
                        Car("a", 0),
                        Car("b", 1),
                        Car("c", 0),
                    )
                ),
                RaceCar(
                    listOf(
                        Car("a", 0),
                        Car("b", 2),
                        Car("c", 1),
                    )
                ),
                RaceCar(
                    listOf(
                        Car("a", 0),
                        Car("b", 3),
                        Car("c", 2),
                    )
                )
            )
        )

        val actual = raceResult.whoIsWinner()
        val expected = listOf(Car("b", 3))

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `자동차 a, b, c의 위치가 0, 1, 1 인 경우는 우승자가 b, c 2명이다`() {
        val raceResult = RaceResult(
            listOf(
                RaceCar(
                    listOf(
                        Car("a", 0),
                        Car("b", 1),
                        Car("c", 1),
                    )
                )
            )
        )

        val actual = raceResult.whoIsWinner()
        val expected = listOf(Car("b", 1), Car("c", 1))

        assertThat(actual).isEqualTo(expected)
    }
}
