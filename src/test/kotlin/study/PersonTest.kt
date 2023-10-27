package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김중완", 29, "Jooan Kim"),
            Person("김중완", 29, nickname = "Jooan Kim"),
            Person(name = "김중완", nickname = "Jooan Kim", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김중완")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("Jooan Kim")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("김중완", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김중완") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김중완")
        assertAll(
            { assertThat(person.name).isEqualTo("김중완") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("김중완", 29, "Jooan Kim")
        val person2 = Person("김중완", 29, "Jooan Kim")
        assertThat(person1).isEqualTo(person2)
    }
}
