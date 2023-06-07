package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("김진억", 39, "제이든"),
            Person("김진억", 39, nickname = "제이든"),
            Person(name = "김진억", nickname = "제이든", age = 39)
        )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김진억")
            assertThat(it.age).isEqualTo(39)
            assertThat(it.nickname).isEqualTo("제이든")
        }
    }
}
