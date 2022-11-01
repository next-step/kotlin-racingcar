package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `테스트 해 보 아 요`() {
        val person = Person(nickname = "다정", age = 63, name = "김다정")
        assertThat(person.name).isEqualTo("김다정")
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("김다정", 45, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("김다정", 45)
        assertThat(person.nickname).isEqualTo("김다정")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("김다정", 45)
        val person2 = Person("김다정", 45)
        assertThat(person1).isEqualTo(person2)
    }
}
