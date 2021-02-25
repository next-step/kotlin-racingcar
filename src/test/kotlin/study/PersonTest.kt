package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "wy.choi", age = 21, nickname = "el")
        assertThat(person.name).isEqualTo("wy.choi")
        assertThat(person.age).isEqualTo(21)
        assertThat(person.nickname).isEqualTo("el")

        val person2 = Person(age = 21, name = "wy.choi", nickname = "el")
        assertThat(person2.name).isEqualTo("wy.choi")
        assertThat(person2.age).isEqualTo(21)
        assertThat(person2.nickname).isEqualTo("el")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "cwy", age = 21, nickname = null)
        assertAll(
            { assertThat(person.name).isEqualTo("cwy") },
            { assertThat(person.age).isEqualTo(21) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "cwy", age = 21)
        assertAll(
            { assertThat(person.name).isEqualTo("cwy") },
            { assertThat(person.age).isEqualTo(21) },
            { assertThat(person.nickname).isEqualTo("el") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "cwy", age = 21, nickname = "el")
        val person2 = Person(name = "cwy", age = 21, nickname = "el")
        assertThat(person1).isEqualTo(person2)
    }
}
