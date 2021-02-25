import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김민정", 24, "쟈미"),
            Person("김민정", 24, nickname = "쟈미"),
            Person(name = "김민정", nickname = "쟈미", age = 24)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김민정")
            assertThat(it.age).isEqualTo(24)
            assertThat(it.nickname).isEqualTo("쟈미")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("김민정", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김민정") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("김민정")
        assertAll(
            { assertThat(person.name).isEqualTo("김민정") },
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
