package step3.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows
import step3.strategy.DefaultCarNamePolicyTest

class RacingCarTest : FunSpec({

    context("레이싱 카가 정상적으로 생성된다") {
        table(
            headers("validCarNameLength"),
            *(1..5).map { row(it) }.toTypedArray()
        ).forAll { validCarNameLength ->
            val validCarName = DefaultCarNamePolicyTest.generateCarName(validCarNameLength)

            test("[$validCarName] : 유효한 RacingCarName (length: $validCarNameLength)") {
                RacingCar(validCarName) shouldNotBe null
            }
        }
    }

    context("이름 정책에 어긋난 이름의 레이싱 카는 IllegalArgumentException 발생한다") {
        table(
            headers("invalidCarNameLength"),
            *(6..100).map { row(it) }.toTypedArray()
        ).forAll { invalidCarNameLength ->
            val invalidCarName = DefaultCarNamePolicyTest.generateCarName(invalidCarNameLength)

            test("[$invalidCarName] : 유효하지 않은 RacingCarName (length: $invalidCarNameLength)") {
                assertThrows<IllegalArgumentException> { RacingCar(invalidCarName) }
            }
        }
    }

    context("RacingCar.go() method 정상 작동") {
        table(
            headers("goCallingCount"),
            row(0),
            row(1),
            row(2),
            row(3),
            row(4),
        ).forAll { goCallingCount ->
            test("When RacingCar.go() called $goCallingCount times, then distance increase $goCallingCount") {
                val racingCar = RacingCar("car")

                val beforeDistance = racingCar.distance

                repeat(goCallingCount) {
                    racingCar.go()
                }

                val afterDistance = racingCar.distance

                afterDistance shouldBe beforeDistance + goCallingCount
            }
        }
    }
})
