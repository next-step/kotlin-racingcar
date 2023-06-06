package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("박재성", 29, "제이슨"),
            Person("박재성", 29, nickname = "제이슨"),
            Person(name = "박재성", nickname = "제이슨", age = 29),
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("박재성")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("제이슨")
        }
    }

    @Test
    fun `default arguments`() {
        val person = Person("박재성")
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
