package step3.carRacing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class CarGeneratorTest : StringSpec({
    "자동차를 정해진 사이즈만큼 생성한다" {
        val cars = CarGenerator.generate(5)
        cars.size shouldBe 5
        cars.forAll {
            it.shouldBeInstanceOf<Car>()
        }
    }
})
