package step3.domain.car.policy

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class DefaultCarNamePolicyTest : FunSpec({

    lateinit var carNamePolicy: CarNamePolicy

    beforeEach {
        carNamePolicy = DefaultCarNamePolicy
    }

    context("carName 길이가 1이상 5이하 인 경우, 유효하다") {
        table(
            headers("validLength"),
            *(DefaultCarNamePolicy.MIN_LEHGTH_OF_CAR_NAME..DefaultCarNamePolicy.MAX_LENGTH_OF_CAR_NAME)
                .map { row(it) }
                .toTypedArray()
        ).forAll { validLength ->
            test("validLength: $validLength => Valid") {
                carNamePolicy.isValidName(CarNamePolicyDataSet.randomCarName(validLength)) shouldBe true
            }
        }
    }

    context("carName 길이가 1이상 5이하 아닌 경우, 유효하지 않다") {
        table(
            headers("invalidLength"),
            *((0..100) - (DefaultCarNamePolicy.MIN_LEHGTH_OF_CAR_NAME..DefaultCarNamePolicy.MAX_LENGTH_OF_CAR_NAME))
                .map { row(it) }
                .toTypedArray()
        ).forAll { invalidLength ->
            test("invalidLength: $invalidLength => Invalid") {
                carNamePolicy.isValidName(CarNamePolicyDataSet.randomCarName(invalidLength)) shouldBe false
            }
        }
    }
})


