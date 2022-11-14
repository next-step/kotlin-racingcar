package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class CarStoreTest : FunSpec({
    context("자동차 저장 테스트") {
        val sut = CarStore
        test("여러 대의 자동차를 저장할 수 있다.") {
            // given
            val cars = CarFactory.createMany(amount = 5)
            // when
            val actual = sut.saveAll(cars)
            // then
            actual shouldContainExactly cars
        }
    }

    context("자동차 조회 테스트") {
        val sut = CarStore
        test("여러 대의 자동차를 조회할 수 있다.") {
            // given
            val cars = CarFactory.createMany(amount = 5)
            sut.saveAll(cars)
            // when
            val actual = sut.findAll()
            // then
            actual shouldContainExactly cars
        }
    }
})
