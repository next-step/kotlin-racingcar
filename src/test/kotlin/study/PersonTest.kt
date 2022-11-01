package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "홍길동", age = 10, nickname = "도둑")
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(10)
        assertThat(person.nickname).isEqualTo("도둑")
    }

    @Test
    fun `null 타입`() {
        val person = Person("홍길동", 10, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("홍길동", 10)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person = Person("홍길동", 10)
        val person2 = Person("홍길동", 10)
        assertThat(person).isEqualTo(person2)
    }
}
