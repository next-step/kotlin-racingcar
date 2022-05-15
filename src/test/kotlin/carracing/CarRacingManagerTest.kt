package carracing

import carracing.util.CarRacingManagerForTest
import carracing.util.RacingMovementRoleForTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingManagerTest : StringSpec({
    "tryMoveCar 는 RacingMovementRole 가 판단한 이동 거리 만큼 자동차가 이동한다" {
        // given
        val moveDistance = 4
        val carListManager = CarListManager(listOf(Car()))
        val racingMovementRoleForTest = RacingMovementRoleForTest()
        val randomIntCarRacingManager = CarRacingManagerForTest(carListManager, racingMovementRoleForTest)

        // when
        randomIntCarRacingManager.tryMoveCar(0, moveDistance)
        val nowCarDistance = carListManager.getCarDistance(0)
        val movementRoleMoveDistance = racingMovementRoleForTest.getMoveDistance(moveDistance)

        // then
        movementRoleMoveDistance shouldBe moveDistance
        nowCarDistance shouldBe moveDistance
    }

    "getCarList 는 CarList 데이터 가져온다" {
        // given
        val distance = 3
        val carListManager = CarListManager(listOf(Car(distance)))
        val carRacingManagerForTest = CarRacingManagerForTest(carListManager, RacingMovementRoleForTest())

        // when
        val carList = carRacingManagerForTest.getCarList()

        // then
        carList.size shouldBe 1
        carList[0].distance shouldBe distance
    }
})
