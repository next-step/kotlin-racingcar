package domain.step3.domain.game

import domain.step3.domain.configuration.NumberOfAttempts
import domain.step3.domain.configuration.NumberOfCars
import domain.step3.domain.configuration.RacingCarConfiguration
import domain.step3.domain.racingcar.DistanceDriven
import domain.step3.domain.racingcar.RacingCar
import domain.step3.domain.racingcar.RacingCars
import domain.step3.domain.strategy.MovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingCarGameTest {

    @ParameterizedTest(name = "자동차 대수 : {0}, 실행 횟수 : {1}")
    @CsvSource(value = ["1:1", "2:2", "3:5", "5:3"], delimiter = ':')
    fun `자동차 n대를 m번에 움직인 후 위치 확인`(numberOfCars: Int, numberOfAttempts: Int) {
        val racingCarConfiguration =
            RacingCarConfiguration(NumberOfCars(numberOfCars), NumberOfAttempts(numberOfAttempts))
        val movingStrategy = MovingStrategy { true }

        var expected = RacingCarGameRecord.initialize()
        var racingCars = RacingCars(
            (1..numberOfCars).map { RacingCar(DistanceDriven(), movingStrategy) }
                .toList()
        )

        (1..numberOfAttempts).map {
            racingCars = racingCars.moveForward()
            expected = expected.add(racingCars)
        }

        val actual = RacingCarGame(racingCarConfiguration, movingStrategy).run()
        assertThat(actual).isEqualTo(expected)
    }
}
