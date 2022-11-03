package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MethodTest {

    @Test
    fun `Enum values 확인`() {
        assertThat(Operator.values()).isEqualTo(
            arrayOf(Operator.PLUS, Operator.MINUS, Operator.DIVISION, Operator.MULTIPLE)
        )
    }

    @Test
    fun `replace 메소드 확인`() {
        val expression = "일 이 삼"
        val result = "일이삼"
        assertThat(
            expression.replace(" ", "")
        ).isEqualTo(result)
    }

    @Test
    fun `joinToString 확인`() {
        val array = arrayOf("가", "나")
        val result = "가|나"
        assertThat(array.joinToString("|")).isEqualTo(result)
    }

    @Test
    fun `joinToString 람다 확인`() {
        val numberMap = mapOf(1 to "First", 2 to "Second")
        assertThat(numberMap.values.joinToString("+") { "$it+" }).isEqualTo("First++Second+")
    }

    @Test
    fun `isNotBlank() 에 빈 공간일 경우 확인`() {
        assertThat(" ".isNotBlank()).isFalse
    }

    @Test
    fun `isNullOrBlank()에 null일 경우 확인`() {
        val expression: String? = null
        assertThat(expression.isNullOrBlank()).isTrue
    }

    @Test
    fun `split 확인`() {
        val expression = "1 2 3 4 5"
        val result = listOf("1", "2", "3", "4", "5")
        assertThat(expression.split(" ")).isEqualTo(result)
    }

    @Test
    fun `toLong 확인`() {
        assertThat("1".toLong()).isEqualTo(1L)
    }

    @Test
    fun `Enum valueOf 확인`() {
        assertThat(Operator.find("+")).isEqualTo(Operator.PLUS)
    }

    @Test
    fun `associateBy 확인`() {
        val operatorMap = Operator.values().associateBy { it.operator }
        assertThat(operatorMap["+"]).isEqualTo(Operator.PLUS)
    }
}
