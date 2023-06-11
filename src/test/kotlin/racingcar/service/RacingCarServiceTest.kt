package racingcar.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import racingcar.view.OutputConsoleView

class RacingCarServiceTest : StringSpec({
    "실행 결과로 우승자가 1명이상 나와야한다." {
        val racingCarService = RacingCarService(OutputConsoleView())
        val names = listOf("AAA", "BBB", "CCC")
        val winners = racingCarService.play(names, 5)
        winners shouldHaveAtLeastSize 1
    }
})
