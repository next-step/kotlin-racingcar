package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("박제헌", 31, "jeff.42"),
            Person("박제헌", 31, nickname = "jeff.42"),
            Person(name = "박제헌", nickname = "jeff.42", age = 31),
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("박제헌")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("jeff.42")
        }
    }

    @Test
    fun `default arguments`() {
        val person = Person("박제헌")
        assertAll(
            { assertThat(person.name).isEqualTo("박제헌") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("박제헌", 32, "jeff.42")
        val person2 = Person("박제헌", 32, "jeff.42")
        assertThat(person1).isEqualTo(person2)
    }
}
