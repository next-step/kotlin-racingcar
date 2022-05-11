package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarRacingGameTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 0", "4, 1", "10, 1"])
    fun `자동차 이동 테스트`(value: Int, expect: Int) {
        car.move(value)
        assertThat(car.position).isEqualTo(expect)
    }
}
