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
}
