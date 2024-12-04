package racing.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingCarsTest {
    @Test
    fun `가장 멀리 이동한 자동차를 반환`() {
        val carNames = listOf("CarA", "CarB", "CarC")
        val cars = CarFactory.createCars(carNames, 4..9)
        cars.forEach { car ->
            when (car.name) {
                "CarA" -> repeat(3) { car.move() }
                "CarB" -> repeat(2) { car.move() }
                "CarC" -> repeat(4) { car.move() }
            }
        }

        val winners = cars.getRaceWinners()
        winners.first().name shouldBe "CarC"
    }

    @Test
    fun `가장 멀리 이동한 자동차가 여러 대라면 모두 반환`() {
        val carNames = listOf("CarA", "CarB", "CarC")
        val cars = CarFactory.createCars(carNames, 4..4)
        cars.forEach { car ->
            when (car.name) {
                "CarA" -> repeat(4) { car.move() }
                "CarB" -> repeat(2) { car.move() }
                "CarC" -> repeat(4) { car.move() }
            }
        }

        val winners = cars.getRaceWinners()
        winners.size shouldBe 2
        winners.map { it.name } shouldBe setOf("CarA", "CarC")
    }

    @Test
    fun `자동차가 한 대도 없으면 빈 리스트를 반환`() {
        val carNames = emptyList<String>()
        val cars = CarFactory.createCars(carNames)
        val winners = cars.getRaceWinners()
        winners.size shouldBe 0
    }

    @Test
    fun `전진한 차량이 없다면 우승자가 없을 수 있다`() {
        val carNames = listOf("CarA", "CarB", "CarC")
        val cars = CarFactory.createCars(carNames, 0 until 4)
        cars.forEach { car ->
            repeat(4) { car.move() }
        }

        val winners = cars.getRaceWinners()
        winners.size shouldBe 0
    }
}