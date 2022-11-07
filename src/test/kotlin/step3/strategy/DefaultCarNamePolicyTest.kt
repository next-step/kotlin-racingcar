package step3.strategy

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import step3.domain.car.policy.CarNamePolicy
import step3.domain.car.policy.DefaultCarNamePolicy

class DefaultCarNamePolicyTest {
    companion object {
        @JvmStatic
        fun validCarNameLengthRange() = (5..20)

        @JvmStatic
        fun invalidCarNameLengthRange() = (0..4).map { Arguments.of(it) }.stream()

        @JvmStatic
        fun randomCharacter(): Char = (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()

        @JvmStatic
        fun generateCarName(carNameLength: Int): String = buildString {
            repeat(carNameLength) {
                append(randomCharacter())
            }
        }
    }

    private lateinit var carNamePolicy: CarNamePolicy

    @BeforeEach
    fun beforeTest() {
        carNamePolicy = DefaultCarNamePolicy
    }

    @ParameterizedTest
    @MethodSource("validCarNameLengthRange")
    fun `길이가 5이상인 이름은 유효하다`(carNameLength: Int) {
        val carName = generateCarName(carNameLength)

        // println(carName)
        carNamePolicy.isValidName(carName) shouldBe true
    }

    @ParameterizedTest
    @MethodSource("invalidCarNameLengthRange")
    fun `길이가 4이하인 이름은 유효하지 않다`(carNameLength: Int) {
        val carName = generateCarName(carNameLength)

        // println(carName)
        carNamePolicy.isValidName(carName) shouldBe false
    }

    @ParameterizedTest
    @MethodSource(value = ["validCarNameLengthRange", "invalidCarNameLengthRange"])
    fun `default CarNamePolicy 의 경우, 모든 길이의 이름이 유효하다`(carNameLength: Int) {
        val carName = generateCarName(carNameLength)

        val anonymousCarNamePolicy: CarNamePolicy = object : CarNamePolicy {}

        anonymousCarNamePolicy.isValidName(carName) shouldBe true
    }
}
