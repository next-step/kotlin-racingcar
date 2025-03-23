package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    data class Person(val name: String, var age: Int?, var nickname: String = "")

    @Test
    fun `named arguments`() {
        val people =
            listOf(
                Person(name = "Sunyong Youn", age = 28, nickname = "Sun"),
                Person(name = "Sunyong Youn", nickname = "Sun", age = 28),
                Person(nickname = "Sun", age = 28, name = "Sunyong Youn"),
            )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Sunyong Youn")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("Sun")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("Sunyong Youn", null, "Sunyong")
        assertThat(person.age).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("Sunyong Youn", 28)
        assertThat(person.nickname).isEmpty()
    }

    @Test
    fun `data classes`() {
        val person1 = Person("Sunyong Youn", 28, "Sun")
        val person2 = Person("Sunyong Youn", 28, "Sun")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun copy() {
        val person1 = Person("Sunyong Youn", 28, "Sun")
        val person2 = person1.copy(age = null)

        assertThat(person1.age).isEqualTo(28)
        assertThat(person2.age).isNull()
    }
}
