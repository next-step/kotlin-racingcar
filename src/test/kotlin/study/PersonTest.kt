package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `named arg`() {
        val people = listOf(
            Person("박상민", 17, "deadpk"),
            Person("박상민", 17, nickname = "deadpk"),
            Person(name = "박상민", nickname = "deadpk", age = 17)
        )
        assertThat(people[0].name).isEqualTo("박상민")
        assertThat(people[1].name).isEqualTo("박상민")
        assertThat(people[2].name).isEqualTo("박상민")
    }

    @Test
    fun `nullable arg`() {
        val person = Person("박상민", 17, null)
        assertThat(person.name).isEqualTo("박상민")
        assertThat(person.age).isEqualTo(17)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default arg`() {
        val person = Person("박상민", 17)
        assertThat(person.name).isEqualTo("박상민")
        assertThat(person.age).isEqualTo(17)
        assertThat(person.nickname).isEqualTo("박상민")
    }

    @Test
    fun `data class`() {
        val person1 = Person("박상민", 17)
        val person2 = Person("박상민", 17)
        assertThat(person1 == person2)
    }
}
