package racing.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RacingTest : FunSpec({
    test("racing prepare시 position은 0으로 초기화") {
        // Given
        val cars = listOf(Car("Jiwon"), Car("Alex"), Car("Bob"))

        // When
        val racing = Racing(cars)

        // Then
        for (car in racing.cars) {
            car.position shouldBe 0
        }
    }

    test("racing start시 movable flase면 정지") {
        // Given
        val names: List<String> = listOf("Jiwon", "Alex", "Bob")
        val cars = CarNameMapper.map(names)
        val movable = { false }
        val racing = Racing(cars)

        // When
        racing.startRacing(movable)

        // Then
        for (car in cars) {
            car.position shouldBe 0
        }
    }

    test("racing start시 movable true면 position이 1씩 증가") {
        // Given
        val names: List<String> = listOf("Jiwon", "Alex", "Bob")
        val movable = { true }
        val racing = Racing(CarNameMapper.map(names))

        // When
        val cars = racing.startRacing(movable)

        // Then
        for (car in cars) {
            car.position shouldBe 1
        }
    }
})
