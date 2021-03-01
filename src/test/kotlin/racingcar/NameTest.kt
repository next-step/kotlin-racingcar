package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {
    @Test
    fun `이름은 5자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Name("abcedf") }
    }

    @Test
    fun `이름을 생성할 수 있다`() {
        assertThat(Name("pobi").stringValue()).isEqualTo("pobi")
    }
}
