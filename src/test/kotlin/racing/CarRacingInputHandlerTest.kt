package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import racing.view.CarRacingInputHandler
import racing.view.InputParams

class CarRacingInputHandlerTest {

    @Test
    fun `자동차 수 입력이 없거나 시도 입력이 없으면 IllegalArgumentException`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarRacingInputHandler.validate("", "2", listOf())
        }
    }

    @Test
    fun `자동차 수 입력이 없거나 시도 입력이 숫자가 아니면 IllegalArgumentException`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarRacingInputHandler.validate("a", "2", listOf())
        }
    }

    @Test
    fun `자동차 입력 개수만큼 car object 를 리턴`() {
        val cars = listOf("자동차1", "자동차2")
        val inputParams = InputParams("2", "5", cars)
        assertThat(CarRacingInputHandler.getCars(inputParams).size).isEqualTo(cars.size)
    }

    @Test
    fun `자동차의 이름은 5글자를 초과할 수 없다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarRacingInputHandler.validate("5", "2", listOf("자동차이름5초과"))
        }
        val cars = listOf("자동차1", "자동차2")
        val inputParams = InputParams("2", "5", cars)
        assertThat(CarRacingInputHandler.getCars(inputParams).size).isEqualTo(cars.size.toInt())
    }
}
