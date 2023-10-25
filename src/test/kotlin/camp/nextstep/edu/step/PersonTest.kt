package camp.nextstep.edu.step

import camp.nextstep.edu.step.person.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("코틀린 테스트 시")
class PersonTest {

    @Test
    fun `이름을 붙인 인자를 통해 테스트가 가능하다`() {
        // given
        val name = "김의빈"
        val age = 20
        val nickName = "Joekim"

        // when
        val people = listOf(
            Person(name, age, nickName),
            Person(name, age = age, nickName = nickName),
            Person(name = name, age = age, nickName = nickName),
        )

        // then
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo(name)
            assertThat(it.age).isEqualTo(age)
            assertThat(it.nickName).isEqualTo(nickName)
        }
    }

    @Test
    fun `null 타입 테스트가 가능하다`() {
        //given
        val name = "김의빈"
        // when
        val person = Person(name, age = null, nickName = null)

        // then
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickName).isNull() }
        )
    }

    @Test
    fun `기본 인자를 통해 테스트가 가능하다`() {
        //given
        val name = "김의빈"
        // when
        val person = Person(name)

        // then
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickName).isNull() }
        )
    }

    @Test
    fun `데이터 클래스 테스트가 가능하다`() {
        // given
        val person1Name = "김의빈"
        val person1Age = 20
        val person1NickName = "Joekim"

        val person2Name = "김성빈"
        val person2Age = 20
        val person2NickName = "Sungbin"

        // when
        val person1 = Person(name = person1Name, age = person1Age, nickName = person1NickName)
        val person2 = Person(name = person2Name, age = person2Age, nickName = person2NickName)

        // then
        assertThat(person1).isNotEqualTo(person2)
    }

}