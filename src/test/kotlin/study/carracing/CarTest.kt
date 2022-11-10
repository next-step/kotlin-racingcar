package study.carracing

import carracing.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    private var car: Car = Car()

    @Test
    @DisplayName("입력 받은 값이 4미만일 경우 멈춤")
    fun stop() {
        car.move(3)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    @DisplayName("입력 받은 값이 4이상일 경우 전진")
    fun move() {
        car.move(4)
        car.move(5)
        assertThat(car.position).isEqualTo(3)
    }

    @Test
    @DisplayName("1정지 1전진")
    fun stopAndMove() {
        car.move(3)
        car.move(5)
        assertThat(car.position).isEqualTo(2)
    }
}
