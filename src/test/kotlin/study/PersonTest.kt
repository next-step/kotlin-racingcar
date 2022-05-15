package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("조성륜", 23, "빠삐코"), Person("조성륜", 23, nickname = "빠삐코"), Person(name = "조성륜", age = 23, nickname = "빠삐코")
        )

        // 리스트에 있는 것들이 전부 만족해야 함.
        assertThat(people[0].name).isEqualTo("조성륜")
        assertThat(people[1].name).isEqualTo("조성륜")
        assertThat(people[2].name).isEqualTo("조성륜")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "조성륜", age = 23)
        assertThat(person.name).isEqualTo("조성륜")
        assertThat(person.age).isEqualTo(23)
    }

    @Test
    fun `기본 인자`() {
        val person = Person("조성륜", 23)
        assertThat(person.name).isEqualTo("조성륜")
        assertThat(person.age).isEqualTo(23)
        assertThat(person.nickname).isEqualTo("조성륜")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("조성륜", 23)
        val person2 = Person("조성륜", 23)

        assertThat(person1).isEqualTo(person2)
    }
}
