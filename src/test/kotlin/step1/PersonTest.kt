package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 *
 * @author Leo
 */
class PersonTest {

    private val name = "fistkim101"
    private val age = 50
    private val nickName = "fist"

    @Test
    fun `입력한 인자의 값으로 객체가 생성 되었는지 검증`() {
        val person = Person(name = name, age = age, nickName = nickName)

        assertThat(person.name).isEqualTo(name)
        assertThat(person.age).isEqualTo(age)
        assertThat(person.nickName).isEqualTo(nickName)
    }

    @Test
    fun `nullable 인자 입력시 객체가 생성 되는지 검증`() {
        val person = Person(name = name, age = age, nickName = null)

        assertThat(person.nickName).isNull()
    }

    @Test
    fun `default 인자 이용해서 생성 되는지 검증`() {
        val person = Person(name = name, age = age)

        assertThat(person.nickName).isEqualTo(person.name)
    }

    @Test
    fun `객체간 비교 되는지 검증`() {
        val person1 = Person(name = name, age = age, nickName = nickName)
        val person2 = Person(name = name, age = age, nickName = nickName)

        assertThat(person1).isEqualTo(person2)
    }
}
