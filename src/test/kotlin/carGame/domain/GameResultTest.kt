package carGame.domain

import carGame.test.FakeGenerator
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly

class GameResultTest : StringSpec({
    "[getWinners 테스트] 가장 멀리간 자동차를 리턴한다." {
        forAll(
            row(listOf(2, 3, 2), listOf(1)),
            row(listOf(2, 2, 1), listOf(0, 1))
        ) { carPositions, winnersIndex ->
            val cars = FakeGenerator.generateCarsOfPositions(carPositions)
            val result = GameResult(history = listOf(cars))

            val winners = result.getWinners()

            val expectedWinners = winnersIndex.map { cars.cars[it] }
            winners shouldContainExactly expectedWinners

        }
    }
})
