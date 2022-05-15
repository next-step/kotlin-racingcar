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
            result shouldBe "unknown: unknown: --unknown: ---"
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
            result shouldBe "unknown: /unknown: --/unknown: ---"
        }

        it("구분자를 가진 자동차 이름들을 가진 생성할 수 있다.") {
            // given
            val names = "mbc,kbs,jtbc,sbs"

            // when
            val cars = Cars.createWithNames(names)

            // then
            cars.toPrintableCars("/") shouldBe "mbc: /kbs: /jtbc: /sbs: "
        }

        it("가장 멀리 간 자동차의 이름 리스트를 반환한다.") {
            // given
            val cars = Cars(
                listOf(
                    Car.spawnWithPositionAndName(0, "A"),
                    Car.spawnWithPositionAndName(2, "B"),
                    Car.spawnWithPositionAndName(3, "C"),
                )
            )

            // when
            val result = cars.winnerNames()

            // then
            result shouldBe listOf("C")
        }
    }
})
