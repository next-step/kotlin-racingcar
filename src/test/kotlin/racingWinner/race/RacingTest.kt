package racingWinner.race

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingTest {
    @Test
    fun `racing prepare시 position은 0으로 초기화`() {
        // Given
        val names: List<String> = listOf("Jiwon", "Alex", "Bob")

        // When
        val cars = Racing.prepareRacing(names)

        // Then
        for (car in cars) {
            car.position shouldBe 0
        }
    }

    @Test
    fun `racing start시 position이 1씩 증가`() {
        // Given
        val names: List<String> = listOf("Jiwon", "Alex", "Bob")
        val cars = Racing.prepareRacing(names)
        val movable = { true }

        // When
        Racing.startRacing(cars, movable)

        // Then
        for (car in cars) {
            car.position shouldBe 1
        }
    }
}
