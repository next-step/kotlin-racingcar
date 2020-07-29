package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {

    lateinit var car: Car

    @BeforeEach
    fun `init`() {
        car = Car()
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf(" ", ""))
    fun `is inputCount empty`(inputCount: String) {
        Assertions.assertThatNullPointerException()
            .isThrownBy { InputView.checkUserInput(inputCount) }
            .withMessage("값을 입력해주세요.")
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("0", "-1"))
    fun `is inputCount bigger than 0`(inputCount: String) {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { InputView.checkUserInput(inputCount) }
            .withMessage("0보다 큰 값만 입력할 수 있습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("a", "?"))
    fun `is inputCount num`(inputCount: String) {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { InputView.checkUserInput(inputCount) }
            .withMessage("숫자만 입력가능합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("3", "35"))
    fun `check inputCount normal num`(inputCount: String) {
        Assertions.assertThat(inputCount).isEqualTo(inputCount)
    }

    @Test
    fun `check input randomNumber`() {
        assertTrue(car.changeStateRacingCar(8) == car.move(true))
    }

    @Test
    fun `check car running state`() {
        car.changeStateRacingCar(8)
        assertTrue(car.distance == 1)
    }

    @Test
    fun `check car stop state`() {
        car.changeStateRacingCar(3)
        assertTrue(car.distance == 0)
    }
}
