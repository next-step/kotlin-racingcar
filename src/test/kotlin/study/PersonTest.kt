package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 인자`() {
        val persons = listOf(
            Person("고유식", 99, "제이드"),
            Person("고유식", 99, nickname = "제이드"),
        )

        assertThat(persons[0].name).isEqualTo("고유식")
        assertThat(persons[1].nickname).isEqualTo("제이드")
    }

    @Test
    fun `데이터 클라스`() {
        val person1 = Person("jade", 99)
        val person2 = Person("jade", 99)

        assertThat(person1).isEqualTo(person2)
    }
}