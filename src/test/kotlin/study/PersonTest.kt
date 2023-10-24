package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(nickname = "길동", name = "홍길동", age = 100)
        assert(person.name == "홍길동")
        assert(person.age == 100)
        assert(person.nickname == "길동")
    }

    @Test
    fun `null 타입`() {
        val person = Person(nickname = null, name = "홍길동", age = 100)
        assert(person.name == "홍길동")
        assertThat(person.age).isEqualTo(100)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "홍길동", age = 100)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(100)
        assertThat(person.nickname).isEqualTo("홍길동")
    }

    @Test
    fun copy() {
        val person = Person(name = "홍길동", age = 100)

        val person2 = person.copy(nickname = "홍")
        assertThat(person2.name).isEqualTo("홍길동")
        assertThat(person2.age).isEqualTo(100)
        assertThat(person2.nickname).isEqualTo("홍")
    }
}
