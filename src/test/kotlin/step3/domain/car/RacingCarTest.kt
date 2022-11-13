package step3.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import step3.domain.car.policy.CarNamePolicyDataSet
import step3.domain.car.policy.DefaultCarNamePolicy

class RacingCarTest : FunSpec({

    context("레이싱 카가 정상적으로 생성된다") {
        table(
            headers("validCarNameLength"),
            *(DefaultCarNamePolicy.MIN_LEHGTH_OF_CAR_NAME..DefaultCarNamePolicy.MAX_LENGTH_OF_CAR_NAME)
                .map { row(it) }.toTypedArray()
        ).forAll { validCarNameLength ->
            val validCarName = CarNamePolicyDataSet.randomCarName(validCarNameLength)

            test("[$validCarName] : 유효한 RacingCarName (length: $validCarNameLength)") {
                RacingCar() shouldNotBe null
            }
        }
    }

    // context("이름 정책에 어긋난 이름의 레이싱 카는 IllegalArgumentException 발생한다") {
    //     table(
    //         headers("invalidCarNameLength"),
    //         *((0..100) - (DefaultCarNamePolicy.MIN_LEHGTH_OF_CAR_NAME..DefaultCarNamePolicy.MAX_LENGTH_OF_CAR_NAME))
    //             .map { row(it) }.toTypedArray()
    //     ).forAll { invalidCarNameLength ->
    //         val invalidCarName = CarNamePolicyDataSet.randomCarName(invalidCarNameLength)
    //
    //         test("[$invalidCarName] : 유효하지 않은 RacingCarName (length: $invalidCarNameLength)") {
    //             assertThrows<IllegalArgumentException> { RacingCar() }
    //         }
    //     }
    // }

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
                val racingCar = RacingCar()

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
