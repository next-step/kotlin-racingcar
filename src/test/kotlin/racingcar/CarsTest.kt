package racingcar

import io.kotest.matchers.nulls.shouldNotBeNull
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `숫자를 받아 자동차 목록을 생성한다`() {
        val cars = Cars.createCountOf(5)

        cars.shouldNotBeNull()
    }
}
