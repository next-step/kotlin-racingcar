package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        var people = listOf(
            Person("정지선", 35, "케이라"), Person("정지선", 35, nickname = "케이라"), Person(name = "정지선", age = 35, nickname = "케이라")
        )

        assertThat(people[0].name).isEqualTo("정지선")
        assertThat(people[1].name).isEqualTo("정지선")
        assertThat(people[2].name).isEqualTo("정지선")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "정지선", age = 35, nickname = null)
        assertThat(person.name).isEqualTo("정지선")
        assertThat(person.age).isEqualTo(35)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("정지선", 35, nickname = "케이라")
        assertThat(person.name).isEqualTo("정지선")
        assertThat(person.age).isEqualTo(35)
        assertThat(person.nickname).isEqualTo("케이라")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("정지선", 35)
        val person2 = Person("정지선", 35)

        assertThat(person1).isEqualTo(person2)
    }
}
