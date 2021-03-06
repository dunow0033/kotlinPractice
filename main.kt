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

/*
import java.util.*;

fun main(args: Array<String>) {
    feedTheFish()
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
} */

class Person(val firstName: String = "Tom", val lastName: String = "Hardy"){
    var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value is $field")
            return field;
        }
}

import java.util.*

enum class EntityType {
    EASY, MEDIUM, HARD, HELP;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type){
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity(){
    object Help : Entity() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
}

fun main() {
    val entity:Entity = EntityFactory.create(EntityType.EASY)
    val msg = when(entity){
        Entity.Help -> "Help class"
        is Entity.Easy -> "easy class"
        is Entity.Medium -> "medium class"
        is Entity.Hard -> "hard class"
    }

    println(msg)
}

fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean){
    list.forEach{
        if(predicate(it)){
            println(it)
        }
    }
}

fun main(){
    val list = listOf("Kotlin", "Java", "C++", "C#")
    printFilteredStrings(list, { it.startsWith("K")})
}

fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?){
    list.forEach{
        if(predicate?.invoke(it) == true){
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

fun main(){
    val list = listOf("Kotlin", "Java", "C++", "C#")
    printFilteredStrings(list, predicate)

    printFilteredStrings(list, null)
}

fun main() {
    sayHello()
}

fun sayHello(){
    val array = Array(5){it * 2}
    println(java.util.Arrays.toString(array))

    val school = arrayOf("shark", "salmon", "minnow")
    for(element in school){
        print(element + " ")
    }

    for((index, element) in school.withIndex()){
        println("Item at $index is $element")
    }

    for((index, ele) in school.withIndex()){
        println("Item at $index is $ele")
    }

}

val filtered = decorations.asSequence().filter { it[0] == 'p' }
    val newList = filtered.toList()
    println(newList)

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}