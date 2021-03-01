package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {
    @Test
    fun `이름은 5자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Name("abcedf") }
    }

    class Name(private val name: String) {
        init {
            require(name.length <= 5)
        }
    }
}
