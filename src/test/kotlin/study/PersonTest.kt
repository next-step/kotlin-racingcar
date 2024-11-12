package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "함석호", nickname = "호석이", age = 100)

        assertThat(actual.name).isEqualTo("함석호")
        assertThat(actual.age).isEqualTo(100)
        assertThat(actual.nickname).isEqualTo("호석이")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("함석호", age = 100, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "함석호", age = 100)
        assertThat(actual.nickname).isEqualTo(actual.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "함석호", age = 100, nickname = "호석이")
        val person2 = Person(name = "함석호", age = 100, nickname = "호석이")

        assertThat(person1).isEqualTo(person2)
    }
}
