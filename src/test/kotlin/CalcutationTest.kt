package study

import Calculation
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalcutationTest {

    @Test
    fun `예제 확인`() {
        assertThat(Calculation().calcutateByString("2 + 3 * 4 / 2"))
            .isEqualTo(10)
    }

    @Test
    fun `입력값이 Null`() {
        assertThatThrownBy {
            Calculation().calcutateByString(null)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `연산자 다를때`() {
        assertThatThrownBy {
            Calculation().calcutateByString("2 + 3 * 4 % 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `문자열 처음 슷자가 아닐 때`() {
        assertThatThrownBy {
            Calculation().calcutateByString("# + 3 * 4 / 2")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `문자열 마지막이 숫자가 아닐 때`() {
        assertThatThrownBy {
            Calculation().calcutateByString("1 + 3 * 4 / #")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}