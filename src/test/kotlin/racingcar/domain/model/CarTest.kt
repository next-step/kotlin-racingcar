package racingcar.domain.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThat

internal class CarTest : StringSpec({
    "생성된 카운트가 4이상이면 경로를 생성한다" {
        val car = Car(carName = CarName("hjw"), Position(0))

        car.moveTo(4)

        car.position shouldBe 1
    }
    "생성된 카운트가 4미만이면 경로가 없다" {
        val car = Car(carName = CarName("hjw"), Position(0))

        car.moveTo(3)

        car.position shouldBe 0
    }
    "자동차는 이름을 가진다" {
        val car = Car(carName = CarName("hjw"), Position(0))

        assertThat(car.carName).isEqualTo("hjw")
    }
})
