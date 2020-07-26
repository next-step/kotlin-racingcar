import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class KotlinStudyTest {
    @Test
    fun `split`() {
        val sampleString = "1 + 2 * 3 / 4"
        val stringList = sampleString.split(" ")
        assertThat(stringList).containsExactly("1", "+", "2", "*", "3", "/", "4")
    }

    @Test
    fun `sublist`() {
        val list = listOf("1", "2", "3", "4")
        val actual = list.subList(1, 2)
        assertThat(actual).isEqualTo(listOf("2"))
        val actual2 = list.subList(1, 3)
        assertThat(actual2).isEqualTo(listOf("2", "3"))
        val actual3 = list.subList(1, list.size)
        assertThat(actual3).isEqualTo(listOf("2", "3", "4"))
        val actual4 = list.subList(3, 4)
        assertThat(actual4).isEqualTo(listOf("4"))
        val actual5 = list.subList(4, 4)
        assertThat(actual5.size).isEqualTo(0)
        assertThatThrownBy { list.subList(4, 5) }
            .isInstanceOf(IndexOutOfBoundsException::class.java)
            .hasMessageContaining("toIndex = 5")
    }

    @Test
    fun `indexof`() {
        val list = listOf("1 + 2 * 3")
        val actual = list.indexOf("/")
        assertThat(actual).isEqualTo(-1)
    }

    @Test
    fun `divide by zero`() {
        assertThatThrownBy { 5 / 0 }
            .isInstanceOf(ArithmeticException::class.java)
            .hasMessageContaining("by zero")
    }

    @Test
    fun `throw`() {
        assertThatThrownBy { throw IllegalArgumentException("test exception") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("test exception")
    }

    @Test
    fun `list set`() {
        val list = mutableListOf(4, 5, 6)
        list.set(0, 1)
        assertThat(list[0]).isEqualTo(1)
        assertThat(list[1]).isEqualTo(5)
    }
  
    @Test
    fun `enum`() {
        val actual = Operator("/")
        assertThat(actual).isEqualTo(Operator.DIVIDE)
    }
}
