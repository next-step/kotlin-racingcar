package step3.distance

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import step3.domain.car.distance.CarDistance
import step3.domain.car.distance.DefaultCarDistance

class DefaultCarDistanceTest : FunSpec({
    lateinit var distance: CarDistance<Int>

    beforeEach {
        distance = DefaultCarDistance()
    }

    test("초기 distance 값은 0 이다") {
        distance.distance shouldBe 0
    }

    context("정상적으로 거리를 증가시킬 수 있다") {
        table(
            headers("addDistance"),
            row(1),
            row(2),
            row(3),
            row(4),
            row(5),
            row(6)
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
            row(-100),
            row(-50),
            row(-10),
            row(-5),
            row(-2),
            row(-1)
        ).forAll { addDistance ->
            test("$addDistance 거리 증가 예외 처리") {
                assertThrows<IllegalArgumentException> {
                    distance.increment(-3)
                }
            }
        }
    }
})
