package racingcar.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import racingcar.view.ResultView

class GamesTest : StringSpec({

    "자동차 갯수와 게임 횟수, 게임 규칙을 받아 게임을 생성 한다" {
        val game = Games.of(3, ResultView(), InputNumberGenerator(5))

        game.shouldBeInstanceOf<Games>()
    }
})
