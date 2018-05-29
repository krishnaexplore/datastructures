closure holds state and that is immutable

lazy evaluation/execution is to functional programming

abstraction
encapsulation
polymorphism is to Object Oriented programming
function composition

every main stream programming languages support functional




prime?
iterate through

focusing on the problem
number > 1 &&
Instream.range(2, number).
         noneMatch(index -> number % index ==0);

private static boolean isDivisible();

Lexical scoping

Predicate<Integer> isDivisible = divisor -> number % divisor == 0;

number > 1 &&
Instream.range(2, number).
         noneMatch(index isDivisible(index));





declarative

more highly expressive

Imperative
 how
 mutability

Functional
  what
  immutable


find the double of the first even number greater than 3
List<Integer> values = Arrays.asList(1,2,3,4,5,..)

int result = 0;
for(int e : values){
  if(e>3 && e% 2==0){
    result = e * 2;
    break;
  }
}
s.o.p(result)

values.stream()
.filter( e -> e > 3)
.filter( e -> e % 2 ==0)
.map(e -> e * 2)
.findFirst()
.get()

values.stream()
.filter( isGreaterThan3 (e))
.filter( isEven(e))
.map(doubleIt(e))
.findFirst()
.get()


isGreaterThan3(int number){
  syso("isGreaterThan3 "+number)
  return number > 3;
}
isEven(int number){
  syso("isEven")
  return number % 2 == 0;
}
isDoubleIt(int number){
 sop(doubleIt)
return number * number;
}
higher order functions
we can pass function to function


//Lazy
//composition

optimization

referential transparency


Heisenberg's uncertainty principle
logger.finest(getSomeStatusData())

Supplier



java 8:
Functiona interfaces in java 8
functional interface
functions
   function takes input and can return some other output
   R apply(T u)
   used in Stream.map
Primitive function  specilization
two-artiny function specilization
takes two inputs and can return output
BiConsumer
BiFunction
suppliers
 -> just supplies (doen't take any input)
      T get()
 -> used in Stream.collect
Consumer
  -> just consumes (doesn't return any output ofcourse void) opposite to supply
  -> used in ForEach of Iterable interface
  -> used in Stream.peek
Predicate
  -> takes the values and return boolean
  -> boolean test(T accept);
  -> used in filter of stream

Operators
 -> special case of function takes and returns same type like java.util.function.UnaryOperator


Streams
  intermediate operations
  terminal operations

 iterating
   for(String s : list){
      if(string.contains("a")){
        return true;
      }
   }

   boolean isExists = list.stream().anyMatch(element -> element.contains("a"))
  filtering
  mapping
    flatMap : If you have a stream where every element contains its own sequence of elements and you want to create a stream of these inner elements, you should use the flatMap() method:
  Matching
    anyMatch(), allMatch(), noneMatch()
  Reduction
    reduce
  collecting

  Stream creation : there are many ways to create stream instances from different sources. this instance will not change/modify its source
   Stream.empty()
   list.stream()
   Stream.of("a","b","c")
   String[] arr = {"a","b","c"}
   Arrays.stream(arr);
   Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
   Stream.generate( () -> "element" ).limit(10);
   Stream.iterate( 40, n->n+2).limit(10)

Stream Primitives
   IntStream intStream = IntStream.range(1,3)
   LongStream longStream = LongStream.range(1,10)

  since java 8 java.util.Random provides variety of stream generation methods
    Random rand = new Random()
    DoubleStream stream = rand.doubles(3)
  Stream of a file

    Path path = Paths.get("/user/krishna/abc.txt")
    Stream<String> streamOfLines = File.lines(path);
 Referencing Stream
   Stream can accessible through reference as long as we perform only intermediate operations, if we perform terminal operation and accessing again it throws IllegalStateException.
 Stream pipeline
   source,
   intermediate operations
   terminal operation
 Lazy Invocation
  intermediate operations are Lazy. THis means that they will be invoked only if it is necessary for the terminal operation execution

 Order of execution
   intermediate operations which reduce the size of the stream should be placed before operations which are applying to each element. So, keep such methods as skip(), filter(), distinct() at the top of your stream pipeline.

 Parallel Streams
 
