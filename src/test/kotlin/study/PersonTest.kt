package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Suppress("NonAsciiCharacters")
internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김대겸", 29, "대겸"),
            Person("김대겸", 29, nickname = "대겸"),
            Person(name = "김대겸", nickname = "대겸", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김대겸")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("대겸")
        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("김대겸", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김대겸") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김대겸", 29)
        assertAll(
            { assertThat(person.name).isEqualTo("김대겸") },
            { assertThat(person.age).isEqualTo(29) },
            { assertThat(person.nickname).isNotNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
