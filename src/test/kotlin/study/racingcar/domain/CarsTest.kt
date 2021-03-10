package study.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `자동차 경주 결과 상태 값 심볼 테스트`() {
        val cars = listOf(
            Car("test1").apply {
                this.move(5)
                this.move(5)
                this.move(7)
                this.move(9)
            },
            Car("test2").apply {
                this.move(5)
            },
            Car("test3").apply {
                this.move(5)
                this.move(5)
            }
        )
        val mockSymbols = listOf("test1 : ----", "test2 : -", "test3 : --")

        Cars(cars).racedCars.forEachIndexed { index, s ->
            assertThat(s.toString()).isEqualTo(mockSymbols[index])
        }
    }
}
