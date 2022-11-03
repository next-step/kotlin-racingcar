package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김찬수", age = 27, nickname = "닉네임")
        assertThat(person.name).isEqualTo("김찬수")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("닉네임")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "김찬수", age = 27, null)
        assertThat(person.name).isEqualTo("김찬수")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "김찬수", age = 27)
        assertThat(person.name).isEqualTo("김찬수")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isNotNull
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김찬수", 27)
        val person2 = Person("김찬수", 27)
        assertThat(person1).isEqualTo(person2)
    }
}
