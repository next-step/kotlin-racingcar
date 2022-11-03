package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "장윤철", age = 27, nickname = "jang1231111")
        assertThat(person.name).isEqualTo("장윤철")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo("jang1231111")
    }

    @Test
    fun `널 타입`() {
        val person = Person("장윤철", 27, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("장윤철", 27,)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("장윤철", 27)
        val person2 = Person("장윤철", 27)
        assertThat(person1).isEqualTo(person2)
    }
}
