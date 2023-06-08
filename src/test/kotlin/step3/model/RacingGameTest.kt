package step3.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainOnly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import step3.fake.NumberGeneratorGreaterThan4
import step3.fake.NumberGeneratorLessThan4

class RacingGameTest : FunSpec({

    test("게임을 진행할 때마다 시도 횟수가 증가한다.") {
        // given
        val numberGenerator = NumberGeneratorGreaterThan4()
        val cars = listOf(Car(1), Car(2), Car(3))
        val racingGame = RacingGame(numberGenerator = numberGenerator, cars = cars)

        // when
        racingGame.run()

        // then
        racingGame.getCurrentTrialCount() shouldBe 1
    }

    test("생성된 숫자가 4 이상일 경우 car 를 전진시킨다.") {
        // given
        val numberGenerator = NumberGeneratorGreaterThan4()
        val cars = listOf(Car(1), Car(2), Car(3))
        val racingGame = RacingGame(numberGenerator = numberGenerator, cars = cars)

        // when
        racingGame.run()

        // then
        racingGame.getResult().shouldContainOnly(Car.FIRST_POSITION + 1)
    }

    test("생성된 숫자가 4 미만일 경우 car 는 멈춘다.") {
        // given
        val numberGenerator = NumberGeneratorLessThan4()
        val cars = listOf(Car(1), Car(2), Car(3))
        val racingGame = RacingGame(numberGenerator = numberGenerator, cars = cars)

        // when
        racingGame.run()

        // then
        racingGame.getResult().shouldContainOnly(Car.FIRST_POSITION)
    }

    test("경주에 참여한 car 개수만큼 결과를 반환한다.") {
        // given
        val numberGenerator = NumberGeneratorGreaterThan4()
        val cars = listOf(Car(1), Car(2), Car(3))
        val racingGame = RacingGame(numberGenerator = numberGenerator, cars = cars)

        // when
        val actual = racingGame.getResult()

        // then
        actual shouldHaveSize cars.size
    }
})
