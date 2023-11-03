package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 생성에 성공한다`() {
        val car = Car(TrueEngine)
        assertNotNull(car)
    }

    @Test
    fun `자동차 전진에 성공한다`() {
        val car = Car(TrueEngine)
        assertThat(car.move()).isEqualTo(1L)
    }

    @Test
    fun `자동차 전진에 실패한다`() {
        val car = Car(FalseEngine)
        assertThat(car.move()).isEqualTo(0L)
    }

    @Test
    fun `자동차 전진을 여러번 할 수 있다`() {
        val car = Car(TrueEngine)
        car.move()
        car.move()
        car.move()
        assertThat(car.getPosition()).isEqualTo(3L)
    }
}
