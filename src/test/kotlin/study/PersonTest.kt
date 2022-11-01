package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "안지영", age = 25, nickname = "지영")
        assertThat(person.name).isEqualTo("안지영")
        assertThat(person.age).isEqualTo(25)
        assertThat(person.nickname).isEqualTo("지영")
    }

    @Test
    fun `널 타입`() {
        val person = Person("안지영", 25, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("안지영", 25)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("안지영", 25)
        val person2 = Person("안지영", 25)
        assertThat(person1).isEqualTo(person2)
    }
}
