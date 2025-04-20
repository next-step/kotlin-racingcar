package carracing.game.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `when validateCarNames has valid input should return car names`() {
        listOf("c1,c2", "c1,c2,c3").forEach {
            InputValidator.validateCarNames(it) shouldBe it.split(',')
        }
    }

    @Test
    fun `when validateCarNames has invalid input should throw exception`() {
        listOf("c1:c2", null).forEach {
            val e = shouldThrowExactly<IllegalArgumentException> { InputValidator.validateCarNames(it) }
            e.message shouldBe "Cars amount should be at least $MIN_CARS_AMOUNT"
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2"])
    fun `when validateRoundsAmount has valid input should return rounds`(input: String) {
        InputValidator.validateRoundsAmount(input) shouldBe input.toInt()
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "abc"])
    @NullSource
    fun `when validateRoundsAmount has invalid input should throw exception`(input: String?) {
        val e = shouldThrowExactly<IllegalArgumentException> { InputValidator.validateRoundsAmount(input) }
        e.message shouldBe "Rounds amount should be at least $MIN_ROUNDS_AMOUNT"
    }
}
