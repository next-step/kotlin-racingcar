package race

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class NamesTest {
    @Test
    fun `Names 는 이름을 쉼표로 구분하여 가질 수 있다`() {
        val actual = Names("a,b,c")

        val expected = Names(listOf(Name("a"), Name("b"), Name("c")))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Names 는 중복된 이름을 가질 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Names("a,b,a")
        }
    }
}
