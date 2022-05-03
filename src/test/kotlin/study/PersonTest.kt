package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("최재성", 28, "링크"),
            Person(name = "최재성", 28, nickname = "링크"),
            Person(name = "최재성", age = 28, nickname = "링크")
        )
        //allSatisfy는 리스트안에 있는 모든것이 조건을 충족해야한다는 뜻. 쓰려다가 뺐음.
        assertThat(people[0].name).isEqualTo("최재성")
        assertThat(people[1].name).isEqualTo("최재성")
        assertThat(people[2].name).isEqualTo("최재성")
    }

    @Test
    fun `널 타입 테스트`() {
        val person = Person("최재성", 28, null)
        assertThat(person.name).isEqualTo("최재성")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("최재성", 28)
        assertAll(
            { assertThat(person.name).isEqualTo("최재성") },
            { assertThat(person.age).isEqualTo(28) },
            { assertThat(person.nickname).isEqualTo("최재성") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최재성", 28)
        val person2 = Person("최재성", 28)
        assertThat(person1).isEqualTo(person2)
    }
}