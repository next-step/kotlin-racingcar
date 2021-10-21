package domain.step4.domain.racingcar

import domain.step4.domain.strategy.MovingStrategy
import global.strategy.split.SplitStrategy
import kotlin.streams.asSequence
import kotlin.streams.toList

data class RacingCars private constructor(private val _racingCars: List<RacingCar>) {
    init {
        require(_racingCars.isNotEmpty()) { EMPTY_MESSAGE }
    }
    val racingCars: List<RacingCar>
        get() = _racingCars.toList()

    fun moveForward(): RacingCars = RacingCars(_racingCars.map { it.moveForward() })

    fun winningRacingCars(): List<RacingCar> {
        val maxValue = maxDistance()
        return _racingCars.stream().asSequence()
            .filter { racingCar -> racingCar.isWinner(maxValue) }
            .toList()
    }

    private fun maxDistance(): Int = _racingCars.stream().asSequence()
        .map(RacingCar::distance)
        .maxOrNull() ?: DistanceDriven.DEFAULT

    companion object {
        private const val EMPTY_MESSAGE = "비어있는 값은 들어올 수 없습니다."

        fun from(names: String, splitStrategy: SplitStrategy, movingStrategy: MovingStrategy): RacingCars =
            from(Names.ofStringWithSplitStrategy(names, splitStrategy), movingStrategy)

        fun from(names: Names, movingStrategy: MovingStrategy): RacingCars =
            of(names.names.stream()
                .map { RacingCar(it, movingStrategy = movingStrategy) }
                .toList())

        fun of(racingCars: List<RacingCar>): RacingCars = RacingCars(racingCars)
    }
}

