package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class GameEngineTest : FunSpec({
    val gameEngine = GameEngine
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
    context("playTurn(car) 단위테스트") {
        test("dice result가 4 이상인 경우에는 currentLocation이 1 증가한다") {
            // given
            forAll(
                row(0, 10, 4),
                row(1, 5, 8),
                row(2, 2, 6)
            ) { carNumber, initialLocation, givenDice ->
                val givenCar = Car(carNumber, initialLocation)
                // when
                gameEngine.playTurn(givenCar, givenDice)
                // then
                givenCar.currentLocation shouldBe initialLocation + 1
            }
        }
        test("dice result가 3 이하인 경우에는 currentLocation이 변하지 않는다") {
            // given
            forAll(
                row(0, 10, 3),
                row(1, 5, 2),
                row(2, 2, 1)
            ) { carNumber, initialLocation, givenDice ->
                val givenCar = Car(carNumber, initialLocation)
                // when
                gameEngine.playTurn(givenCar, givenDice)
                // then
                givenCar.currentLocation shouldBe initialLocation
            }
        }
    }
})
