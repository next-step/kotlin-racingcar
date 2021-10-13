package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BasicTest {
    companion object {
        @JvmStatic
        @BeforeAll
        fun initAll() {
            println("initAll")
        }

        @JvmStatic
        @AfterAll
        fun tearDownAll() {
            println("tearDownAll")
        }
    }

    @BeforeEach
    fun init() {
        println("init")
    }

    @AfterEach
    fun tearDown() {
        println("tearDown")
    }

    @Test
    fun `이름 붙인 인자 & 순서 상관 X`() {
        val person = Person(name = "김병준", nickname = "bangjom", age = 27)
        val person1 = Person(name = "김병준", age = 27, nickname = "bangjom")

        assertThat(person.age).isEqualTo(27)
        assertThat(person.nickname).isEqualTo(person1.nickname)
    }

    @Test
    fun `기본 인자`() {
        val person = DefaultNullPerson(name = "김병준", nickname = "bangjom")

        assertThat(person.age).isEqualTo(20)
    }

    @Test
    fun `널 타입 가능`() {
        val person = DefaultNullPerson(name = "김병준", nickname = null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = DataPerson(name = "김병준", age = 27, nickname = "bangjom")
        val person2 = DataPerson(name = "김병준", age = 27, nickname = "bangjom")

        assertThat(person1).isEqualTo(person2)
    }
}
