package racingcar

import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.RandomMoveStrategy

class RacingGameTest {

    private val racingGame = RacingGame.of(NUM_OF_CARS, NUM_OF_ATTEMPTS)

    @Test
    fun `NUM_OF_CARS 대의 차가 NUM_OF_ATTEMPTS 만큼 1칸씩 전진할 경우`() {
        // given
        mockkObject(RandomMoveStrategy)
        every { RandomMoveStrategy.isMovable() } returns true
        val cars = racingGame.racingCars

        // when
        racingGame.start()

        // then
        cars.forEach {
            assertEquals(NUM_OF_ATTEMPTS, it.location)
        }
    }

    @Test
    fun `NUM_OF_CARS 대의 차가 NUM_OF_ATTEMPTS 만큼 모두 멈춰있을 경우`() {
        // given
        mockkObject(RandomMoveStrategy)
        every { RandomMoveStrategy.isMovable() } returns false
        val cars = racingGame.racingCars

        // when
        racingGame.start()

        // then
        cars.forEach {
            assertEquals(0, it.location)
        }
    }

    companion object {
        private const val NUM_OF_CARS = 3
        private const val NUM_OF_ATTEMPTS = 5
    }
}