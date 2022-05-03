package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `널 타입`(      ) {
        val person = Person("엄현식", 10, null)
        assertThat(person.nickname).isNull()
    }
}