package race

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import race.model.Car

class CarJunitTest {
    @CsvSource("홍길동, 1", "제이슨, 10")
    @ParameterizedTest
    fun `자동차는 이름과 위치를 가진다`(name: String, position: Int) {
        val actual = Car(_name = name, _position = position)
        actual.name shouldBe name
        actual.position shouldBe position
    }

    @Test
    fun `자동차의 이름이 5글자를 넘는 경우 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> {
            Car("alskdjlaskdj")
        }
    }

    @Test
    fun `자동차는 무작위 값이 4 이상일 경우 이동할 수 있다`() {
        val actual = Car(_name = "홍길동")
        actual.move(4)
        actual.position shouldBe 2
    }

    @Test
    fun `자동차는 무작위 값이 4 미만일 경우 정지한다`() {
        var actual = Car(_name = "홍길동")
        actual = actual.move(1)
        actual.position shouldBe 1
    }
}
