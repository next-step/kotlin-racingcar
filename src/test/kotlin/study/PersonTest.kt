package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이성훈", age = 30, nickname = "Harris")
        assertThat(person.name).isEqualTo("이성훈")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("Harris")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이성훈", 30, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이성훈", 30)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이성훈", 30)
        val person2 = Person("이성훈", 30)
        assertThat(person1).isEqualTo(person2)
    }
}
