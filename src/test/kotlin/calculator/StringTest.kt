package calculator

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun `문자열 자르기`() {

        val input = "1234-5678-9000"

        val substringBefore = input.substringBefore("-")
        val substringAfter = input.substringAfter("-")

        AssertionsForInterfaceTypes.assertThat(substringBefore).isEqualTo("1234")
        AssertionsForInterfaceTypes.assertThat(substringAfter).isEqualTo("5678-9000")
    }

    @Test
    fun `인덱스 가져오기`() {

        var input = "2 + 3 * 4 / 2"
        input = input.replace(" ", "")
        val index = input.indexOfFirst { c -> Operator.PLUS.isSame(c) }
        AssertionsForInterfaceTypes.assertThat(index).isEqualTo(1)
    }
}
