package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차 움직임 테스트`() {
        val car = Car()
        car.tryMove(object : Movable { override fun isMovable(): Boolean = true })
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `자동차 움직 이지 않음 테스트`() {
        val car = Car()
        car.tryMove(object : Movable { override fun isMovable(): Boolean = false })
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차 이름은 최대 5글자이다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Car("123456") }
            .withMessage("The maximum name length is 5")
    }
}
