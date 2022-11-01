package study

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "Son Sora", age = 29, nickname = "ssr03")
        assertThat(person.name).isEqualTo("Son Sora")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("ssr03")
    }

    @Test
    fun `널 타입`() {
        val person = Person("Son sora", 29, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("Son sora", 29)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("Son sora", 29)
        val person2 = Person("Son sora", 29)
        assertThat(person1).isEqualTo(person2)
    }
}
