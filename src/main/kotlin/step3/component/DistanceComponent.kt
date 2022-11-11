package step3.component

class DistanceComponent(
    val position: Int,
) : Component {
    override fun render() {
        (0..position).forEach { _ ->
            print("-")
        }
    }
}
