package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙은 인자`() {
        val person1 = Person(name = "홍길동", age = 10, nickname = "홍길동닉네임")
        val person2 = Person(name = "홍길동", age = 10, nickname = "홍길동닉네임")

        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("홍길동", 11, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("홍길동", 11)
        assertThat(person.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "홍길동", age = 10, nickname = "홍길동닉네임")
        val person2 = Person(name = "홍길동", age = 10, nickname = "홍길동닉네임")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person(name = "홍길동", age = 10, nickname = "홍길동닉네임")
        val person2 = person1.copy(nickname = null)
        assertThat(person2.name).isEqualTo("홍길동")
    }
}
