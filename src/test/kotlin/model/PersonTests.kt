package model

import model.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTests {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김지훈", 35, "Jiwhun Kim"),
            Person("김지훈", 35, nickname = "Jiwhun Kim"),
            Person(name = "김지훈", nickname = "Jiwhun Kim", age = 35)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김지훈")
            assertThat(it.age).isEqualTo(35)
            assertThat(it.nickname).isEqualTo("Jiwhun Kim")
        }
    }

    @Test
    fun `nullalbe types`() {
        val person = Person("김지훈", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김지훈") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김지훈")
        assertAll(
            { assertThat(person.name).isEqualTo("김지훈") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("김지훈", 35, "Jiwhun Kim")
        val person2 = Person("김지훈", 35, "Jiwhun Kim")
        assertThat(person1).isEqualTo(person2)
    }
}
