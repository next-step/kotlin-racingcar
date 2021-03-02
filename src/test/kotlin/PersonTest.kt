import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("서진혁", 29, "카샤"),
            Person("서진혁", 29, nickname = "카샤"),
            Person(name = "서진혁", nickname = "카샤", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("서진혁")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("카샤")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("서진혁", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("서진혁") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("서진혁")
        assertAll(
            { assertThat(person.name).isEqualTo("서진혁") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("서진혁", 29, "카샤")
        val person2 = Person("서진혁", 29, "카샤")
        assertThat(person1).isEqualTo(person2)
    }
}
