package domain.step4.domain.game

import domain.step4.domain.racingcar.DistanceDriven
import domain.step4.domain.racingcar.Name
import domain.step4.domain.racingcar.Names
import domain.step4.domain.racingcar.RacingCar
import domain.step4.domain.racingcar.RacingCars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingCarGameRecordTest {

    @Test
    fun `자동차들의 현재 상태 정보가 들어온다`() {
        val movingStrategy = { true }
        val name = Name("name")
        val expected = RacingCarGameRecord.of(
            listOf(
                RacingCars.of((listOf(RacingCar(name, DistanceDriven(1), movingStrategy)))),
                RacingCars.of((listOf(RacingCar(name, DistanceDriven(2), movingStrategy)))),
            )
        )

        var racingCars = RacingCars.from(Names.ofList(listOf(name)), movingStrategy)
        var gameRecord = RacingCarGameRecord.initialize()

        racingCars = racingCars.moveForward()
        gameRecord = gameRecord.add(racingCars)

        racingCars = racingCars.moveForward()
        gameRecord = gameRecord.add(racingCars)

        assertAll(
            { assertThat(gameRecord).hasSameHashCodeAs(expected) },
            { assertThat(gameRecord).isEqualTo(expected) }
        )
    }
}
