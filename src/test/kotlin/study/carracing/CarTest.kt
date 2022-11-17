package study.carracing

import carracing.domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    @DisplayName("입력 받은 값이 4이상 일 경우 멈춤")
    fun move() {
        val car = Car(name = "lee", moveStrategy = StandardStrategy(4))
        car.move()
        assertThat(car.position).isEqualTo(2)
    }

    @Test
    @DisplayName("입력 받은 값이 4미만일 경우 멈춤")
    fun stop() {
        val car = Car(name = "lee", moveStrategy = StandardStrategy(3))
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun getCarName() {
        val car = Car("lee")
        assertThat(car.name).isEqualTo("lee")
    }

    @Test
    fun `다섯글자 이상의 이름 입력 시 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            Car("leeyoungjun")
        }
    }
}

