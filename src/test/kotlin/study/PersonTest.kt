package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = Person(name = "김범준", nickname = "corby", age = 27)

        assertThat(people.name).isEqualTo("김범준")
        assertThat(people.age).isEqualTo(27)
        assertThat(people.nickname).isEqualTo("corby")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김범준", 27)
        assertThat(person.name).isEqualTo("김범준")
        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김범준", 27, "corby")
        val person2 = Person("김범준", 27, "corby")
        assertThat(person1).isEqualTo(person2)
    }
}
