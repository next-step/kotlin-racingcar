package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.car.Car

class CarTest {

    @Test
    fun `이동 불가능한 케이스 테스트`() {
        val moveImpossibleCar = Car("A", 0)

        Assertions.assertThat(moveImpossibleCar.canMoveForward(3)).isEqualTo(false)
    }

    @Test
    fun `이동 가능한 케이스 테스트`() {
        val movePossibleCar = Car("A", 0)

        Assertions.assertThat(movePossibleCar.canMoveForward(7)).isEqualTo(true)
    }
}
