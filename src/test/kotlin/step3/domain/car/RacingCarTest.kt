package step3.domain.car

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class RacingCarTest : FunSpec({

    context("레이싱 카가 정상적으로 생성된다") {
        test("RacingCar() 정상적으로 생성") {
            RacingCar() shouldNotBe null
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
