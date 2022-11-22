package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class RacingGameTest : BehaviorSpec({

    given("항상 전진 하는 자동 차라면") {
        tryCountList.forAll { tryCount ->
            val cars = Cars(listOf(Car(Name("yb"), { true }, Distance(0))))

            `when`("시도횟수만큼") {
                val racingGame = RacingGame(
                    initialCars = cars,
                    tryCount = TryCount(tryCount)
                )
                racingGame.start()

                then("전진한다.") {
                    racingGame.getCars().getCars().forEach {
                        it.getDistance() shouldBe tryCount
                    }
                }
            }
        }
    }
}) {
    companion object {
        private val tryCountList = listOf(1, 3, 5, 10)
    }
}
