package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.carracer.MockCarRacer

internal class RacingCarTest : AnnotationSpec() {

    @ParameterizedTest
    @CsvSource(value = ["0,0", "3,0", "4,1", "9,1"])
    fun move(accepted: Int, expected: Int) {
        // given
        val racingCar = RacingCar(MockCarRacer(accepted))

        // when
        racingCar.move()

        // then
        racingCar.movement shouldBe expected
    }
}
