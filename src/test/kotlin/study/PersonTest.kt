package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun test() {
        val personOne = Person("배진섭", 34, "아자르")
        val personTwo = Person(nickname = "tiny", name = "오세기", age = 34)
        assertThat(personOne.name).isEqualTo("배진섭")
        assertThat(personTwo.name).isEqualTo("오세기")
    }

    @Test
    fun `널 타입`() {
        val personOne = Person("배진섭", 34, null)
        assertThat(personOne.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val personOne = Person("배진섭", 34)
        assertThat(personOne.nickname).isEqualTo(personOne.name)
    }

    @Test
    fun `데이터 클래스`() {
        val personOne = Person("배진섭", 34, "아자르")
        val personTwo = Person("배진섭", 34, "아자르")
        assertThat(personOne).isEqualTo(personTwo)
    }

    @Test
    fun `복사`() {
        val personOne = Person("배진섭", 34, "아자르")
        val personTwo = personOne.copy(nickname = null)
        assertThat(personOne.nickname).isEqualTo("아자르")
        assertThat(personTwo.nickname).isNull()
    }
}
