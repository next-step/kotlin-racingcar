package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DriverTest : DescribeSpec({

    describe("Driver") {
        it("자동차에 이름을 부여할 수 있다.") {
            val driver = Driver("pico", Car())

            driver.name shouldBe "pico"
        }

        it("자동차의 이름은 1글자에서 5글자 사이입니다.") {
            val exception = shouldThrow<RuntimeException> {
                Driver("papico", Car())
            }

            exception.message shouldBe "자동차의 이름은 1글자에서 5글자 사이입니다."
        }

        it("drive test") {
            it("인자가 true 면 Car 가 이동한다.") {
                // given
                val driver = Driver("pico", Car(3))

                // when
                driver.drive(true)

                // then
                driver.driveRecord shouldBe listOf(3, 4)
            }

            it("인자가 false 면 Car 가 이동하지 않는다.") {
                // given
                val driver = Driver("pico", Car(3))

                // when
                driver.drive(false)

                // then
                driver.driveRecord shouldBe listOf(3, 3)
            }
        }
    }
})
