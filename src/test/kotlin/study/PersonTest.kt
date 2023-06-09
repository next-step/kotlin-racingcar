package study

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(
            name = "홍길동",
            nickname = "Hong",
            age = 20
        )
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.nickname).isEqualTo("Hong")
        assertThat(actual.age).isEqualTo(20)
    }

    @Test
    fun `널 타입`() {
        val actual = Person(
            name = "홍길동",
            nickname = null,
            age = 20
        )
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(
            name = "홍길동",
            age = 20
        )
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(
            name = "홍길동",
            nickname = "Hong",
            age = 20
        )

        val person2 = Person(
            name = "홍길동",
            nickname = "Hong",
            age = 20
        )
        assertThat(person1).isEqualTo(person2)
    }
}
