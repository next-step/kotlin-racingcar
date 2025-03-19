import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class PersonTest {
    data class Person(val name: String, val age: Int?, var nickname: String = name)

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("MingyumKim", 20, "Anna"),
            Person("MingyumKim", 20, nickname = "Anna"),
            Person(name = "MingyumKim", nickname = "Anna", age = 20)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("MingyumKim")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("Anna")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("MingyumKim", null, "Anna")
        assertAll(
            { assertThat(person.name).isEqualTo("MingyumKim") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isEqualTo("Anna") }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("MingyumKim", null)
        assertAll(
            { assertThat(person.name).isEqualTo("MingyumKim") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isEqualTo("MingyumKim") }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("MingyumKim", 20, "Anna")
        val person2 = Person("MingyumKim", 20, "Anna")
        assertThat(person1).isEqualTo(person2)
    }
}