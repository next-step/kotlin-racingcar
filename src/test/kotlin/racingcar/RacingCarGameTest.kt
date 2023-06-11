package racingcar

import io.kotest.assertions.throwables.shouldThrow
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingCarGameTest {

    lateinit var racingCarGame: RacingCarGame

    @BeforeEach
    fun setup() {
        racingCarGame = RacingCarGame()
    }

    @Test
    fun `complete game`() {
        val totalRound: Long = 3
        val alwaysOneGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1)
        val minDriveRandomNumber: Long = 1
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = alwaysOneGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            name = "name",
        )

        val result = racingCarGame.progressGame(totalRound = totalRound, cars = listOf(car))

        val rounds = result.map { it.round }.toSet()
        val carNumbers = result.map { it.carDriveResults }.flatten().map { it.carNumber }.toSet()

        assertThat(rounds).hasSize(totalRound.toInt())
        assertThat(carNumbers).hasSize(1)
    }

    @Test
    fun `invalid total round`() {
        val totalRound: Long = 0
        val alwaysOneGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1)
        val minDriveRandomNumber: Long = 1
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = alwaysOneGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            name = "12345",
        )

        shouldThrow<IllegalArgumentException> {
            racingCarGame.progressGame(totalRound = totalRound, cars = listOf(car))
        }
    }

    @Test
    fun `invalid total car count`() {
        val totalRound: Long = 3

        shouldThrow<IllegalArgumentException> {
            racingCarGame.progressGame(totalRound = totalRound, cars = emptyList())
        }
    }

    @Test
    fun `exceed car name length`() {
        val totalRound: Long = 0
        val alwaysOneGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1)
        val minDriveRandomNumber: Long = 1
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = alwaysOneGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            name = "123456",
        )

        shouldThrow<IllegalArgumentException> {
            racingCarGame.progressGame(totalRound = totalRound, cars = listOf(car))
        }
    }
}
