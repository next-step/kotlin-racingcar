package next.step.racing.domain.car

data class CarNames(val names: List<CarName>) : List<CarName> by names {

    init {
        require(isNotEmpty()) { "차 이름이 최소 1개는 있어야 합니다." }
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","

        fun from(names: String): CarNames {
            return CarNames(names.split(CAR_NAME_DELIMITER).map { CarName(it) })
        }
    }
}
