package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import racing.Game.Companion.gameEngine

class GameEngineTest : FunSpec({
    context("playTurnForAllCar(carList) 단위테스트") {
        test("한 번 실행하면 carList 내부의 모든 currentLocation이 기존값~기존값+1 사이에 존재한다") {
            // given
            val givenCarList = mutableListOf<Car>(
                Car(0, 0),
                Car(1, 5),
                Car(2, 100)
            )
            // when
            gameEngine.playTurnForAllCar(givenCarList)
            // then
            givenCarList[0].currentLocation shouldBeInRange 0..1
            givenCarList[1].currentLocation shouldBeInRange 5..6
            givenCarList[2].currentLocation shouldBeInRange 100..101
        }
    }
})
