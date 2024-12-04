package racing.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.exception.InvalidCarNameException

class CarValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["이민수", "이창환", "json", "minsu"])
    fun `각 자동차에 이름을 부여할 수 있다`(name: String) {
        val carName = CarValidator.validateNameLength(name)
        carName shouldBe name
    }

    @ParameterizedTest
    @ValueSource(strings = ["이민수루루루", "이창환느느느~", "jsonnnn~", "jacksons~"])
    fun `자동차 이름은 5자를 초과할 수 없다`(name: String) {
        shouldThrow<InvalidCarNameException> {
            CarValidator.validateNameLength(name)
        }.apply {
            message shouldBe "자동차의 이름은 5자를 초과할 수 없습니다."
        }
    }
}
