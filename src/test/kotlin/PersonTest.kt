import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PersonTest {

    @BeforeEach
    fun beforeEachTest() {
        println("before Each")
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAllTest() {
            println("before All")
        }

        @JvmStatic
        @AfterAll
        fun afterAll() {
            println("after All")
        }
    }

    @AfterEach
    fun afterEach() {
        println("after Each")
    }

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이정환", age = 31, nickname = "열정환")
        assertThat(person.name).isEqualTo("이정환")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isEqualTo("열정환")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "이정환", age = 31, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "이정환", age = 31)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이정환", 31)
        val person2 = Person("이정환", 31)
        assertThat(person1).isEqualTo(person2)
    }
}
