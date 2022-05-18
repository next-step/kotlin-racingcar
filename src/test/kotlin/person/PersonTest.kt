package person

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `named arguments`() {
        val people: Array<Person> = arrayOf(
            Person("황민호", 39, "로빈"),
            Person("황민호", 39, nickname = "로빈"),
            Person(name = "황민호", nickname = "로빈", age = 39)
        )
        assertThat(people[0].name).isEqualTo("황민호")
        assertThat(people[0].age).isEqualTo(39)
        assertThat(people[0].nickname).isEqualTo("로빈")
    }

    @Test
    fun `nullable types`() {
        val person = Person("황민호", null, null)

        assertThat(person.name).isEqualTo("황민호")
        assertThat(person.age).isNull()
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("황민호")
        assertThat(person.name).isEqualTo("황민호")
        assertThat(person.age).isNull()
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `data classes`() {
        val person1 = Person("황민호", 39, "로빈")
        val person2 = Person("황민호", 39, "로빈")
        assertThat(person1).isEqualTo(person2)
    }
}
