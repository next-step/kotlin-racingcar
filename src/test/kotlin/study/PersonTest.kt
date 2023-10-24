package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "신지훈", age = 27, nickname = "jihoon-shin")
        assertThat(person.name).isEqualTo("신지훈")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("jihoon-shin")
        person.nickname = "hello"
        assertThat(person.nickname).isEqualTo("hello")
    }

    @Test
    fun `널 타압`() {
        val person = Person("홍길동", 27, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("홍길동", 20)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍킬동", 20)
        val person2 = Person("홍킬동", 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun copy() {
        val person = Person("홍킬동", 20)
        assertThat(person.nickname).isEqualTo(person.name)
        val copy = person.copy(nickname = "홍홍홍")
        assertThat(copy.nickname).isEqualTo("홍홍홍")
    }
}
