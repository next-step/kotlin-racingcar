package race

class CarRecord(
    val name: String,
    val position: Int
) : Comparable<CarRecord> {
    override fun compareTo(other: CarRecord): Int {
        return position.compareTo(other.position)
    }
}
