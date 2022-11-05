package study.step3.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.assertj.core.api.Assertions.assertThat

class CarTest : StringSpec({

    "주어진 자동차에, 4이상의 수를 주고 전진하면, 위치가 1 증가한다  " {
        listOf(4, 5, 6, 7, 8, 9).forAll {
            val car = Car()
            val beforeLocation = car.location()
            car.advance(it)
            val afterLocation = car.location()

            assertThat(afterLocation - beforeLocation).isOne()
        }
    }

    "주어진 자동차에, 4 미만의 수를 주고 전진하면, 위치가 변경되지 않는다" {
        listOf(0, 1, 2, 3).forAll {
            val car = Car()
            val beforeLocation = car.location()
            car.advance(it)
            val afterLocation = car.location()

            assertThat(afterLocation).isEqualTo(beforeLocation)
        }
    }
})
