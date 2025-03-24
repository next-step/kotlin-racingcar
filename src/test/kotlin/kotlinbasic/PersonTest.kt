package kotlinbasic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    data class Person(val name: String, var age: Int?, var nickname: String = "")

    @Test
    fun `named arguments`() {
        val people =
            listOf(
                Person("Junki Kim", age = 20, nickname = "Ed"),
                Person("Junki Kim", nickname = "Ed", age = 20),
                Person(nickname = "Ed", age = 20, name = "Junki Kim"),
            )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Junki Kim")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("Ed")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("Junki Kim", null, "Ed")
        assertThat(person.age).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("Junki Kim", 20)
        assertThat(person.nickname).isEmpty()
    }

    @Test
    fun `data classes`() {
        val person1 = Person("Junki Kim", 20)
        val person2 = Person("Junki Kim", 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy data class`() {
        val person1 = Person("Junki Kim", 20, "Ed")
        val person2 = person1.copy(age = null)

        assertThat(person1.age).isEqualTo(20)
        assertThat(person2.age).isNull()
    }
}
