package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "기범", age = 27, nickname = "Alex")
        assertThat(actual.name).isEqualTo("기범")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("Alex")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "기범", 27, null)
        assertThat(actual.name).isEqualTo("기범")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "기범", 27)
        assertThat(actual.name).isEqualTo("기범")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("기범")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "기범", 27)
        val person2 = Person(name = "기범", 27)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy 메서드`() {
        val person = Person(name = "기범", 27)
        assertThat(person.name).isEqualTo("기범")

        val actual = person.copy(nickname = "명")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("명")

        actual.nickname = "바뀌나?"
        assertThat(actual.nickname).isEqualTo("바뀌나?")
        assertThat(person.nickname).isNotEqualTo("바뀌나?")
    }
}
