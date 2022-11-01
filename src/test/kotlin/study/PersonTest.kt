package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "조수진", age = 32, nickname = "쪼밀리")
        assertThat(person.name).isEqualTo("조수진")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo("쪼밀리")
    }
}
