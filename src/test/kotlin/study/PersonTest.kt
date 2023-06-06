package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", age = 30)
        assertThat(actual.name).isEqualTo("홍길동")
    }

    @Test
    fun nullable() {
        val actual = Person(name = "홍길동", age = 30, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 30)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `compare instance`() {
        val actual = Person(name = "홍길동", age = 30, nickname = "고영경")
        val actual1 = Person(name = "홍길동", age = 30, nickname = "고영경")
        assertThat(actual).isEqualTo(actual1)
    }
}
