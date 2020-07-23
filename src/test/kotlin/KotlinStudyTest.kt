import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinStudyTest {
    @Test
    internal fun splitTest() {
        val a = "1 + 2 * 3".split("+","-","*","/")
        assertThat(a.size).isEqualTo(3)
        assertThat(a[0]).isEqualTo("1 ")
        assertThat(a[1]).isEqualTo(" 2 ")
        assertThat(a[2]).isEqualTo(" 3")
        val a2 = a.map{
            it.trim()
        }
        assertThat(a2[0]).isEqualTo("1")
        assertThat(a2[1]).isEqualTo("2")
        assertThat(a2[2]).isEqualTo("3")
        val intList = a2.map{
            it.toInt()
        }
        println(intList)
        val b = "1+2*3".split("+","-","*","/")
        assertThat(b[0]).isEqualTo("1")
        assertThat(b[1]).isEqualTo("2")
        assertThat(b[2]).isEqualTo("3")
    }
}