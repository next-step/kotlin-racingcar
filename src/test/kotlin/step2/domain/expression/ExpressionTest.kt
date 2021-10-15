package step2.domain.expression

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {

    @DisplayName("Expression 인스턴스 생성시 공백 검증 테스트")
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "     "])
    fun constructor_blank_fail_test(blank: String) {
        assertThatThrownBy { Expression(blank) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("연산식이 null 또는 공백입니다.")
    }
}