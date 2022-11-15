package car_race.logic.car

class CarNames private constructor(
    val names: List<CarName>
) {

    companion object {
        fun from(input: String): CarNames {
            return CarNames(
                input.split(",").map { name -> CarName(name) }
            )
        }
    }
}
