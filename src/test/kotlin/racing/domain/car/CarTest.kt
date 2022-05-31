package racing.domain.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.exception.CarNameLengthExcessException

class CarTest {

    @Test
    fun `움직일 수 있는 범위 내에 있지 않아 이동이 불가능한 경우에 대한 테스트`() {
        val moveImpossibleCar = Car("A", 0)

        moveImpossibleCar.move(1, 1)
        Assertions.assertThat(moveImpossibleCar.moveCount).isEqualTo(0)
    }

    @Test
    fun `움직일 수 있는 범위 내에 있어서 이동이 가능한 경우에 대한 테스트`() {
        val movePossibleCar = Car("A", 0)

        movePossibleCar.move(1, 6)
        Assertions.assertThat(movePossibleCar.moveCount).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "Porsche"])
    fun `자동차 이름이 입력 범위에 없는 경우 CarNameLengthExcessException 발생`(carName: String) {
        Assertions.assertThatThrownBy { Car(carName) }
            .isInstanceOf(CarNameLengthExcessException::class.java)
    }
}
