package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `차가 한 칸 이동한다`() {
        val car = Car(id = 0, movingStrategy = { true })
        val result = car.moveForward()
        assertThat(result.position).isEqualTo(1)
    }

    @Test
    fun `차가 한 칸 이동하지 않고 정지한다`() {
        val car = Car(id = 1, movingStrategy = { false })
        val result = car.moveForward()
        assertThat(result.position).isEqualTo(0)
    }
}
