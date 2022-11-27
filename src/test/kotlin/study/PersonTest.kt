package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "서준수", age = 22, nickname = "제임스")
        assertThat(person.name).isEqualTo("서준수")
        assertThat(person.age).isEqualTo(22)
        assertThat(person.nickname).isEqualTo("제임스")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "서준수", age = 22, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "서준수", age = 22)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "서준수", age = 22)
        val person2 = Person(name = "서준수", age = 22)
        assertThat(person1).isEqualTo(person2)
    }
}
