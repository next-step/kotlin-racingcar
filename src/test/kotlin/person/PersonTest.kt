package person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `named arguments`() {
        val people =
            listOf(
                Person(name = "Karyna", age = 20, nickname = "sh1erz"),
                Person(age = 20, nickname = "sh1erz", name = "Karyna"),
                Person(nickname = "sh1erz", name = "Karyna", age = 20),
            )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Karyna")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("sh1erz")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("Karyna", null, "sh1erz")
        assertThat(person.age).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("Karyna", null)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `data classes`() {
        val person1 = Person("Karyna", 20, "sh1erz")
        val person2 = Person("Karyna", 20, "sh1erz")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy data classes`() {
        val person1 = Person("Karyna", 20, "sh1erz")
        val person2 = person1.copy()
        val person3 = person1.copy(name = "John")

        assertAll(
            { assertThat(person1).isEqualTo(person2) },
            { assertThat(person1).isNotEqualTo(person3) },
            { assertThat(person3.name).isEqualTo("John") },
            { assertThat(person3.nickname).isEqualTo("sh1erz") },
        )
    }
}
