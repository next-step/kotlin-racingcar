package racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차 움직임 테스트`() {
        val car = Car()
        car.tryMove(object : Movable { override fun isMovable(): Boolean = true })
        Assertions.assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `자동차 움직 이지 않음 테스트`() {
        val car = Car()
        car.tryMove(object : Movable { override fun isMovable(): Boolean = false })

        Assertions.assertThat(car.position).isEqualTo(0)
    }
}
