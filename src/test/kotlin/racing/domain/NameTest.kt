package racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {

    @Test
    fun `이름 생성 테스트`() {
        // given
        val value = "name"

        // when
        val name = Name(value)

        // then
        assertEquals(value, name.toString())
    }

    @ParameterizedTest(name = "name = \"{0}\"")
    @ValueSource(strings = ["", "   ", "name12", "name123"])
    fun `이름 생성 예외 테스트(이름이 공백이거나 5자를 초과할 경우)`(wrongName: String) {
        // when & then
        Assertions.assertThatThrownBy {
            Car(Name(wrongName), CarTest.forwardByOneMoveStrategy)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
