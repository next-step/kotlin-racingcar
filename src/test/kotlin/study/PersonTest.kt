package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "전가빈", age = 30, nickname = "컴공돌이")
        assertThat(person.name).isEqualTo("전가빈")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("컴공돌이")
    }

    @Test
    fun `널 타입`() {
        val person = Person("전가빈", 30, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("전가빈", 30)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("전가빈", 30)
        val person2 = Person("전가빈", 30)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `닉네임이 없을 시 이름과 같이 한다`() {
        val person = Person("전가빈", 30)
        assertThat(person.nickname).isEqualTo("전가빈")
    }
}
