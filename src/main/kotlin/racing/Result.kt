package racing

data class Result(
    val round: Int,
    val carId: Int,
    val position: Int,
) {
    companion object {
        fun from(
            round: Int,
            car: Car,
        ): Result {
            return Result(
                round = round,
                carId = car.getSequence(),
                position = car.getPosition(),
            )
        }
    }
}
