package race

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class NamesTest {
    @Test
    fun `CarNames 는 이름을 가지고 있다`() {
        val actual = Names("a,b,c")

        val expected = Names(listOf(Name("a"), Name("b"), Name("c")))

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `CarNames 는 중복된 이름을 가질 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Names("a,b,a")
        }
    }
}
