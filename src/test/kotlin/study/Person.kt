package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

data class Person(val name: String, var age: Int? = null, val nickname: String = name)

class PersonTest {
    @Test
    fun `named arguments`() {
        val people =
            listOf(
                Person(name = "Seokjin Kang", age = 20, nickname = "Seokjin"),
                Person(name = "Seokjin Kang", nickname = "Seokjin", age = 20),
                Person(nickname = "Seokjin", age = 20, name = "Seokjin Kang"),
            )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Seokjin Kang")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("Seokjin")
        }
    }

    @Test
    fun `nullable type`() {
        val person = Person("Seokjin Kang", null, "Kang")
        assertThat(person.age).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("Seokjin Kang")
        assertAll(
            { assertThat(person.name).isEqualTo("Seokjin Kang") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isEqualTo(person.name) },
        )
    }

    @Test
    fun `data class`() {
        val person1 = Person("Seokjin Kang", 20, "Kang")
        val person2 = Person("Seokjin Kang", 20, "Kang")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `data class copy`() {
        val person1 = Person("Seokjin Kang", 20, "Kang")
        val person2 = person1.copy()
        val person3 = person1.copy(name = "강석진")

        assertAll(
            { assertThat(person1).isEqualTo(person2) },
            { assertThat(person3.name).isEqualTo("강석진") },
            { assertThat(person3.age).isEqualTo(person1.age) },
            { assertThat(person3.nickname).isEqualTo(person1.nickname) },
        )
    }
}
