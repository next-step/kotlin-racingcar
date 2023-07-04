package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "asdfg"])
    fun `문자열을 받아 자동차 이름을 생성한다`(name: String) {
        val carName = CarName(name)

        carName.value shouldBe name
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "asdfgh"])
    fun `자동차 이름은 1자 이상, 5자 이하가 아니면 예외가 발생한다`(name: String) {
        shouldThrow<IllegalArgumentException> {
            CarName(name)
        }
    }
}
