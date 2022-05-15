package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import racingcar.domain.CarFixture.initCars
import racingcar.domain.CarFixture.racingCarAllWinner
import racingcar.domain.CarFixture.racingCarOneWinner

class CarRacingTest : AnnotationSpec() {
    @Test
    fun `입력한 자동차 이름 수 만큼 Car 객체가 생성되고, 시작위치는 0이다`() {
        val carNames = listOf("car1", "car2", "car3")
        val actualCars = CarRacing.initCars(carNames)
        initCars.size shouldBe actualCars.size
        initCars[0].position shouldBe actualCars[0].position
        initCars[1].position shouldBe actualCars[1].position
        initCars[2].position shouldBe actualCars[2].position
        initCars[0].name shouldBe actualCars[0].name
        initCars[1].name shouldBe actualCars[1].name
        initCars[2].name shouldBe actualCars[2].name
    }

    @Test
    fun `자동차 경주 한 턴당 각 자동차 위치는 1칸 전진하거나 이동하지 않아야 한다`() {
        val resultCars = CarRacing.moveCars(racingCarOneWinner)
        resultCars.size shouldBe racingCarOneWinner.size
        resultCars[0].position shouldBeInRange racingCarOneWinner[0].position..racingCarOneWinner[0].position.plus(1)
        resultCars[1].position shouldBeInRange racingCarOneWinner[1].position..racingCarOneWinner[1].position.plus(1)
        resultCars[2].position shouldBeInRange racingCarOneWinner[2].position..racingCarOneWinner[2].position.plus(1)
    }

    @Test
    fun `자동차 게임이 끝난 후 우승자 목록을 알 수 있다`() {
        val winner = CarRacing.getWinners(racingCarOneWinner)
        winner.size shouldBe 1
        winner[0] shouldBe racingCarOneWinner[2].name
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        val listWinner = CarRacing.getWinners(racingCarAllWinner)
        listWinner.size shouldBe racingCarAllWinner.size
    }

    @Test
    fun `자동차 이름 길이는 5자를 초과할 수 없다`() {
        val carNames = listOf("myCar", "thisIsMyCar")
        val exception = shouldThrow<IllegalArgumentException> {
            CarRacing.initCars(carNames)
        }
        exception.message shouldBe "자동차 이름은 5자를 초과할 수 없어요."
    }
}
