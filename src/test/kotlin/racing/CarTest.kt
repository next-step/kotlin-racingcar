package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.car.Car
import racing.domain.exception.CarNameLengthExcessException
import racing.domain.validation.CarRaceValidation

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

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "Porsche"])
    fun `자동차 이름이 입력 범위에 없는 경우 CarNameLengthExcessException 발생`(carName: String) {
        val carRaceValidation = CarRaceValidation()

        Assertions.assertThatThrownBy { carRaceValidation.validateCarName(listOf(carName)) }
            .isInstanceOf(CarNameLengthExcessException::class.java)
    }
}
