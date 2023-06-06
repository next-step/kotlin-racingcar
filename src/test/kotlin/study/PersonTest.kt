package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "박규동", age = 30, nickname = "kyudong3")
        assertThat(actual.name).isEqualTo("박규동")
        assertThat(actual.nickname).isEqualTo("kyudong3")
        assertThat(actual.age).isEqualTo(30)
    }

    @Test
    fun `널 타입`() {
        val actual = Person("박규동", 30, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "박규동", age = 30)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("박규동", 30, "Park")
        val person2 = Person("박규동", 30, "Park")
        assertThat(person1).isEqualTo(person2)
    }
}