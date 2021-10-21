package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Car 이동시 거리값 변경 확인`() {
        val testCar = Car(4)
        assertThat(
            testCar.run {
                move()
                movedDistance
            }
        ).isEqualTo(1)
    }
    @Test
    fun `불가능한 이동 값 입력`() {
        val car = Car(4)
        assertThat(car.isMoveAble(0)).isEqualTo(false)
        assertThat(car.isMoveAble(1)).isEqualTo(false)
        assertThat(car.isMoveAble(2)).isEqualTo(false)
        assertThat(car.isMoveAble(3)).isEqualTo(false)
    }

    @Test
    fun `이동 가능한 값 입력`() {
        val car = Car(4)
        assertThat(car.isMoveAble(4)).isEqualTo(true)
        assertThat(car.isMoveAble(5)).isEqualTo(true)
        assertThat(car.isMoveAble(6)).isEqualTo(true)
        assertThat(car.isMoveAble(7)).isEqualTo(true)
        assertThat(car.isMoveAble(8)).isEqualTo(true)
        assertThat(car.isMoveAble(9)).isEqualTo(true)
    }
}
