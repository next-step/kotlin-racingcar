package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("Eunsol", 20, "Vero"),
            Person("Eunsol", 20, nickname = "Vero"),
            Person(name = "Eunsol", nickname = "Vero", age = 20)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Eunsol")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("Vero")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("Eunsol", null, "Vero")
        assertAll(
            { assertThat(person.name).isEqualTo("Eunsol") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isEqualTo("Vero") }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("Eunsol")
        assertAll(
            { assertThat(person.name).isEqualTo("Eunsol") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isBlank() },
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("Eunsol", 20, "Vero")
        val person2 = Person("Eunsol", 20, "Vero")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `data classes copy`() {
        val person1 = Person("Eunsol", 20, "Vero")
        val person2 = person1.copy()
        val person3 = person1.copy(name = "Eunsol Kim")

        assertAll(
            { assertThat(person1).isEqualTo(person2) },
            { assertThat(person3.name).isEqualTo("Eunsol Kim") },
            { assertThat(person3.age).isEqualTo(person1.age) },
            { assertThat(person3.nickname).isEqualTo(person1.nickname) }
        )
    }
}