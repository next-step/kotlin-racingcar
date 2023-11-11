package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingTest : FunSpec({

    test("racing start시 position이 1씩 증가") {
        // Given
        val names: List<String> = listOf("Jiwon", "Alex", "Bob")
        val cars = CarNameMapper.map(names)
        val movable = { true }
        val racing = Racing(cars, 5)

        // When
        racing.startRacing(movable)

        // Then
        for (car in cars) {
            car.position shouldBe 1
        }
    }
})
