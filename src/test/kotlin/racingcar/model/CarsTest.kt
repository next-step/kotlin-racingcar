package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest{

    @Test
    fun `자동차들 생성에 성공한다`() {
        val cars = Cars(TrueEngineCarCreator, NaturalNumber.createNaturalNumber(3))
        assertThat(cars.getCars()).hasSize(3)
            .flatExtracting({ it.getPosition() })
            .containsExactly(0L, 0L, 0L)
    }

    @Test
    fun `자동차들 전진에 성공한다`() {
        val cars = Cars(TrueEngineCarCreator, NaturalNumber.createNaturalNumber(3))
        cars.move()
        assertThat(cars.getCars()).hasSize(3)
            .flatExtracting({ it.getPosition() })
            .containsExactly(1L, 1L, 1L)
    }

     @Test
     fun `자동차들의 상태를 문자열로 나타낸다`() {
         val cars = Cars(TrueEngineCarCreator, NaturalNumber.createNaturalNumber(3))
         cars.move()
         assertThat(cars.generateResult()).isEqualTo("-\n-\n-")
     }
}
