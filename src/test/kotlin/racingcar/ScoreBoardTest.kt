package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ScoreBoardTest : StringSpec({
    "Car 객체가 담긴 리스트가 비어있으면 예외를 반환한다." {
        shouldThrow<IllegalArgumentException> {
            ScoreBoard(listOf())
        }
    }

    "경주의 결과를 기록할 수 있다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 1),
                Car("test3", moveCount = 1),
            )
        val scoreBoard = ScoreBoard(cars)
        scoreBoard.recordPhaseResult(cars)

        scoreBoard.board.values.forEach { records -> records[0] shouldBe 1 }
    }

    "경주의 최종 우승자를 기록할 수 있다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 2),
                Car("test3", moveCount = 3),
            )
        val scoreBoard = ScoreBoard(cars)
        scoreBoard.recordPhaseResult(cars)
        scoreBoard.recordWinners()

        scoreBoard.winners[0] shouldBe "test3"
    }

    "경주의 최종 우승자가 여러명이라면 모두 기록한다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 1),
                Car("test3", moveCount = 1),
            )
        val scoreBoard = ScoreBoard(cars)
        scoreBoard.recordPhaseResult(cars)
        scoreBoard.recordWinners()

        scoreBoard.winners shouldBe listOf("test1", "test2", "test3")
    }
})
