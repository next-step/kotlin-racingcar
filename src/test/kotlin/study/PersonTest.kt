package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @author 이상준
 */
class PersonTest {
    @Test
    fun `이름 인자 테스트`() {
        val person = Person(name = "이상준", age = 27, nickname = "sangjun")
        assertThat(person.name).isEqualTo("이상준")
        assertThat(person.age).isEqualTo(27)
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "이상준", age = 27)
        assertThat(person.nickname).isEqualTo("이상준")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "이상준", age = 27)
        person1.temp = 2
        val person2 = Person(name = "이상준", age = 27)
        person2.temp = 4
        assertThat(person1).isEqualTo(person2)
        assertThat(person1.temp).isEqualTo(2)
    }
}
