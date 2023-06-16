package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import racing.InputParser

class RacingGameTest : AnnotationSpec() {

    @Test
    fun `자동차가 한대 이상일 경우 경기를 진행할 수 있다 없는 경우 진행 불가`() {
        val carNames = "pobi,crong,honux"
        val cars = InputParser.parse(carNames).map { Car(it) }
        RacingGame.raceStart(cars)

        shouldThrow<IllegalArgumentException> {
            RacingGame.raceStart(listOf())
        }
    }
}
