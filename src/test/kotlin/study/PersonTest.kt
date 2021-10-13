package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PersonTest {
    private lateinit var softly: SoftAssertions

    @BeforeEach
    fun setUp() {
        softly = SoftAssertions()
    }

    @Test
    fun `이름 붙은 인자`() {
        val person1 = Person("고정완", 20, "Pyro")
        val person2 = Person(nickname = "Pyro", name = "고정완", age = 20)
        softly.assertThat(person1.name).isEqualTo(person2.name)
        softly.assertThat(person1.age).isEqualTo(person2.age)
        softly.assertThat(person1.nickname).isEqualTo(person2.nickname)
        softly.assertAll()
    }

    @Test
    fun `널 타입`() {
        val person = Person("고정완", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `primary constructor`() {
        val person = Person("고정완", 20, "Pyro")
        softly.assertThat(person.name).isEqualTo("고정완")
        softly.assertThat(person.age).isEqualTo(20)
        softly.assertThat(person.nickname).isEqualTo("Pyro")
        softly.assertAll()
    }

    @Test
    fun `secondary constructor, 기본 인자`() {
        val person = Person("고정완", 20)
        assertThat(person.nickname).isEqualTo("고정완")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("고정완", 20, "Pyro")
        val person2 = Person("고정완", 20, "Pyro")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("고정완", 20, "Pyro")
        val person2 = person1.copy(nickname = null)
        softly.assertThat(person1.name).isEqualTo("고정완")
        softly.assertThat(person1.age).isEqualTo(20)
        softly.assertThat(person1.nickname).isEqualTo("Pyro")

        softly.assertThat(person2.name).isEqualTo("고정완")
        softly.assertThat(person2.age).isEqualTo(20)
        softly.assertThat(person2.nickname).isEqualTo(null)
        softly.assertAll()
    }
}
