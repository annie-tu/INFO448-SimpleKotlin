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
    when (input) {
        "Hello" -> return "World"
        is String -> return "I don't understand"
        "Howdy", "Bonjour" -> return "Say what?"
        0 -> return "zero"
        1 -> return "one"
        in 2..10 -> return "low number"
        is Int -> return "a number"
    }
    return "I don't understand"
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
fun mathOp(n1: Int, n2: Int, passFun: (Int, Int) -> Int):Int {
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

class Money(val amount: Int, val currency: Currency) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException()
        }
    }

    fun convert(convertTo: Currency) {
        var inUsd = when(currency) {
            Currency.USD -> amount
            Currency.EUR -> amount * (2/3)
            Currency.CAN -> amount * (4/5)
            Currency.GBP -> amount * 2
        }
        var result: Int = when(convertTo) {
            Currency.USD -> inUsd
            Currency.EUR -> inUsd * (3/2)
            Currency.CAN -> inUsd * (5/4)
            Currency.GBP -> (inUsd * 0.5).toInt()
        }
        return Money(amount = result, currency = convertTo)
    }

    operator fun Money.plus(m1: Money, m2: Money): Money{
        return convert(m1.amount + m2.amount, m2.currency)
    }
}