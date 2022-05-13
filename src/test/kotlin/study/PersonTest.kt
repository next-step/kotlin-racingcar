package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("qyu", 34, "큐"),
            Person("qyu", 34, null),
            Person("qyu", 34, "큐큐")
        )
        assertThat(people[0].name).isEqualTo("qyu")
        assertThat(people[1].age).isEqualTo(34)
        assertThat(people[2].nickname).isEqualTo("큐큐")
    }

    @Test
    fun `null type check`() {
        val person = Person("qyu", 34, null)
        assertThat(person.name).isEqualTo("qyu")
        assertThat(person.age).isEqualTo(34)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default value`() {
        val person = Person("qyu", 34)
        assertThat(person.name).isEqualTo("qyu")
        assertThat(person.age).isEqualTo(34)
        assertThat(person.nickname).isEqualTo("qyu")
    }

    @Test
    fun `data class`() {
        val person1 = Person("qyu", 34, null)
        val person2 = Person("qyu", 34, null)
        assertThat(person1).isEqualTo(person2)
    }
}
