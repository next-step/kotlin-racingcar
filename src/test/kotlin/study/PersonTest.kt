package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `test test`() {
        val actual = Person(name = "홍길동", 20, nickname = "홍")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍")
    }
}
