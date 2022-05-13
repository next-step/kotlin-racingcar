package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `named args`() {
        val people = listOf(
            Person("구자유", 37, "후리"),
            Person("구자유", 37, nickname = "후리"),
            Person(name = "구자유", age = 37, "후리"),
        )
        assertThat(people[0].name).isEqualTo("구자유")
        assertThat(people[1].name).isEqualTo("구자유")
        assertThat(people[2].name).isEqualTo("구자유")
    }

    @Test
    fun `null type`() {
        val person = Person("구자유", 37, null)
        assertThat(person.name).isEqualTo("구자유")
        assertThat(person.age).isEqualTo(37)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default args`() {
        val person = Person("구자유", 37)
        assertThat(person.name).isEqualTo("구자유")
        assertThat(person.age).isEqualTo(37)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `data class`() {
        val person1 = Person("구자유", 37)
        val person2 = Person("구자유", 37)
        assertThat(person1).isEqualTo(person2)
    }
}