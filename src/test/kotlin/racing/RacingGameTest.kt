package racing

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import racing.domain.CarFactory
import racing.domain.Cars

class RacingGameTest {

    @Test
    fun `자동차 생성`() {
        val cars: Cars = CarFactory.create(3)
        assertThat(cars.count()).isEqualTo(3)
    }

    @Test
    fun `레이싱 결과`() {
        ㅣ
    }
}
