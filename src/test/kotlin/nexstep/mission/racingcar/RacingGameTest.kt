package nexstep.mission.racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf

class RacingGameTest : FunSpec({

    test("입력받은 문자열을 콤마로 나누고 이름대로 경주 자동차를 생성한다.") {
        val result = RacingGame("pobi,jason,brown")
        result.racingCars.forExactly(3) {
            it.shouldBeTypeOf<RacingCar>()
        }
    }

    /**
     * 아래 테스트가 제 역할을 하는게 맞는걸까?
     * RacingGame 객체의 race 함수에 대한 테스트 코드이지만
     * 정작 RacingCar의 move 함수에 대한 테스트라는 생각이 듦
     * 단위 테스트에서 런던파를 지지하기에 고전파 방식의 테스트 코드가 조금은 어색하다고 느껴짐
     */
    test("전달받은 함수를 경주 자동차에 전달하여 이동시키는 함수를 호출한다.") {
        val racingGame = RacingGame("pobi,jason,brown")

        racingGame.race { 4 }

        racingGame.racingCars.forExactly(3) {
            it.position shouldBe 1
        }
    }
})
