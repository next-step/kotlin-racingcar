package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "최용호", age = 21, nickname = "호야")
        assertThat(actual.name).isEqualTo("최용호")
        assertThat(actual.nickname).isEqualTo("호야")
        assertThat(actual.age).isEqualTo(21)
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "최용호", age = 21, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "최용호", age = 21)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "최용호", age = 21, nickname = "호야")
        val person2 = Person(name = "최용호", age = 21, nickname = "호야")
        assertThat(person1).isEqualTo(person2)
    }
}
