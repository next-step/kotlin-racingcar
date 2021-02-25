package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "Joseph", age = 12, nickname = "Joseph123")
        assertThat(person.name).isEqualTo("Joseph")
        assertThat(person.age).isEqualTo(12)
        assertThat(person.nickname).isEqualTo("Joseph123")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("Joseph", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("Joseph") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("Joseph", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("Joseph") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("Joseph") }
        )
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("Joseph1", 22, "Joseph1")
        val person2 = Person("Joseph1", 22, "Joseph1")
        assertThat(person1).isEqualTo(person2)
    }
}
