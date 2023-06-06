package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    internal fun `이름 붙인 인자 테스트 코드를 활용할 수 있음`() {
        // given
        val person: Person = Person(name = "이승환", nickname = "goofy", age = 28)
        // then
        assertThat(person.name).isEqualTo("이승환")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("goofy")
    }

    @Test
    internal fun `널 타입 가능한지 확인해본다`() {
        val person = Person(name = "이승환", age = 28, nickname = null)

        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `동등성 테스트는 어떻게 쓰는지 확인해본다`() {
        val person = Person(name = "이승환", age = 28)
        val person2 = Person(name = "이승환", age = 28)

        assertThat(person.nickname).isEqualTo("GUEST")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "MR Hong")
        val person2 = Person("홍길동", 20, "MR Hong")

        assertThat(person1).isEqualTo(person2)
    }
}
