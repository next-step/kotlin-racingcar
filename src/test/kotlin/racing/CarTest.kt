package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.car.Car

class CarTest {

    @Test
    fun `움직일 수 있는 범위 내에 있지 않아 이동이 불가능한 경우에 대한 테스트`() {
        val moveImpossibleCar = Car("A", 0)

        Assertions.assertThat(moveImpossibleCar.canMoveForward(3)).isEqualTo(false)
    }

    @Test
    fun `움직일 수 있는 범위 내에 있어서 이동이 가능한 경우에 대한 테스트`() {
        val movePossibleCar = Car("A", 0)

        Assertions.assertThat(movePossibleCar.canMoveForward(7)).isEqualTo(true)
    }
}
