package study.step1

import study.step1.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.util.function.Consumer

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("강성호", 31, "salphaon"),
            Person("강성호", 31, nickname = "salphaon"),
            Person(name = "강성호", age = 31, nickname = "salphaon")
        )

        assertThat(people).allSatisfy(
            Consumer {
                assertThat(it.name).isEqualTo("강성호")
                assertThat(it.age).isEqualTo(31)
                assertThat(it.nickname).isEqualTo("salphaon")
            }
        )
    }

    @Test
    fun `nullable types`() {
        val person = Person("강성호", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("강성호") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("강성호")
        assertAll(
            { assertThat(person.name).isEqualTo("강성호") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("강성호", 31, "salphaon")
        val person2 = Person("강성호", 31, "salphaon")
        assertThat(person1).isEqualTo(person2)
    }
}
