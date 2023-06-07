package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "Ohsung", age = 20, nickname = "oh")
        assertThat(actual.name).isEqualTo("Ohsung")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("oh")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("Ohsung", 20, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "Ohsung", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("Ohsung", 20, "Oh")
        val person2 = Person("Ohsung", 20, "Oh")
        assertThat(person1).isEqualTo(person2)
    }
}
