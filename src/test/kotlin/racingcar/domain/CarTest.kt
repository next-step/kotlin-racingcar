package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car

internal class CarTest {

    @Test
    fun `자동차 객체 동등성 비교`() {
        val car1 = Car("a", 1)
        val car2 = Car("a", 1)

        assertThat(car1).isEqualTo(car2)
    }

    @Test
    fun `자동차 객체 포지션 책임 테스트`() {
        val car1 = Car("a", 1)
        val car2 = car1.move(true)

        assertThat(car2.position).isEqualTo(2)
    }

    @Test
    fun `자동차 객체 포지션 움직이지 않음`() {
        val car1 = Car("a", 1)
        val car2 = car1.move(false)

        assertThat(car2.position).isEqualTo(1)
    }

    @Test
    fun `자동차 객체 기본 포지션 값`() {
        val car = Car("a")
        assertThat(car.position).isEqualTo(0)
    }
}
