package racing.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class CarRacingTest : BehaviorSpec() {

    @ValueSource(strings = ["pobi,crong,honux"])
    @ParameterizedTest
    fun `자동차들의 이름은 쉼표로 구분한다`(carNames: String) {
        val (cars, _, _) = CarRacing().race(carNames.split(","), tryCount = 5)
        cars.map { it.name } shouldBe carNames.split(",")
    }

    @MethodSource("provideParameters")
    @ParameterizedTest
    fun `자동차 경주 게임은 몇 대의 자동차로 몇 번의 이동한 결과를 반환한다`(carNames: List<String>, tryCount: Int) {
        val (_, results, _) = CarRacing().race(carNames, tryCount)
        results shouldBeSameSizeAs List(tryCount) { carNames }
    }

    @MethodSource("provideParameters")
    @ParameterizedTest
    fun `자동차 경주 게임의 우승자는 한 명 이상이다`(carNames: List<String>, tryCount: Int) {
        val (_, _, winners) = CarRacing().race(carNames, tryCount)
        winners shouldHaveAtLeastSize 1
    }

    @MethodSource("provideParameters")
    @ParameterizedTest
    fun `자동차 경주 게임의 우승자는 가장 많이 움직인 자동차이다`(carNames: List<String>, tryCount: Int) {
        val (cars, _, winners) = CarRacing().race(carNames, tryCount)
        winners shouldBe CarRacingRecorder.findWinners(cars)
    }

    companion object {
        @JvmStatic
        private fun provideParameters(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("pobi", "crong"), 5),
            Arguments.of(listOf("pobi", "crong", "honux"), 7),
            Arguments.of(listOf("pobi", "crong", "honux"), 10),
        )
    }
}
