package racingcar.domain.racing_game

import io.kotest.core.spec.style.BehaviorSpec

class CompeteRacingGameTest : BehaviorSpec({
    given("레이싱게임에 소유자가 없는 차를 등록한다") {
        then("승자를 얻으려할때 오류를 반환한다")
    }

    given("레이싱게임에 소유자가 있는 차를 등록후 레이싱을 한다") {
        then("승자를 반환한다")
    }
})
