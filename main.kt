import java.util.*;

fun main(args: Array<String>) {
    feedTheFish()
}

//fun feedTheFish() {
//    val day = randomDay()
//    val food = "pellets"
//    println("Today is $day and the fish eat $food")
//}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String) : String {
    var food = ""
    return when(day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pancakes"
        "Wednesday" -> "honday"
        "Thursday" -> "cereal"
        "Friday" -> "today"
        "Saturday" -> "flakes"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

