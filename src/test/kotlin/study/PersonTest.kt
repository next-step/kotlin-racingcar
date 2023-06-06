package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이현재", age = 30, nickname = "hjjae2")

        assertThat(person.name).isEqualTo("이현재")
        assertThat(person.nickname).isEqualTo("hjjae2")
        assertThat(person.age).isEqualTo(30)
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "이현재", age = 30, nickname = null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "이현재", age = 30)

        assertThat(person.nickname).isEqualTo("Guest")
    }
}
