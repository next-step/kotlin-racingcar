package racingcar.car

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainExactly

class CarsTest : ShouldSpec({
    context("MoveAll") {
        should("move all cars") {
            val cars =
                Cars(
                    listOf(
                        Car("sun", canMove = { true }),
                        Car("brie", canMove = { true }),
                    ),
                )

            cars.moveAll()

            cars.winningCarNames() shouldContainExactly listOf("sun", "brie")
        }
    }

    context("WinningCarNames") {
        withData(
            Pair(listOf(true, true), listOf("sun", "brie")),
            Pair(listOf(false, true), listOf("brie")),
            Pair(listOf(true, false), listOf("sun")),
            Pair(listOf(false, false), listOf("sun", "brie")),
        ) {
            val (moves, expectedWinners) = it
            val cars =
                Cars(
                    listOf("sun", "brie").zip(moves) { name, canMove ->
                        Car(name, canMove = { canMove })
                    },
                )
            cars.moveAll()

            cars.winningCarNames() shouldContainExactly expectedWinners
        }
    }
})
