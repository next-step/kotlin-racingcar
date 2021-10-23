package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.CarNameException

@Suppress("NonAsciiCharacters")
class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde", "가", "가나다라마"])
    fun `1~5자 사이의 문자열로 차 이름을 만든다`(name: String) {
        assertDoesNotThrow {
            CarName(name)
        }
    }

    @Test
    fun `차 이름은 공백이 될 수 없다`() {
        assertThatThrownBy {
            CarName(" ")
        }.isInstanceOf(CarNameException::class.java)
    }

    @Test
    fun `차 이름은 빈 문자열이 될 수 없다`() {
        assertThatThrownBy {
            CarName("")
        }.isInstanceOf(CarNameException::class.java)
    }

    @Test
    fun `차 이름은 5자를 초과할 수 없다`() {
        assertThatThrownBy {
            CarName("가나다라마바")
        }.isInstanceOf(CarNameException::class.java)
    }

    @Test
    fun `comma로 구분된 문자열로 CarName들을 만든다`() {
        val result: List<CarName> = CarName.from("pobi,honux,crong")

        assertThat(result.map { it.value }).containsExactly("pobi", "honux", "crong")
    }
}
