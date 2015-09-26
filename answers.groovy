// parse the question string
String question = params.q
question = question.substring(question.indexOf(":") + 1).trim()
System.err.println question

// some tools & gadgets :-)
// my url: http://192.168.200.180:8080/answers.groovy
// Eval.me('2 * 4 + 2')

if (question =~ /what is your name/) {
 println "GroovyGlase"
 return
}

if (question =~/th number in the Fibonacci sequence/) {
    question = question - "what is the "
    question = question - "th number in the Fibonacci sequence"
    System.err.println "fib $question is " + fib(question as int)
    println fib(question as int)
    return
}

def fib(n) { i < 2 ? 1 : fib(i - 2) + fib(i - 1) }

if (question =~ /what is*/) {
  question = question - "what is"
  question = question.replace('plus', '+')
  question = question.replace('multiplied by', '*')
  question = question.replace('minus', '-')
  println Eval.me(question)
  return
}

// which of the following numbers is the largest: 789, 48
if (question =~/which of the following numbers is the largest:/) {
  question = question - "which of the following numbers is the largest:"
  println question.split(',').collect { it.trim() as int }.max()
  return
}

// which of the following numbers is both a square and a cube:
if (question =~/which of the following numbers is both a square and a cube:/) {
  question = question - "which of the following numbers is both a square and a cube:"
  def numbers = question.split(',').collect { it.trim() as int }
  def found = numbers.findAll { isSquare(it) && isCube(it) }
  System.err.println found.join(', ')
  println found.join(', ')
  return
}

def isSquare(num) {
  (1..num).each { count ->
    if (count * count == num)
      return true
  }
  return false
}

def isCube(num) {
  (1..num).each { count ->
    if (count * count * count == num)
      return true
  }
  return false;
}

// which of the following numbers are primes:
if (question =~/which of the following numbers are primes:/) {
  question = question - "which of the following numbers are primes:"
  def numbers = question.split(',').collect { it.trim() as int }
  def found = numbers.findAll { num -> new BigInteger(num).isProbablePrime(99) }
  println found.join(', ')
  return
}

if (question =~/banana/) {
  println "yellow"
  return
}

if (question =~/Dr No/) {
  println "Sean Connery"
  return
}

if (question =~/Spain use before the Euro/) {
  println "Peseta"
  return
}

if (question =~/Prime Minister/) {
  println "David Cameron"
  return
}

if (question =~/Eiffel/) {
  println "Paris"
  return
}

// else print the question
println "I will answer this later..."
