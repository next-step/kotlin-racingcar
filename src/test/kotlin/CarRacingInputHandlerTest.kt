import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class CarRacingInputHandlerTest {

    @Test
    fun `자동차 수 입력이 없거나 시도 입력이 없으면 IllegalArgumentException`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarRacingInputHandler.validate("", "2")
        }
    }

    @Test
    fun `자동차 수 입력이 없거나 시도 입력이 숫자가 아니면 IllegalArgumentException`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarRacingInputHandler.validate("a", "2")
        }
    }

    @Test
    fun `자동차 입력 개수만큼 car object 를 리턴`() {
        val numberOfCars = "3"
        assertThat(CarRacingInputHandler.getCars(numberOfCars).size).isEqualTo(numberOfCars.toInt())
    }
}
