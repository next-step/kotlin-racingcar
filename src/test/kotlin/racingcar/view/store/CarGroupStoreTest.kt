package racingcar.view.store

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.CarGroup
import racingcar.domain.CarName
import racingcar.domain.Position

class CarGroupStoreTest : FunSpec({
    context("자동차 그룹 저장 및 조회 테스트") {
        test("자동차 그룹을 저장하고 조회할 수 있다.") {
            // given
            val cars = listOf(Car(id = 1, name = CarName(value = "동구"), position = Position(value = 5)))
            val carGroup = CarGroup(cars = cars)
            // when
            CarGroupStore.setState(carGroup)
            val actual = CarGroupStore.getState()
            // then
            actual shouldBe carGroup
        }
    }
})
