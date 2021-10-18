package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름을 넣은 인자`() {
        val person1 = Person("김형준", 29, "플람")
        val person2 = Person(age = 29, name = "김형준", nickname = "플람")
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("김형준", 29, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김형준", 29)
        assertThat(person.nickname).isEqualTo("김형준")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김형준", 29, "플람")
        val person2 = Person("김형준", 29, "플람")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("김형준", 29, "플람")
        val person2 = person1.copy(nickname = null)
        assertThat(person1.nickname).isEqualTo("플람")
        assertThat(person2.nickname).isNull()
    }
}
