package study.step3.model

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat

class CarTest : StringSpec({

    "주어진 자동차에, 전진하면, 위치가 1 증가한다  " {
        // given
        val car = Car()
        val beforeLocation = car.getLocation()

        // when
        car.advance()

        // then
        val afterLocation = car.getLocation()
        assertThat(afterLocation - beforeLocation).isOne()
    }

    "주어진 자동차에, 멈춘하면, 위치가 변경되지 않는다" {
        // given
        val car = Car()
        val beforeLocation = car.getLocation()

        // when
        car.stop()

        // then
        val afterLocation = car.getLocation()
        assertThat(afterLocation).isEqualTo(beforeLocation)
    }
})
