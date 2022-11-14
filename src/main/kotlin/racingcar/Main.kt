package racingcar

import racingcar.domain.VictoryCondition

fun main() {
    RacingGame().run(victoryCondition = VictoryCondition.Longest)
}
