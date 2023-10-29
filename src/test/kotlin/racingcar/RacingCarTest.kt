package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.Game
import racingcar.domain.Rule

class RacingCarTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "carSize:(3)|attemptSize:(3)|carsToMove:(0/1 1/2 0/1/2)|history:(1/1/0 1/2/1 2/3/2)",
            "carSize:(4)|attemptSize:(3)|carsToMove:(0/1/2 1/2/3 0/1/3)|history:(1/1/1/0 1/2/2/1 2/3/2/2)",
            "carSize:(5)|attemptSize:(3)|carsToMove:(3/4 1/2/4 0/1/2/4)|history:(0/0/0/1/1 0/1/1/1/2 1/2/2/1/3)"
        ]
    )
    fun `carSize, attemptSize, carsToMove 로 만들어지는 history 가 실제 게임의 history 와 동일한지 검사`(input: String) {
        val testSplitInput = input.split("|")

        val testCarSize = testSplitInput[0].substringAfter("carSize:(").substringBefore(")").toInt()
        val testAttemptSize = testSplitInput[1].substringAfter("attemptSize:(").substringBefore(")").toInt()
        val testCarsToMove: List<List<Int>> = buildList {
            testSplitInput[2].substringAfter("carsToMove:(").substringBefore(")").split(" ").forEach {
                add(it.split("/").map { it.toInt() })
            }
        }
        val testHistory: List<List<Int>> = buildList {
            testSplitInput[3].substringAfter("history:(").substringBefore(")").split(" ").forEach {
                add(it.split("/").map { it.toInt() })
            }
        }

        val game = Game(object : Rule {
            override val carSize: Int = testCarSize
            override val attemptSize: Int = testAttemptSize
            override val moveOrNot: Rule.MoveOrNot? = null
        })

        repeat(game.rule.attemptSize) {
            game.attemptToMove(*testCarsToMove[it].toIntArray())
        }

        assertThat(testHistory).isEqualTo(game.history)
    }
}
