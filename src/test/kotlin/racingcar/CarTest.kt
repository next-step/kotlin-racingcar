package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차 객체 동등성 비교`() {
        val car1 = Car(1)
        val car2 = Car(1)

        assertThat(car1).isEqualTo(car2)
    }

    @Test
    fun `자동차 객체 포지션 책임 테스트`() {
        val car1 = Car(1)
        val car2 = car1.move()

        assertThat(car2.position).isEqualTo(2)
    }

    @Test
    fun `자동차 객체 기본 포지션 값`() {
        val car = Car()
        assertThat(car.position).isEqualTo(0)
    }
}
