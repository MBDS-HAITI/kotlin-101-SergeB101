package com.android.com.kotlin.one

fun main() {

    println("👋 Welcome to the Kotlin Playground!")
    println("Let's start learning step by step.\n")


    // ✅ EXERCISE 1 Variables:
    // Create two variables: `city` (String) and `temperature` (Double)
    // Then print: "It is {temperature}°C in {city}"
    // Enforce `city` to be immutable and `temperature` mutable
    // Then print the sentence again after changing `temperature`

    val city: String = "Paris"
    var temperature: Double = 20.5
    println("It is $temperature°C in $city")
    temperature = 22.0
    println("It is $temperature°C in $city")


    // ✅ EXERCISE 2 Conditionals:
    // Create a variable `score` (Int)
    // Handle the following cases:
    // - If score is exactly 100, print "Perfect score!"
    // - If score is below 0 or above 100, print "Invalid score"
    // - If score between 0 and 49, print "You failed!"
    // - If score between 50 and 60, print "Just passed!"
    // - If score between 61 and 99, print "Well done!"

    val score = 85

    when {
        score == 100 -> println("Perfect score!")
        score < 0 || score > 100 -> println("Invalid score")
        score in 0..49 -> println("You failed!")
        score in 50..60 -> println("Just passed!")
        score in 61..99 -> println("Well done!")
    }

    // ✅ EXERCISE 3 list and Loops:
    // Create a list of your favorite fruits
    // Loop through the list and print each fruit in uppercase
    // Then, print the total number of fruits in the list
    // Ask the user to enter a fruit name and check if it's in the list

    val fruits = listOf("Pomme", "Banane", "Mangue", "Fraise")

    // Boucle pour afficher en majuscules
    for (fruit in fruits) {
        println(fruit.uppercase())
    }

    // Affichage de la taille de la liste
    println("Nombre total de fruits : ${fruits.size}")

    // Interaction avec l'utilisateur
    print("Entrez le nom d'un fruit : ")
    val input = readln()

    if (input in fruits) {
        println("Oui, $input est dans la liste !")
    } else {
        println("Non, $input n'est pas dans la liste.")
    }

    // ✅EXERCISE 4 Elvis Operator:
    // Create a nullable variable `nickname` of type String? and assign it null
    // Print the number of characters in `nickname`
    // Print the nickname or "No nickname provided" if it's null using the Elvis operator

    val nickname: String? = null

    // Affiche le nombre de caractères (utilise le safe call ?. et l'Elvis opérateur)
    println("Nombre de caractères : ${nickname?.length ?: 0}")

    // Affiche le pseudo ou le message par défaut
    val display = nickname ?: "No nickname provided"
    println(display)
}

