package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "권재용", age = 29, nickname = "jaeykweon")

        assertThat(person.name).isEqualTo("권재용")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("jaeykweon")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "권재용", age = 29, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "권재용", age = 29)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "권재용", age = 29)
        val person2 = Person(name = "권재용", age = 29)
        assertThat(person1).isEqualTo(person2)
    }
}