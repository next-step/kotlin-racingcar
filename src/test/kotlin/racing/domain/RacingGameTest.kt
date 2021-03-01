package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.random.TestRandomWrapper
import kotlin.random.Random

class RacingGameTest {

    private val testCarNames = listOf("pobi", "crong", "honux")

    @Test
    fun `constructor test`() {
        val racingGame = RacingGame(testCarNames, MovementChecker())
        assertThat(racingGame.cars.size).isEqualTo(testCarNames.size)
        assertThat(racingGame.cars).extracting("name").containsAll(testCarNames)
    }

    @Test
    fun `항상 전진하는 경우 moveAllCar 테스트 (랜덤 넘버가 항상 4이상 9이하인 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(4, 9))
        val racingGame = RacingGame(testCarNames, MovementChecker(randomWrapper))

        racingGame.moveAllCar()
        assertThat(racingGame.cars).extracting("position").containsOnly(1)

        racingGame.moveAllCar()
        assertThat(racingGame.cars).extracting("position").containsOnly(2)

        racingGame.moveAllCar()
        assertThat(racingGame.cars).extracting("position").containsOnly(3)
    }

    @Test
    fun `항상 멈춰있는 경우 moveAllCar 테스트 (랜덤 넘버가 항상 0이상 3이하인 경우)`() {
        val randomWrapper = TestRandomWrapper(Random.nextInt(0, 3))
        val racingGame = RacingGame(testCarNames, MovementChecker(randomWrapper))

        racingGame.moveAllCar()
        assertThat(racingGame.cars).extracting("position").containsOnly(0)
    }

    @Test
    fun `get winner 테스트(winner가 하나)`() {

        val racingGame = RacingGame(testCarNames, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars[0].moveCar()
        }

        repeat(3) {
            cars[1].moveCar()
        }

        repeat(1) {
            cars[2].moveCar()
        }

        assertThat(racingGame.getWinners()).containsOnly(cars[1])
    }

    @Test
    fun `get winner 테스트(winner가 둘)`() {

        val racingGame = RacingGame(testCarNames, MovementChecker())
        val cars = racingGame.cars

        repeat(2) {
            cars[0].moveCar()
        }

        repeat(2) {
            cars[1].moveCar()
        }

        repeat(1) {
            cars[2].moveCar()
        }

        assertThat(racingGame.getWinners()).containsOnly(cars[0], cars[1])
    }
}
