package domain.step3.domain.game

import domain.step3.domain.racingcar.DistanceDriven
import domain.step3.domain.racingcar.RacingCar
import domain.step3.domain.racingcar.RacingCars
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarGameRecordTest {

    @Test
    fun `자동차들의 현재 상태 정보가 들어온다`() {
        val movingStrategy = { true }
        val numberOfCars = 1
        val expected = RacingCarGameRecord(listOf(
            RacingCars((listOf(RacingCar(DistanceDriven(1), movingStrategy)))),
            RacingCars((listOf(RacingCar(DistanceDriven(2), movingStrategy)))),
        ))

        var racingCars = RacingCars.from(numberOfCars, movingStrategy)
        var gameRecord = RacingCarGameRecord.initialize()

        racingCars =  racingCars.moveForward()
        gameRecord = gameRecord.add(racingCars)

        racingCars =  racingCars.moveForward()
        gameRecord = gameRecord.add(racingCars)

        assertAll(
            { assertThat(gameRecord).hasSameHashCodeAs(expected) },
            { assertThat(gameRecord).isEqualTo(expected) }
        )
    }
}