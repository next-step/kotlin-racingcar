package racing.model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : DescribeSpec({
    describe("Cars 테스트") {
        it("자동차들을 출력 가능한 형태의 문자열로 변환한다.") {
            // given
            val cars = Cars(
                listOf(
                    Car.spawnAt(0),
                    Car.spawnAt(2),
                    Car.spawnAt(3),
                )
            )

            // when
            val result = cars.toPrintableCars()

            // then
            result shouldBe "-----"
        }

        it("자동차들을 구분자를 포함한 출력 가능한 형태의 문자열로 변환한다.") {
            // given
            val cars = Cars(
                listOf(
                    Car.spawnAt(0),
                    Car.spawnAt(2),
                    Car.spawnAt(3),
                )
            )

            // when
            val result = cars.toPrintableCars("/")

            // then
            result shouldBe "/--/---"
        }
    }
})
