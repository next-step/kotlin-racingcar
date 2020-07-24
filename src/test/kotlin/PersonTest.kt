import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun name() {
        val person = Person("최봉재", 30, "벤자민")
        assertThat(person.name).isEqualTo("최봉재")
        person.nickname = "배고파"
        assertThat(person.nickname).isEqualTo("배고파")
    }

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("최봉재", 30, "벤자민"),
            Person("최봉재", 30, nickname = "벤자민"),
            Person(name = "최봉재", nickname = "벤자민", age = 30)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("최봉재")
            assertThat(it.age).isEqualTo(30)
            assertThat(it.nickname).isEqualTo("벤자민")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("최봉재")
        assertAll(
            { assertThat(person.name).isEqualTo("최봉재") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
