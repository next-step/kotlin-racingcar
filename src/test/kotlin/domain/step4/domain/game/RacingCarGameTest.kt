package domain.step4.domain.game

import domain.step4.domain.configuration.NumberOfAttempts
import domain.step4.domain.configuration.RacingCarConfiguration
import domain.step4.domain.racingcar.Names
import domain.step4.domain.racingcar.RacingCars
import domain.step4.domain.strategy.MovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingCarGameTest {

    @ParameterizedTest(name = "자동차 대수 : {0}, 실행 횟수 : {1}")
    @CsvSource(value = ["a:1", "a,b:2", "a,b,c:3", "a,b,c,d:4"], delimiter = ':')
    fun `자동차 n대를 m번에 움직인 후 위치 확인`(namesString: String, numberOfAttempts: Int) {
        val names = Names.ofStringWithSplitStrategy(namesString) { it.split(",") }
        val numberOfAttempts = NumberOfAttempts(numberOfAttempts)
        val racingCarConfiguration = RacingCarConfiguration(names, numberOfAttempts)
        val movingStrategy = MovingStrategy { true }

        var expected = RacingCarGameRecord.initialize()
        var racingCars = RacingCars.from(names, movingStrategy)

        (1..numberOfAttempts.numberOfAttempts).map {
            racingCars = racingCars.moveForward()
            expected = expected.add(racingCars)
        }

        val actual = RacingCarGame(racingCarConfiguration, movingStrategy).run()
        assertThat(actual).isEqualTo(expected)
    }
}
