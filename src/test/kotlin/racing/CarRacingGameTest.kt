package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarRacingGameTest {
    @ParameterizedTest
    @CsvSource(value = ["1, 0", "4, 1", "10, 1"])
    fun `자동차 이동 테스트`(value: Int, expect: Int) {
        val car = Car()
        car.move(value)
        assertThat(car.position).isEqualTo(expect)
    }

    @Test
    fun `랜덤값 범위 테스트`() {
        repeat(100) {
            assertThat(RandomGenerator.generate()).isBetween(0, 9)
        }
    }
}
