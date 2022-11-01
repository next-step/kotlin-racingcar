package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "강동민", age = 24, nickname = "미니")
        assertThat(person.name).isEqualTo("강동민")
        assertThat(person.age).isEqualTo(24)
        assertThat(person.nickname).isEqualTo("미니")
    }

    @Test
    fun `널 타입`() {
        val person = Person("강동민", 24, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("강동민", 24)
        assertThat(person.nickname).isEqualTo("강동민")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("강동민", 24)
        val person2 = Person("강동민", 24)
        assertThat(person1).isEqualTo(person2)
    }
}
