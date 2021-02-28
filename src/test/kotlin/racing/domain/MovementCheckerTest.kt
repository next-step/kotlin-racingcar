package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.components.MovementChecker
import racing.components.RandomWrapper

internal class MovementCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun goodToMove_true(returnValueOfRandom: Int) {
        val movementChecker = MovementChecker(RandomWrapper(true, returnValueOfRandom))
        assertThat(movementChecker.goodToMove()).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun goodToMove_false(returnValueOfRandom: Int) {
        val movementChecker = MovementChecker(RandomWrapper(true, returnValueOfRandom))
        assertThat(movementChecker.goodToMove()).isFalse()
    }
}
