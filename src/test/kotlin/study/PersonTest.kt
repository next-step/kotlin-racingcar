package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        listOf(
            Person("김주태", 29, "JTKIM"),
            Person("김주태", 29, nickname = "JTKIM"),
            Person(name = "김주태", age = 29, nickname = "JTKIM")
        ).forEach {
            assertThat(it.name).isEqualTo("김주태")
        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("김주태", 29, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김주태", 29)
        assertThat(person.nickname).isEqualTo("김주태")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김주태", 29)
        val person2 = Person("김주태", 29)
        assertThat(person1).isEqualTo(person2)
    }
}