import game.car.Car
import game.manager.GameManager
import game.manager.MOVE_THRESHOLD
import game.randomnumbergenerator.RandomNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FakeRandomNumberGenerator(
    private val numbers:
    List<Int>
) : RandomNumberGenerator {
    private var index = 0

    override fun generate(): Int {
        val result = numbers[index]
        index = (index + 1) % numbers.size
        return result
    }
}

fun createGameManager(
    carsCount: Int = 10,
    RandomNumberGenerator: RandomNumberGenerator
): GameManager {
    val cars = List(carsCount) { Car(position = 0) }

    return GameManager(cars, RandomNumberGenerator)
}

class GameManagerTest {
    @Test
    fun 게임_매니저를_생성한다() {
        val gameManager = createGameManager(RandomNumberGenerator = FakeRandomNumberGenerator(listOf(10)))

        assertThat(gameManager).isNotNull()
    }

    @Test
    fun 랜덤_숫자에_따라_자동차를_전진시킨다() {
        // Given
        val gameManager = createGameManager(RandomNumberGenerator = FakeRandomNumberGenerator(listOf(10)))
        val car = gameManager.cars[0]
        val movingCount = 3

        // When
        repeat(movingCount) {
            gameManager.tryMove(car)
        }

        // Then
        assertThat(car.position).isEqualTo(movingCount)
    }

    @Test
    fun 라운드_진행시_전체시_모든_자동차가_전진_또는_정지한다() {
        // Given
        val gameManager =
            createGameManager(
                carsCount = 3,
                RandomNumberGenerator = FakeRandomNumberGenerator(
                    listOf(
                        MOVE_THRESHOLD - 1,
                        MOVE_THRESHOLD,
                        MOVE_THRESHOLD + 1
                    )
                )
            )

        // When
        gameManager.playRound()

        // Then
        assertThat(gameManager.cars[0].position).isEqualTo(0)
        assertThat(gameManager.cars[1].position).isEqualTo(1)
        assertThat(gameManager.cars[2].position).isEqualTo(1)
    }

    @Test
    fun 여러_라운드_진행() {
        // Given
        val gameManager =
            createGameManager(
                carsCount = 3,
                RandomNumberGenerator = FakeRandomNumberGenerator(
                    listOf(
                        MOVE_THRESHOLD - 1,
                        MOVE_THRESHOLD,
                        MOVE_THRESHOLD + 1
                    )
                )
            )
        val roundsCount = 10

        // When
        gameManager.playRounds(round = roundsCount)

        // Then
        assertThat(gameManager.cars[0].position).isEqualTo(0)
        assertThat(gameManager.cars[1].position).isEqualTo(10)
        assertThat(gameManager.cars[2].position).isEqualTo(10)
    }
}
