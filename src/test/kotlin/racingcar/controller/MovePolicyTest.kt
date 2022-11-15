package racingcar.controller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MovePolicyTest {

    @ParameterizedTest
    @ValueSource(ints = intArrayOf(4, 5, 6, 7, 8, 9, 100))
    fun `decide return 1 if condition is equal or bigger than 4`(value: Int) {
        MovePolicy.decide(value) shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(ints = intArrayOf(-100, 0, 1, 2, 3))
    fun `decide return 0 if condition is smaller than 4`(value: Int) {
        MovePolicy.decide(value) shouldBe 0
    }
}
