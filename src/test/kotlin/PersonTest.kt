import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `test data class`() {
        val person1 = Person(name = "이소현", age = 33, nickname = "fanni")
        val person2 = Person(name = "이소현", age = 33, nickname = "fanni")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `default arguments`() {
        val person = Person(name = "이소현", age = 23, nickname = null)
        assertAll(
            { assertThat(person.name).isEqualTo("이소현") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }
}
