package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이상인", age = 20, nickname = "위푸")
        assertThat(person.name).isEqualTo("이상인")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("위푸")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "이상인", age = 20, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "이상인", age = 20)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이상인", age = 20)
        val person2 = Person(name = "이상인", age = 20)
        assertThat(person1).isEqualTo(person2)
    }
}
