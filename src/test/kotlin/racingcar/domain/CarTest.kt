package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @Test
    fun `랜덤값이 4이하일 경우 정지`() {
        car.moveCar { false }
        assertThat(car.carPosition()).isEqualTo(0)
    }

    @Test
    fun `랜덤값이  4이상일 경우 이동`() {
        car.moveCar { true }
        assertThat(car.carPosition()).isEqualTo(1)
    }
}
