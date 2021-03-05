package study.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RaceResultTest {

    @Test
    fun `자동차 경주 결과 상태 값 심볼 테스트`() {
        val cars = listOf(
            Car().apply {
                this.move(5)
                this.move(5)
                this.move(7)
                this.move(9)
            },
            Car().apply {
                this.move(5)
            },
            Car().apply {
                this.move(5)
                this.move(5)
            }
        )
        val mockSymbols = listOf("-----", "--", "---")

        RaceResult(cars).resultSymbols.forEachIndexed { index, s ->
            assertThat(s).isEqualTo(mockSymbols[index])
        }
    }
}
