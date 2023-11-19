package racing.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.Car
import kotlin.random.Random

class GameTest {

    private val randomLimit = 10

    @Test
    fun `모든 자동차들이 참여한다`() {
        val cars = listOf(Car("우진"), Car("지훈"))
        val game = Game(cars)
        val conditions = cars.map { Random.nextInt(randomLimit) }
        val result = game.run(conditions)
        assertThat(result.size).isEqualTo(cars.size)
    }

    @Test
    fun `우승자는 한명 또는 여러명일 수 있다`() {
        val cars = listOf(Car("1번"), Car("2번"), Car("3번"), Car("4번"), Car("5번"), Car("6번"))
        val game = Game(cars)
        val conditions = cars.map { Random.nextInt(randomLimit) }
        val tryCount = 100
        repeat(tryCount) {
            game.run(conditions)
        }
        val winners = game.end()
        assertThat(winners.size).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(cars.size)
    }
}
