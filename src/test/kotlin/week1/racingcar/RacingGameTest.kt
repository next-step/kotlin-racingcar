package week1.racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RacingGameTest {

    @ParameterizedTest
    @MethodSource
    fun `올바른 경주`(inputResult: InputResult) {
        Assertions.assertDoesNotThrow {
            RacingGame().startGame(inputResult)
        }
    }

    companion object {
        @JvmStatic
        fun `올바른 경주`() = listOf(
            Arguments.of(InputResult(listOf("a,b,c"), 5)),
            Arguments.of(InputResult(listOf("a,b,c,d"), 5)),
            Arguments.of(InputResult(listOf("Sam,JAMES,Joe"), 5)),
        )
    }
}
