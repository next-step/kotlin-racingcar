package racingcar

import racingcar.controller.RacingController
import racingcar.rule.RacingRuleImpl
import racingcar.util.RandomGenerator0To9
import racingcar.view.ResultViewImpl

fun main() {
    val view = ResultViewImpl()
    val rule = RacingRuleImpl(RandomGenerator0To9())
    val controller = RacingController(view, rule)

    controller.play()
}
