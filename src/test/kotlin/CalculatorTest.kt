import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `덧셈 테스트`() {
        Assertions.assertThat(Calculator("3 + 5").execute()).isEqualTo(8)
        Assertions.assertThat(Calculator("9 + 0 + 1").execute()).isEqualTo(10)
        Assertions.assertThat(Calculator("9 - 10").execute()).isEqualTo(-1)
    }

    @Test
    fun `곱셈 테스트`() {
        Assertions.assertThat(Calculator("2 * 10").execute()).isEqualTo(20)
        Assertions.assertThat(Calculator("9 * 9").execute()).isEqualTo(81)
    }

    @Test
    fun `나눗셈 테스트`() {
        Assertions.assertThat(Calculator("10 / 2").execute()).isEqualTo(5)
        Assertions.assertThat(Calculator("9 / 1").execute()).isEqualTo(9)
    }

    @Test
    fun `0으로 나누었을 때 예외 테스트`() {
        Assertions.assertThatThrownBy { Calculator("3 / 0").execute() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력 값이 null 이거나 빈 공백 문자인 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator("").execute()
            Calculator(null).execute()
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator("9 ^ 2 ").execute()
            Calculator("10 @ 2 ").execute()
        }
    }

    @Test
    fun `사칙 연산을 모두 포함하는 경우`() {
        Assertions.assertThat(Calculator("2 + 3 * 4 / 2").execute()).isEqualTo(10)
    }
}
