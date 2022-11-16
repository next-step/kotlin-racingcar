package step3.domain.car.distance

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class DefaultCarDistanceTest : FunSpec({

    lateinit var distance: CarDistance<Int>

    beforeEach {
        distance = DefaultCarDistance()
    }

    test("초기 distance Default 값은 0 이다") {
        distance.distance shouldBe 0
    }

    context("초기 distance가 정상적으로 설정된다") {
        table(
            headers("initDistance"),
            *(1..100).map { row(it) }.toTypedArray()
        ).forAll { initDistance ->
            test("initDistance: $initDistance") {
                val carDistance = DefaultCarDistance(initDistance)
                carDistance.distance shouldBe initDistance
            }
        }
    }

    context("정상적으로 거리를 증가시킬 수 있다") {
        table(
            headers("addDistance"),
            *(1..100).map { row(it) }.toTypedArray()
        ).forAll { addDistance ->
            test("$addDistance 거리 증가") {
                val beforeDistance = distance.distance

                distance.increment(addDistance)

                val afterDistance = distance.distance

                afterDistance shouldBe beforeDistance + addDistance
            }
        }
    }

    context("0이하의 거리를 증가 시킬수 없다") {
        table(
            headers("addDistance"),
            *(0 downTo -100).map { row(it) }.toTypedArray()

        ).forAll { addDistance ->
            test("$addDistance 거리 증가 예외 처리") {
                assertThrows<IllegalArgumentException> {
                    distance.increment(-3)
                }
            }
        }
    }
})
