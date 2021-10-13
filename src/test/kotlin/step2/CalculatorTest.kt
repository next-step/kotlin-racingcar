package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculatorTest {

    lateinit var calculator:Calculator

    @BeforeEach
    internal fun setUp() {
        calculator = Calculator()
    }

    @DisplayName("Calculator 인스턴스 생성 여부 테스트")
    @Test
    fun constructor_test() {
        // given and when
        val calculator = Calculator()

        // then
        assertAll(
            { assertThat(calculator).isNotNull },
            { assertThat(calculator).isExactlyInstanceOf(Calculator::class.java) },
        )
    }

    // null 입력시 예외처리라고 되어있는데, 애초에 non-nullable 로 처리해서 null 은 테스트 안 했습니다.
    @DisplayName("Calculator 인스턴스 공백 연산시 예외 발생 테스트")
    @ParameterizedTest(name = "연산식 : {0}")
    @ValueSource(strings = ["", " "])
    fun blank_calculate_test(expression: String) {
        // when and then
        assertThatThrownBy { calculator.calculate(expression) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    // @DisplayName("Calculator 인스턴스 덧셈 기능 테스트")
    // @ParameterizedTest(name = "연산식 : {0} = {1}")
    // @CsvSource(value = ["2 + 3:5", "-1 + 1:0", "10 + -3:7", "10 + 5:15", "0 + 0:0"], delimiter = ':')
    // fun plus_test(expression: String, result: Int) {
    //     println("expression = ${expression}")
    //     println("result = ${result}")
    // }

}