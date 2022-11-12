package racingcar.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    private val car = Car()

    @ParameterizedTest
    @ValueSource(ints = [4, 5, Int.MAX_VALUE])
    fun `move when randomNumber greater and equal then 4`(randomNumber: Int) {
        car.move(randomNumber)

        car.moveStep.count() shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 3, Int.MIN_VALUE])
    fun `no move when randomNumber less then 4`(randomNumber: Int) {
        car.move(randomNumber)

        car.moveStep.count() shouldBe 0
    }
}
