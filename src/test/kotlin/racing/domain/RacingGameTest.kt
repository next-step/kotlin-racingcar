package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.components.MovementChecker
import racing.components.RacingGame
import racing.components.RandomWrapper
import kotlin.random.Random

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun `constructor test`(carCount: Int) {
        val racingGame = RacingGame(carCount, MovementChecker())
        assertThat(racingGame.carList.size).isEqualTo(carCount)
    }

    @Test
    fun `항상 전진하는 경우 moveAllCar 테스트 (랜덤 넘버가 항상 4이상 9이하인 경우)`() {
        val randomWrapper = RandomWrapper(true, Random.nextInt(4, 9))
        val racingGame = RacingGame(3, MovementChecker(randomWrapper))

        racingGame.moveAllCar()
        assertThat(racingGame.carList).extracting("position").containsOnly(1)

        racingGame.moveAllCar()
        assertThat(racingGame.carList).extracting("position").containsOnly(2)

        racingGame.moveAllCar()
        assertThat(racingGame.carList).extracting("position").containsOnly(3)
    }

    @Test
    fun `항상 멈춰있는 경우 moveAllCar 테스트 (랜덤 넘버가 항상 0이상 3이하인 경우)`() {
        val randomWrapper = RandomWrapper(true, Random.nextInt(0, 3))
        val racingGame = RacingGame(3, MovementChecker(randomWrapper))

        racingGame.moveAllCar()
        assertThat(racingGame.carList).extracting("position").containsOnly(0)
    }

    @Test
    fun `getCarPositions 테스트`() {
        val randomWrapper = RandomWrapper(false)
        val racingGame = RacingGame(3, MovementChecker(randomWrapper))

        racingGame.carList[0].position = 2
        racingGame.carList[1].position = 7
        racingGame.carList[2].position = 4

        val carPositions = racingGame.getCarPositions()
        assertThat(carPositions).containsExactly(2, 7, 4)
    }
}
