package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {

    lateinit var car: Car

    /*
    [질문]
    테스트함수는 아니지만 테스트에 공통적으로 car 객체가 필요하기때문에 @BeforeEach를 통해
    테스트 전 호출되도록 했는데 그냥 일반 메소드를 호출하는게 더 좋은 방법인가요 ??
     */
    fun init() {
        car = Car()
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf(" ", ""))
    fun `is inputCount empty`(inputCount: String) {
        init()
        Assertions.assertThatIllegalArgumentException()
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
        /*
        [질문]
        이런식으로 toInt()로 String을 Int로 바꿔 값을 비교하는 것도 올바른 테스트인가요?
         */
        Assertions.assertThat(inputCount.toInt()).isEqualTo(InputView.checkUserInput(inputCount))
    }

    @Test
    fun `check input randomNumber over 4`() {
        init()
        assertTrue(car.changeStateRacingCar(8) == car.move(true))
    }

    @Test
    fun `check input randomNumber below 4`() {
        init()
        assertTrue(car.changeStateRacingCar(2) == car.move(false))
    }

    @Test
    fun `check car running state`() {
        init()
        car.changeStateRacingCar(8)
        assertTrue(car.distance == 1)
    }

    @Test
    fun `check car stop state`() {
        init()
        car.changeStateRacingCar(3)
        assertTrue(car.distance == 0)
    }
}
