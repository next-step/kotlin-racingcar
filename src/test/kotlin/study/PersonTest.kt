package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "문일주", age = 20, nickname = "위크")
        assertThat(actual.name).isEqualTo("문일주")
        assertThat(actual.nickname).isEqualTo("위크")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    fun `널 타입`() {
        val actual = Person("문일주", 20, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "문일주", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "문일주", age = 20, "위크")
        val person2 = Person(name = "문일주", age = 20, "위크")
        assertThat(person1).isEqualTo(person2)
    }
}
