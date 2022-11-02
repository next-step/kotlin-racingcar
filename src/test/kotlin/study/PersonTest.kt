package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    internal fun `이름 붙인 인자`() {
        // when
        val person = Person(name = "김기연", age = 28, nickName = "코린이")

        // then
        assertThat(person.name).isEqualTo("김기연")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickName).isEqualTo("코린이")
    }

    @Test
    internal fun `널 타입`() {
        // when
        val person = Person("김기연", 28, null)

        // then
        assertThat(person.nickName).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        // when
        val person = Person("김기연", 28)

        // then
        assertThat(person.name).isEqualTo(person.nickName)
    }

    @Test
    internal fun `데이터 클래스`() {
        // when
        val person = Person("김기연", 28)

        // then
        assertThat(person).isEqualTo(Person("김기연", 28))
    }
}
