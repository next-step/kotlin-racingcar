package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        // given
        val person = Person(name = "김성빈", age = 30, nickname = "seongbeenkim")

        // then
        assertThat(person.name).isEqualTo("김성빈")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("seongbeenkim")
    }

    @Test
    fun `널 타입`() {
        // given
        val person = Person(name = "김성빈", age = 30, nickname = null)

        // then
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        // given
        val person = Person(name = "김성빈", age = 30)

        // then
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        // given
        val person1 = Person(name = "김성빈", age = 30)
        val person2 = Person(name = "김성빈", age = 30)

        // then
        assertThat(person1).isEqualTo(person2)
    }
}
