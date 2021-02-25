package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    internal fun `이름 붙인 인자`() {
        val person = Person(name = "김연태", age = 30, nickname = "urbanscenery")
        assertThat(person.name).isEqualTo("김연태")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("urbanscenery")
    }

    @Test
    internal fun `널타입 테스트`() {
        val person = Person(name = "김연태", age = 30, nickname = null)
        assertAll(
            { assertThat(person.name).isEqualTo("김연태") },
            { assertThat(person.age).isEqualTo(30) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    internal fun `기본인자 테스트`() {
        val person = Person(name = "김연태", age = 30)
        assertAll(
            { assertThat(person.name).isEqualTo("김연태") },
            { assertThat(person.age).isEqualTo(30) },
            { assertThat(person.nickname).isEqualTo(person.name) }
        )
    }

    @Test
    internal fun `data class 테스트`() {
        val person1 = Person(name = "김연태", age = 30)
        val person2 = Person(name = "김연태", age = 30)
        assertThat(person1).isNotEqualTo(person2)
    }
}
