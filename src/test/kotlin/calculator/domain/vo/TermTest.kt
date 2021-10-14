package calculator.domain.vo

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("피연산자(Term)")
class TermTest {
    @Test
    fun `value class는 값 객체로서의 역할을 한다`() {
        val term = Term(1.0)
        val other = Term(1.0)
        assertThat(term).isEqualTo(other)
    }

    @Test
    fun `모든 생성자가 정상적으로 작동한다`() {
        assertAll(
            { assertThat(Term(1.0)).isEqualTo(Term(1.0)) },
            { assertThat(Term(1.0)).isEqualTo(Term("1")) },
        )
    }

    @Test
    fun `생성자에 잘못된 문자열이 들어온 경우 예외를 발생시킨다`() {
        assertThatThrownBy { Term("a").value }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("잘못된 숫자가 입력되었습니다.")
    }

    @Test
    fun `올바르게 값을 가져올 수 있다`() {
        assertAll(
            { assertThat(Term(1.0).value).isEqualTo(1.0) },
            { assertThat(Term("1").value).isEqualTo(1.0) },
            { assertThat(Term(1).value).isEqualTo(1.0) },
            { assertThat(Term(1L).value).isEqualTo(1.0) },
        )
    }
}
