package race.domain

class RandomNumGenerator : NumberGenerator {
    override fun generate(): Int {
        return (0..9).random()
    }
}
