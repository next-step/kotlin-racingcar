package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange

class GameTest : FunSpec({
    val game = Game()
    context("run() 단위테스트 - 정상 범위의 input 입력후 run() 호출 시 게임이 정상적으로 동작한다") {
        test("3대, 4턴 조건으로 run 실행 시 car는 3대, 모든 car의 currentLocation은 0..4 사이값을 가져야 한다") {
            // given
            val carNumberInput = 3
            val turnNumberInput = 4
            // when
            game.run(carNumberInput, turnNumberInput)
            // then
            game.carList shouldHaveSize 3

            game.carList.forAll {
                it.currentLocation shouldBeInRange (0..4)
            }
        }
    }
    context("clearResult() 단위테스트") {
        test("run 실행 이후 clearResult 실행 시 carList는 비어있어야 한다") {
            game.carList shouldHaveSize 3
            // when
            game.clearCarList()
            // then
            game.carList shouldHaveSize 0
        }
    }
})
