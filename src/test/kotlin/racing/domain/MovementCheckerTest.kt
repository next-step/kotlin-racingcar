package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.random.TestRandomWrapper

internal class MovementCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun isMovable_true(returnValueOfRandom: Int) {
        val movementChecker = MovementChecker(TestRandomWrapper(returnValueOfRandom))
        assertThat(movementChecker.isMovable()).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun isMovable_false(returnValueOfRandom: Int) {
        val movementChecker = MovementChecker(TestRandomWrapper(returnValueOfRandom))
        assertThat(movementChecker.isMovable()).isFalse()
    }
}
