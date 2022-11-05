package data_class

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `with param name`() {
        val person = Person(
            name = "허지훈",
            nickname = "modernflow",
            age = 29
        )

        assertThat(person.name).isEqualTo("허지훈")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("modernflow")
    }

    @Test
    fun `with param name null`() {
        val person = Person(
            name = "허지훈",
            nickname = null,
            age = null
        )

        assertThat(person.nickname).isNull()
        assertThat(person.age).isNull()
    }

    @Test
    fun `default nickname set by name`() {
        val person = Person(name = "허지훈", age = 29)

        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `data class equal value`() {
        val person1 = Person(name = "허지훈", age = 29)
        val person2 = Person(name = "허지훈", age = 29)

        assertThat(person1).isEqualTo(person2)
    }
}
