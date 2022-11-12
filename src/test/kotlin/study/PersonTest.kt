package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource

class PersonTest {

    @Test
    fun `이름 붙인 인자`() { // (1 왼쪽 문자) 백틱을 쓰면 스페이스바까지 사용하여 이름을 선언할 수 있다.
        val person = Person(name = "이영준", age = 29, nickname = "edi")
        assertThat(person.name).isEqualTo("이영준")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("edi")
    }

    @ParameterizedTest
    @NullSource
    fun `널 타입`(person: Person? = Person(name = "이영준", age = 29, null)) {
        assertTrue(person?.nickname == null)
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "이영준", age = 29)
        assertThat(person.name).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이영준", age = 29)
        val person2 = Person(name = "이영준", age = 29)
        assertThat(person1).isEqualTo(person2)
    }
}
