package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest{
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("옥종훈", 29, "테오"),
            Person("옥종훈", 29, nickname = "테오"),
            Person(name = "옥종훈", nickname = "테오", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("옥종훈")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("테오")
        }
    }

    @Test
    fun `default arguments`() {
        val person = Person("옥종훈", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("옥종훈") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("Guest") }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("옥종훈", 29, "테d")
        val person2 = Person("옥종훈", 29, "테오")
        assertThat(person1).isEqualTo(person2)
    }
}