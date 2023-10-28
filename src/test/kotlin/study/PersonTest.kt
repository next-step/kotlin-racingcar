package study

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("홍길동", 29, "의적"),
            Person("홍길동", 29, nickname = "의적"),
            Person(name = "홍길동", nickname = "의적", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("홍길동")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("의적")
        }
    }
}
