package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test
    internal fun name() {
        val people = listOf(
            Person("정은석", 29, "섭웨"),
            Person(name = "정은석", age = 29, nickname = "섭웨")
        )

        assertThat(people[0].name


        ).isEqualTo("정은석")
        assertThat(people[1].name



        ).isEqualTo("정은석")

        assertAll("people",
            { assertThat(people[0].name).isEqualTo("정은석") },
            { assertThat(people[1].name).isEqualTo("정은석") }
        )
    }
}