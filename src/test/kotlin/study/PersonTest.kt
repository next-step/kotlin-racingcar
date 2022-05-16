package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("엄기훈", 33, "치즈아부지"),
            Person("엄기훈", 33, nickname = "치즈아부지"),
            Person(name = "엄기훈", age = 33, nickname = "치즈아부지")
        )
        assertThat(people[0].name).isEqualTo("엄기훈")
        assertThat(people[1].name).isEqualTo("엄기훈")
        assertThat(people[2].name).isEqualTo("엄기훈")
    }

    @Test
    fun `널 타입`() {
        val person = Person("엄기훈", 33, null)
        assertThat(person.name).isEqualTo("엄기훈")
        assertThat(person.age).isEqualTo(33)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("엄기훈", 33)
        assertThat(person.name).isEqualTo("엄기훈")
        assertThat(person.age).isEqualTo(33)
        assertThat(person.nickname).isEqualTo("엄기훈")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("엄기훈", 33)
        val person2 = Person("엄기훈", 33)
        assertThat(person1).isEqualTo(person2)
    }

}

