package study.carracing

import carracing.domain.Car
import carracing.domain.StandardStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("입력 받은 값이 4이상 일 경우 멈춤")
    fun move() {
        val car = Car(moveStrategy = StandardStrategy(4))
        car.move()
        assertThat(car.position).isEqualTo(2)
    }

    @Test
    @DisplayName("입력 받은 값이 4미만일 경우 멈춤")
    fun stop() {
        val car = Car(moveStrategy = StandardStrategy(3))
        car.move()
        assertThat(car.position).isEqualTo(1)
    }
}
