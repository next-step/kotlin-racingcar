package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김준호", age = 20, nickname = "준")
        assertThat(actual.name).isEqualTo("김준호")
        assertThat(actual.nickname).isEqualTo("준")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "김준호", age = 20, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "김준호", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김준호", age = 20, nickname = "준")
        val person2 = Person(name = "김준호", age = 20, nickname = "준")
        assertThat(person1).isEqualTo(person2)
    }
}
