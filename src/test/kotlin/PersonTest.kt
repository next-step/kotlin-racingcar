import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun constructor() {
        val person = Person("전지은", 31, "jjin")

        assertThat(person.name).isEqualTo("전지은")
        person.nickname = "jjin"
        assertThat(person.nickname).isEqualTo("jane")
    }
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("박재성", 29, "제이슨"),
            Person("박재성", 29, nickname = "제이슨"),
            Person(name = "박재성", nickname = "제이슨", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("박재성")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("제이슨")
        }
    }
    @Test
    fun `nullable types`() {
        val person = Person("박재성", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }
    @Test
    fun `default arguments`() {
        val person = Person("박재성")
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
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
