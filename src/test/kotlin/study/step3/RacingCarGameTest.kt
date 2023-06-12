package study.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarGameTest {

    @Test
    fun `입력한 자동차 대수만큼 자동차들이 준비되었는지 확인`() {
        val actualInputCarCount = 3
        val actualRacingRequest = RacingRequest(actualInputCarCount, 5)
        val game = RacingCarGame()
        game.play(actualRacingRequest)

        assertThat(game.getCurrentCars().size).isEqualTo(3)
    }

    @Test
    fun `입력한 시도 횟수만큼 자동차들의 상태가 저장되었는지 확인`() {
        val actualInputTryCount = 5
        val actualRacingRequest = RacingRequest(3, actualInputTryCount)
        val game = RacingCarGame()
        game.play(actualRacingRequest)

        game.getCurrentCars().forEach { car ->
            assertThat(car.stateList.size).isEqualTo(actualInputTryCount)
        }
    }

    @Test
    fun `0에서 9사이 무작위 값을 구해 4 이상일 경우 전진`() {
        val actualCar = Car()
        val randomValue = RandomGenerator().generateRandomValue()

        actualCar.move(randomValue >= 4)
        if (randomValue >= 4) {
            assertThat(actualCar.stateList.last()).isEqualTo(1)
        }
    }
}
