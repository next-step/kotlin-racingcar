package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙은 인자`() {
        val person = Person(name = "남현우", age = 28, nickname = "tris.2")

        assertThat(person.name).isEqualTo("남현우")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("tris.2")
    }

    @Test
    fun `null 타입`() {
        val person = Person(name = "남현우", age = 28, nickname = null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "남현우", age = 28)

        assertThat(person.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "남현우", age = 28)
        val person2 = Person(name = "남현우", age = 28)

        assertThat(person1).isEqualTo(person2)
    }
}
