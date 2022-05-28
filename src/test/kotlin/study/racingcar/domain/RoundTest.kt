package study.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoundTest {

    @Test
    fun `Round에서 winners를 3명 가져올 수 있다`() {
        val carA = Car("a", 100)
        val carB = Car("b", 100)
        val carC = Car("c", 100)

        val cars = listOf(carA, carB, carC)
        val round = Round(1, cars)

        assertThat(round.winners()).isEqualTo(setOf(carA, carB, carC))
    }

    @Test
    fun `Round에서 winner를 2명 가져올 수 있다`() {
        val carA = Car("a", 100)
        val carB = Car("b", 100)
        val carC = Car("c")

        val cars = listOf(carA, carB, carC)
        val round = Round(1, cars)

        assertThat(round.winners()).isEqualTo(setOf(carA, carB))
    }

    @Test
    fun `Round에서 winner를 1명 가져올 수 있다`() {
        val carA = Car("a", 100)
        val carB = Car("b")
        val carC = Car("c")

        val cars = listOf(carA, carB, carC)
        val round = Round(1, cars)

        assertThat(round.winners()).isEqualTo(setOf(carA))
    }

    @Test
    fun `Round에서 winner는 순서에 관계 없다`() {
        val carA = Car("a", 100)
        val carB = Car("b", 100)
        val carC = Car("c")

        val cars = listOf(carA, carB, carC)
        val round = Round(1, cars)

        assertThat(round.winners()).isEqualTo(setOf(carB, carA))
    }
}
