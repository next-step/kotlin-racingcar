package study.step4.model

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat

class CarTest : StringSpec({

    "자동차 객체를,  생성하면, 이름을 갖게된다 " {
        // given & when
        val car = Car(name = "자동차1")
        // then
        assertThat(car.name).isEqualTo("자동차1")
    }

    "주어진 자동차에, 숫자 엔진이 run 시 true 를 반환하면,  위치가 1 증가한다  " {
        // given
        val engin = DigitEngine(StaticDigit(5))
        val car = Car(engin = engin)

        val beforeLocation = car.getLocation()

        // when
        car.move()

        // then
        assertThat(engin.run()).isTrue
        val afterLocation = car.getLocation()
        assertThat(afterLocation - beforeLocation).isOne()
    }

    "주어진 자동차에,숫자 엔진이 run 시 false 를 반환하면, 위치가 변경되지 않는다" {
        // given
        val engin = DigitEngine(StaticDigit(0))
        val car = Car(engin = engin)
        val beforeLocation = car.getLocation()

        // when
        car.move()

        // then
        assertThat(engin.run()).isFalse
        val afterLocation = car.getLocation()
        assertThat(afterLocation).isEqualTo(beforeLocation)
    }
})
