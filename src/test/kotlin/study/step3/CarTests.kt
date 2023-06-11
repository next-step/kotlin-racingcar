package study.step3

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertEquals

class CarTests : StringSpec({

    "Car 의 초기 트레이스는 한 칸이다" {
        val sut = Car(RandomMovementConditionGenerator())
        sut.getMovementTrace() shouldBe ""
    }

    "4 미만의 조건에 대해서는 제자리에 있는다" {
        table(
            headers("generatedNumber"),
            row(0),
            row(3)
        ).forAll { generatedNumber ->
            val sut = Car(object : MovementConditionGenerator {
                override fun run(): Int {
                    return generatedNumber
                }
            })
            sut.move()
            sut.getMovementTrace() shouldBe ""
        }
    }

    "4 이상의 조건에 대해서는 한 칸 전진한다" {
        table(
            headers("generatedNumber"),
            row(4),
            row(9)
        ).forAll { generatedNumber ->
            val sut = Car(object : MovementConditionGenerator {
                override fun run(): Int {
                    return generatedNumber
                }
            })
            sut.move()
            assertEquals(sut.getMovementTrace(), "-")
        }
    }
})
