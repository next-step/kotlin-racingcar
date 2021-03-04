import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김혜진", 28, "haley"),
            Person("김혜진", 28, nickname = "haley"),
            Person(name = "김혜진", nickname = "haley", age = 28)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김혜진")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("haley")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("김혜진", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김혜진") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김혜진")
        assertAll(
            { assertThat(person.name).isEqualTo("김혜진") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("김혜진", 29, "haley")
        val person2 = Person("김혜진", 29, "haley")
        assertThat(person1).isEqualTo(person2)
    }

}