package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(input : Any) : String {
    val message = when (input) {
        "Hello" -> "world"
        "Howdy", "Bonjour" -> "Say what?"
        is String -> "I don't understand"
        0 -> "zero"
        1 -> "one"
        in 2..10 -> "low number"
        is Int -> "a number"
        else -> "I don't understand"
    }
    return message
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(n1 : Int, n2 : Int) : Int {
    return n1 + n2
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(n1 : Int, n2 : Int) : Int {
    return n1 - n2
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(n1: Int, n2: Int, passFun: (Int, Int) -> Int): Int {
    return passFun(n1, n2)
}
// write a class "Person" with first name, last name and age
class Person(val firstName: String,
            val lastName: String,
            val age: Int, 
            val debugString: String = "[Person firstName:${firstName} lastName:${lastName} age:${age}]") {
}
// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
enum class Currency {
    USD, EUR, CAN, GBP   
}

class Money(val amount: Int, val currency: String) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("amount can't be negative")
        }
        if (currency !in setOf("USD", "EUR", "CAN", "GBP")) {
            throw IllegalArgumentException("Invalid currency")
        }
    }
    fun convert(convertTo: String): Money {
        val inUsd = when(currency) {
            "EUR" -> amount * 2 / 3
            "CAN" -> amount * 4 / 5
            "GBP" -> amount * 2
            else -> amount
        }
        val conversion: Int = when(convertTo) {
            "EUR" -> inUsd * 3 / 2
            "CAN" -> inUsd * 5 / 4
            "GBP" -> inUsd / 2
            else -> inUsd
        }
        return Money(conversion, convertTo)
    }
    operator fun plus(other: Money): Money {
        val newOther = other.convert(this.currency)
        return Money(this.amount + newOther.amount, this.currency)
    }
}