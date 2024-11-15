package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class RaceProcessorTest : StringSpec({
    val countGenerator = RandomCountGenerator()
    val carFactory = CarFactory
    val sut = RaceProcessor(carFactory, countGenerator)

    "입력받은 차의 개수와 라운드만큼 레이스를 진행하고 결과를 반환한다" {
        val carQuantity = 3
        val round = 5

        val actual = sut.execute(carQuantity, round)

        actual.shouldNotBeNull()
        actual.getCarCount() shouldBe carQuantity
        actual.getRoundCount() shouldBe round
    }

    "차의 개수가 0 이하일 경우 IllegalArgumentException을 던진다" {
        val carQuantity = 0
        val round = 5

        shouldThrow<IllegalArgumentException> {
            sut.execute(carQuantity, round)
        }
    }

    "라운드가 0 이하일 경우 IllegalArgumentException을 던진다" {
        val carQuantity = 3
        val round = 0

        shouldThrow<IllegalArgumentException> {
            sut.execute(carQuantity, round)
        }
    }
})

class RaceProcessor(
    private val carFactory: CarFactory,
    private val countGenerator: CountGenerator,
) {
    fun execute(
        carQuantity: Int,
        round: Int,
    ): RaceResult {
        validate(carQuantity, round)
        val cars = carFactory.createCars(carQuantity)

        val result = start(cars, round)

        return result
    }

    private fun start(
        cars: List<Car>,
        round: Int,
    ): RaceResult {
        val raceResult = RaceResult()

        repeat(round) { currentRound -> processRaceIteration(cars, currentRound, raceResult) }

        return raceResult
    }

    private fun processRaceIteration(
        cars: List<Car>,
        round: Int,
        raceResult: RaceResult,
    ) {
        cars.forEach { car ->
            car.move(countGenerator.generate())
            val result =
                Result.from(
                    round = round,
                    car = car,
                )
            raceResult.add(result)
        }
    }

    private fun validate(
        carQuantity: Int,
        round: Int,
    ) {
        require(carQuantity > 0) { "차는 1대 이상이어야 합니다." }
        require(round > 0) { "라운드는 1 이상이어야 합니다." }
    }
}
