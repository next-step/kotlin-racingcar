package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import step3.fixture.CarCreateDtoFixture

class CarFactoryTest : FunSpec({
    val sut = CarFactory
    context("자동차 여러 대 생성 테스트") {
        context("자동차를 생성하는 dto 가 여러 개 주어지면") {
            test("dto 만큼 자동차를 생성할 수 있다.") {
                // given
                var createDtos = CarCreateDtoFixture.getMany(amount = 3)
                // when
                val actual = sut.createMany(dtos = createDtos)
                // then
                actual shouldHaveSize 3
            }
        }
    }
})
