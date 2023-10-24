package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "우디", age = 32, nickname = "woody")

        assertThat(actual.name).isEqualTo("우디")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("woody")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "우디", age = 32, nickname = null)

        assertThat(actual.name).isEqualTo("우디")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "우디", age = 32)

        assertThat(actual.name).isEqualTo("우디")
        assertThat(actual.age).isEqualTo(32)
        assertThat(actual.nickname).isEqualTo("우디")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "우디", age = 32)
        val person2 = Person(name = "우디", age = 32)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person(name = "우디", age = 32)
        assertThat(person.nickname).isEqualTo("우디")

        val actual = person.copy(nickname = "woody")
        assertThat(actual.nickname).isEqualTo("woody")
        assertThat(actual.age).isEqualTo(32)
    }
}
