package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 대수만큼 자동차를 생성하는지 테스트`(input: Int) {
        val defaultTrial = 1
        val defaultSeedMaker = SeedMakerImpl()
        val inputCars = List(input) { "name$it" }
        val game = RacingCarGame(defaultTrial, defaultSeedMaker, inputCars)
        game.play()

        repeat(input) {
            val carSize = game.gameResults.gameResult[0].size

            assertThat(carSize).isEqualTo(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 시도횟수만큼 게임을 진행하는지 테스트`(input: Int) {
        val defaultCar = listOf("name")
        val defaultSeedMaker = SeedMakerImpl()
        val game = RacingCarGame(input, defaultSeedMaker, defaultCar)
        game.play()

        val carSize = game.gameResults.gameResult.size

        assertThat(carSize).isEqualTo(input)
    }

    @Test
    fun `4이상의 시드에만 이동하는지 테스트`() {
        val defaultTrial = 10
        val carName = "name"
        val defaultCar = listOf(carName)
        val testList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        val mockingSeedMaker: SeedMaker = object : SeedMaker {
            var top = -1

            override fun nextInt(): Int {
                return testList[++top]
            }
        }

        val game = RacingCarGame(defaultTrial, mockingSeedMaker, defaultCar)
        game.play()

        val result = game.gameResults.gameResult.last()[0].position
        val expectPosition = testList.filter { it >= 4 }.size
        assertThat(result).isEqualTo(expectPosition)
    }
}
