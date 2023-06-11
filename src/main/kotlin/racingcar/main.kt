package racingcar

import racingcar.controller.RacingController
import racingcar.rule.RacingRuleImpl
import racingcar.util.RandomGenerator
import racingcar.view.ResultViewImpl

fun main() {
    val view = ResultViewImpl()
    val rule = RacingRuleImpl(RandomGenerator())
    val controller = RacingController(view, rule)

    controller.play()
}
