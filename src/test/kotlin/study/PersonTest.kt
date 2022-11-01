package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김동구", age = 31, nickname = "relkimm")
        assertThat(person.name).isEqualTo("김동구")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isEqualTo("relkimm")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "김동구", age = 31, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "김동구", age = 31)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김동구", age = 31)
        val person2 = Person(name = "김동구", age = 31)
        assertThat(person1).isEqualTo(person2)
    }
}
