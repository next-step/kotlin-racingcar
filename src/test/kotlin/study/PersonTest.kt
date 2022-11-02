package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    internal fun `이름 붙인 인자`() {
        val person = Person(name = "김동인", age = 20, nickname = "eastperson")
        assertThat(person.name).isEqualTo("김동인")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("eastperson")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person(name = "김동인", age = 20, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person(name = "김동인", age = 20)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("김동인", 20)
        val person2 = Person("김동인", 20)
        assertThat(person1).isEqualTo(person2)
    }
}
