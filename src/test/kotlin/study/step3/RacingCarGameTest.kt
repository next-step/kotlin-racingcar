package study.step3

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarGameTest {

    @Test
    fun `입력한 자동차 대수만큼 자동차들이 준비되었는지 확인`() {
        val actualInputCarCount = 3
        val actualRacingRequest = RacingRequest(actualInputCarCount, 5)
        val game = RacingCarGame(actualRacingRequest, CarRandomMove())
        game.play(actualRacingRequest)

        assertThat(game.getCurrentCars().size).isEqualTo(3)
    }

    @Test
    fun `입력한 시도 횟수만큼 자동차들의 상태가 저장되었는지 확인`() {
        val actualInputTryCount = 5
        val actualRacingRequest = RacingRequest(3, actualInputTryCount)
        val game = RacingCarGame(actualRacingRequest, CarRandomMove())
        game.play(actualRacingRequest)

        game.getCurrentCars().forEach { car ->
            assertThat(car.getStateList().size).isEqualTo(actualInputTryCount)
        }
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `0에서 9사이 무작위 값을 구해 4 이상일 경우 전진`(condition: Int) {
        val actualCar = Car()
        actualCar.move(condition)
        actualCar.getStateList().last() shouldBe 1
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `0에서 9사이 무작위 값을 구해 4 미만일 경우 정지`(condition: Int) {
        val actualCar = Car()
        actualCar.move(condition)
        actualCar.getStateList().last() shouldBe 0
    }
}
