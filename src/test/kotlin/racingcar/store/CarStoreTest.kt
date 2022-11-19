package racingcar.store

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import racingcar.CarFactory
import racingcar.fixture.CarCreateDtoFixture

class CarStoreTest : FunSpec({
    context("자동차 저장 및 조회 테스트") {
        test("여러 대의 자동차를 저장하고 조회할 수 있다.") {
            // given
            val cars = CarFactory.createMany(dtos = CarCreateDtoFixture.getMany(amount = 3))
            // when
            CarStore.setState(cars)
            val actual = CarStore.getState()
            // then
            actual shouldContainExactly cars
        }
    }
})
