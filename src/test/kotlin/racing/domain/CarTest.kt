package racing.domain

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions

class CarTest : StringSpec({
    "자동차의 전진조건에 충족하면 전진하도록 한다" {
        val car = Car(CarName("pobi"))
        val movingStrategy = AlwaysMovingStrategy()
        car.move(movingStrategy)
        Assertions.assertThat(car.location.location).isEqualTo(1)
    }
})
