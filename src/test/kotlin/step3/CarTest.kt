package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Car 이동 성공시 값 변경 확인`() {
        val testCar = Car(4)
        assertThat(
            testCar.run {
                move()
                movedDistance
            }
        ).isEqualTo(1)
    }
}
