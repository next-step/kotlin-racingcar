package racingcar

fun main() {
    val racingCarService = RacingCarService(
        DependencyConfig.carInputProvider,
        DependencyConfig.outputProvider,
        DependencyConfig.carFactory,
    )

    racingCarService.run()
}
