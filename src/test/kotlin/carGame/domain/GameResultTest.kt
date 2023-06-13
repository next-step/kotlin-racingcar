package carGame.domain

import carGame.test.FakeGenerator
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class GameResultTest : StringSpec({
    "[getWinners 테스트] 가장 멀리간 자동차를 리턴한다." {
        val car1 = FakeGenerator.generateCar(position = 3)
        val car2 = FakeGenerator.generateCar(position = 3)
        val car3 = FakeGenerator.generateCar(position = 2)
        val cars = Cars(listOf(car1, car2, car3))
        val result = GameResult(history = listOf(cars))

        val winners = result.getWinners()

        winners shouldContainExactly listOf(car1, car2)
    }
})
