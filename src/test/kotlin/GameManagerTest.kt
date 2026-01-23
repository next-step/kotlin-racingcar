import game.car.Car
import game.manager.GameManager
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
            gameManager.moveOrNot(car)
        }

        // Then
        assertThat(car.position).isEqualTo(movingCount)
    }


}
