package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김모토", age = 27, nickname = "moto6")
        assertThat(person.name).isEqualTo("김모토")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("moto6")
        person.nickname = "hello"
        assertThat(person.nickname).isEqualTo("hello")
    }

    @Test
    fun `널 타입`() {
        val person = Person("홍길동", 27, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("홍길동", 20)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스 동등성`() {
        val person1 = Person("홍킬동", 20)
        val person2 = Person("홍킬동", 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `데이터 클래스 copy`() {
        val person = Person("홍킬동", 20)
        assertThat(person.nickname).isEqualTo(person.name)
        val copy = person.copy(nickname = "홍홍홍")
        assertThat(copy.nickname).isEqualTo("홍홍홍")
    }
}
