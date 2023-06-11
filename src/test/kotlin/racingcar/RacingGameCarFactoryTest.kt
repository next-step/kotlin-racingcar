package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingGameCarFactoryTest {

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "3, 3",
        "5, 5",
        "100, 100"
    )
    fun `check generated cars count`(totalCarCount: Long, expected: Long) {
        val cars = RacingGameCarFactory.createRandomDriveCars(
            totalCarCount = totalCarCount,
            randomNumberGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1),
            minDriveRandomNumber = 1,
        )

        Assertions.assertThat(cars).hasSize(expected.toInt())
    }
}
