package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.domain.RacingGameCarFactory
import racingcar.domain.RandomNumberGenerator

class RacingGameCarFactoryTest {

    @Test
    fun `check generated cars count by names`() {
        val carNames = listOf("car1", "car2", "car3")
        val cars = RacingGameCarFactory.createRandomDriveCars(
            carNames = carNames,
            randomNumberGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1),
            minDriveRandomNumber = 1,
        )

        Assertions.assertThat(cars).hasSize(3)
    }
}
