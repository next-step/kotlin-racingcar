package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("이동철", 30, "딘"),
            Person("이동철", 30, nickname = "딘"),
            Person(name = "이동철", nickname = "딘", age = 30)
        )

        assertThat(people[0].name).isEqualTo("이동철")
        assertThat(people[1].name).isEqualTo("이동철")
        assertThat(people[2].name).isEqualTo("이동철")
    }

    @Test
    fun `nullable`() {
        val person = Person("이동철", 30, null)

        assertThat(person.name).isEqualTo("이동철")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default argument`() {
        val person = Person("이동철", 30)

        assertThat(person.name).isEqualTo("이동철")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("이동철")
    }

    @Test
    fun `data class`() {
        val person1 = Person("이동철", 30)
        val person2 = Person("이동철", 30)

        assertThat(person1).isEqualTo(person2)
    }
}
