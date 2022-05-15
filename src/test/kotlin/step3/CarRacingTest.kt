package step3

import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@ExtendWith(MockKExtension::class)
class CarRacingTest {

    @MockK
    lateinit var movingStrategy: MovingStrategy

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
        "jay,kevin,evan,emma/ 4",
        delimiter = '/')
    fun `1) 자동차 개수 생성 및 무조건 이동시 위치 테스트`(carNames: String, moveCount: Int) {
        val carRacing = CarRacing.of(carNames, moveCount)
        every { movingStrategy.movable() } returns true
        carRacing.run(movingStrategy)
        for (i in 0 until carRacing.cars.carList.size) {
            Assertions.assertThat(carRacing.cars.carList[i].position).isEqualTo(moveCount)
        }
    }

    @ParameterizedTest
    @CsvSource("jay,kevin,evan/ 3",
        "jay,kevin,evan,emma/ 4",
        delimiter = '/')
    fun `2) 자동차 개수 생성 및 MovingStrategyRandom 클래스 반영 테스트`(carNames: String, moveCount: Int) {
        val carRacing = CarRacing.of(carNames, moveCount)
        carRacing.run(MovingStrategyRandom())
        Assertions.assertThat(carRacing.cars.carList.size).isEqualTo(carNames.split(",").size)
    }

    @Test
    fun `3) 우승자 선정`() {
        val moves = listOf(
            true, true, true, // 1, 1, 1
            false, true, true, // 1, 2, 2
            false, false, true, // 1, 2, 3
        )

        val carRacing = CarRacing.of("foo,bar,baz", 3)
        carRacing.run(object : MovingStrategy {
            private var pos = 0
            override fun movable(): Boolean {
                return moves[pos++]
            }
        })

        carRacing.cars.getWinnerList() shouldContainExactly listOf("baz")
    }
}

