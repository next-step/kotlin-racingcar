package step2.domain.expression

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OperandTest {

    @DisplayName("Operand 인스턴스 생성시 공백 검증 테스트")
    @ParameterizedTest(name = "연산자 : `{0}`")
    @ValueSource(strings = ["", " ", "     "])
    fun constructor_blank_fail_test(operand: String) {
        assertThatThrownBy { Operand(operand) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("해당 문자열은 피연산자가 될 수 없습니다.")
    }

    @DisplayName("Operand 인스턴스 생성시 숫자 변환 검증 테스트")
    @ParameterizedTest(name = "연산자 : `{0}`")
    @ValueSource(strings = ["one", "a", "+"])
    fun constructor_non_numeric_fail_test(operand: String) {
        assertThatThrownBy { Operand(operand) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("해당 문자열은 피연산자가 될 수 없습니다.")
    }
}
