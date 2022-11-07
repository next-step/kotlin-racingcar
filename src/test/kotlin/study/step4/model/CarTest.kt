package study.step4.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import org.assertj.core.api.Assertions.assertThat
import study.step4.util.StaticDigit

class CarTest : StringSpec({

    "주어진 자동차에, 주어진 숫자가 4 이상이면 전진하여, 위치가 1 증가한다  " {
        listOf(
            4, 5, 6, 7, 8, 9
        ).forAll {
            // given
            val car = Car(digitGenerator = StaticDigit(it))
            val beforeLocation = car.getLocation()

            // when
            car.move()

            // then
            val afterLocation = car.getLocation()
            assertThat(afterLocation - beforeLocation).isOne()
        }
    }

    "주어진 자동차에,주어진 숫자가 4 미만이면 멈춘하여, 위치가 변경되지 않는다" {
        listOf(
            0, 1, 2, 3
        ).forAll {
            // given
            val car = Car(digitGenerator = StaticDigit(it))
            val beforeLocation = car.getLocation()

            // when
            car.move()

            // then
            val afterLocation = car.getLocation()
            assertThat(afterLocation).isEqualTo(beforeLocation)
        }
    }
})
