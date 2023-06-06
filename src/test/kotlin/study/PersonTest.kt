package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름_붙인_인자`() {
        val actual = Person(name = "전상준", age = 20, nickname = "waveofmymind")
        assertThat(actual.name).isEqualTo("전상준")
        assertThat(actual.nickname).isEqualTo("waveofmymind")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    fun `널_타입`() {
        val actual = Person(name = "전상준", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본_인자`() {
        val actual = Person(name = "전상준", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터_클래스`() {
        val person1 = Person(name = "전상준", age = 20, "waveofmymind")
        val person2 = Person(name = "전상준", age = 20, "waveofmymind")
        assertThat(person1).isEqualTo(person2)
    }
}
