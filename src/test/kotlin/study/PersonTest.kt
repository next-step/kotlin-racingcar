package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(nickname = "Sara", age = 10, name = "SaraHan")
        val person2 = Person(name = "SaraHan", nickname = "Sara", age = 10)
        assertThat(person.nickname).isEqualTo("Sara")
        assertThat(person2.nickname).isEqualTo("Sara")
    }

    @Test
    fun `널 타입`() {
        val person = Person(nickname = null, age = 10, name = "Sara")
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `Default parameter`() {
        val person = Person(name = "Sara", age = 10)
        assertThat(person.nickname).isEqualTo("Sara")
    }

    @Test
    fun `Equals`() {
        val person1 = Person(name = "Sara", age = 10, nickname = "Sara")
        val person2 = Person(name = "Sara", age = 10, nickname = "Sara")
        assertThat(person1).isEqualTo(person2)
    }
}
