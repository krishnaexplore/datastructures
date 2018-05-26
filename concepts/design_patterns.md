Hexagonal Architecture




Domain : components clearly capture the application's core domain concepts. these classes are manifestation of ubiqutious language of the core domain

read about Ubiquitous Language : http://martinfowler.com/bliki/UbiquitousLanguage.html

Service : Components that handle the actions that can be performed when an event is recieved.

Given the integration between your application and the outside world, consider the following design and implemenation constraints:

	The user experience (UX) is your focus; the core application structure should not influence the design of the web front end
	The compoents that make up your web domain need to evolve at a rate that is appropriate for the many consumers that rely on your services

	your web compoents should not contain any core logic for your application, but they will collaborate with other components in the core domains of your application in order to orchestrate the necessary functionality for the service interace.

	

	
	
	
	
	
	
Algorithms
---------------	
	
	
1) Prime number
2) fibnoccii
3) palidrome
4) sorting
5) searching


6) tower of Hanoi - no of movements - n disks ( 2 power n -1 ). eg. n=3, 2 pwr of 3 -1 = 7


1,1,2,3,5,8,13,


j=0
k=1

for(i=2;i<number;i++)
{
	
	i =j;
	j
}
0 1 1 2 3 5 8 13 21 34 55 89




What is Big O Analysis in computer science – a tutorial:

When solving a computer science problem there will usually be more than just one solution. These solutions will often be in the form of different algorithms, and you will generally want to compare the algorithms to see which one is more efficient.

This is where Big O analysis helps – it gives us some basis for measuring the efficiency of an algorithm. A more detailed explanation of Big O analysis would be this: it measures the efficiency of an algorithm based on the time it takes for the algorithm to run as a function of the input size. Think of the input simply as what goes into a function – whether it be an array of numbers, a linked list, etc.

Sounds quite boring, right?

It’s really not that bad at all – and it is something best illustrated by an example with actual code samples.

Let’s suppose that we are given a problem in which we want to create a function that, when given an array of integers greater than 0, will return the integer that is the smallest in that array. In order to best illustrate the way Big-O analysis works, we will come up with two different solutions to this problem, each with a different Big-O efficiency.

Here’s our first function that will simply return the integer that is the smallest in the array. The algorithm will just iterate through all of the values in the array and keep track of the smallest integer in the array in the variable called curMin.

Let’s assume that the array being passed to our function contains 10 elements – this number is something we arbitrarily chose. We could have said it contains 100, or 100000 elements – either way it would have made no difference for our purposes here.

The CompareSmallestNumber Java function
int CompareSmallestNumber (int array[ ])
{
	int x, curMin;
	
	// set smallest value to first item in array
	curMin = array[0];

	/* iterate through array to find smallest value
	    and also assume there are only 10 elements
        */
        for (x = 1; x < 10; x++)
	{
		if( array[x] < curMin)  {
		curMin = array[x];
		}
	}

	// return smallest value in the array
	return curMin;
}

As promised, we want to show you another solution to the problem. In this solution, we will use a different algorithm. What we do is compare each value in the array to all of the other numbers in the array, and if that value is less than or equal to all of the other numbers in the array then we know that it is the smallest number in the array.

The CompareToAllNumbers Java function

int CompareToAllNumbers (int array[ ])
{
bool is Min;

int x, y;

/* iterate through each element in array,
    assuming there are only 10 elements:
*/

for (int x = 0; x < 10; x++)
{
	isMin = true;

	for (int y = 0; y < 10; y++)
	{

	/* compare the value in array[x] to the other values
	if we find that array[x] is greater than any of the 
        values in array[y] then we know that the value in 
        array[x] is not the minimum
	
	remember that the 2 arrays are exactly the same, we 
        are just taking out one value with index 'x' and 
        comparing to the other values in the array with 
        index 'y'
	*/	
		
	if( array[x] > array[y])
	isMin = false;	
	
	}
		
	if(isMin)
		break;
}
	
	return array[x];
}
Now, you've seen 2 functions that solve the same problem - but each one uses a different algorithm. We want to be able to say which algorithm is more efficient using mathematical terms, and Big-O analysis allows us to do exactly that.

Big O analysis of algorithms

For our purposes, we assumed an input size of 10 for the array. But when doing Big O analysis, we don't want to use specific numbers for the input size - so we say that the input is of size n.

Remember that Big-O analysis is used to measure the efficiency of an algorithm based on the time it takes for the algorithm to run as a function of the input size.

When doing Big-O analysis, "input" can mean a lot of different things depending on the problem being solved. In our examples above, the input is the array that is passed into the different functions. But, input could also be the number of elements of a linked list, the nodes in a tree, or whatever data structure you are dealing with.

So, the real question is how Big-O analysis measures efficiency. Basically, Big-O will want to express how many times the 'n' input items are 'touched'. The word 'touched' can mean different things in different algorithms - in some algorithms it may mean the number of times a constant is multiplied by an input item, the number of times an input is added to a data structure, etc.

But in our functions CompareSmallestNumber and CompareToAllNumbers, it just means the number of times an array value is compared to another value.

Since input is of size n, and in our example the input is an array - we will say that the array is of size n. We will use the 'n' to denote input size in our Big-O analysis.

Big O notation time complexity

In the function CompareSmallestNumber, the n (we used 10 items, but lets just use the variable 'n' for now) input items are each 'touched' only once when each one is compared to the minimum value. In Big O notation, this would be written as O(n) - which is also known as linear time. Linear time means that the time taken to run the algorithm increases in direct proportion to the number of input items. So, 80 items would take longer to run than 79 items or any quantity less than 79. Another way to phrase this is to say that the algorithm being used in the CompareSmallestNumber function has order of n time complexity.

You might also see that in the CompareSmallestNumber function, we initialize the curMin variable to the first value of the input array. And that does count as 1 'touch' of the input. So, you might think that our Big O notation should be O(n + 1). But actually, Big O is concerned with the running time as the number of inputs - which is 'n' in this case - approaches infinity. And as 'n' approaches infinity the constant '1' becomes very insignificant - so we actually drop the constant. Thus, we can say that the CompareSmallestNumber function has O(n) and not O(n + 1).

Also, if we have n3 + n, then as n approaches infinity it's clear that the "+ n" becomes very insignificant - so we will drop the "+ n", and instead of having O(n3 + n), we will have O(n3), or order of n3 time complexity.


What is Big O notation worst case?

Now, let's do the Big O analysis of the CompareToAllNumbers function. The worst case of Big O notation in our example basically means that we want to find the scenario which will take the longest for the CompareToAllNumbers function to run. When does that scenario occur?

Well, let's think about what the worst case running time for the CompareToAllNumbers function is and use that as the basis for the Big O notation. So, for this function, let's assume that the smallest integer is in the very last element of the array - because that is the exact scenario which will take the longest to run since it will have to get to the very last element to find the smallest element. Since we are taking each element in the array and comparing it to every other element in the array, that means we will be doing 100 comparisons - assuming, of course, that our input size is 10 (10 * 10 = 100). Or, if we use a variable "n" to represent the input size, that will be n2 'touches' of the input size. Thus, this function uses a O(n2 ) algorithm.

Big O analysis measures efficiency

Now, let's compare the 2 functions: CompareToAllNumbers is O(n2) and CompareSmallestNumber is O(n). So, let's say that we have 10,000 input elements, then CompareSmallestNumber will 'touch' on the order of 10,000 elements, whereas CompareToAllNumbers will 'touch' 10,000 squared or 100,000,000 elements. That's a huge difference, and you can imagine how much faster CompareSmallestNumber must run when compared to CompareToAllNumbers - especially when given a very large number of inputs. Efficiency is something that can make a huge difference and it's important to be aware of how to create efficient solutions.

In an interview, you may be asked what the Big-O of an algorithm that you've come up with is. And even if not directly asked, you should provide that information in order to show that you are well aware of the need to come up with an efficient solution whenever possible.

	
--------------------------------------------------------------------------------------------------------------------------------
Design Patterns

1) Template Method design pattern used in spring controller implementations as well as for JDBCTemplate, JMSTemplate, JPATemplate
2) Proxy  used in AOP and Remoting
3) Singleton
4) mvc
5) front controller design pattern
6) IOC
7) Factory patten - BeanFactory and Application Context
8) Composite View (Struts Tiles)
9) Proto type  used in spring to create multiple proto type instances
10) Decorator is for cross cutting functionality.. 


Creational
1) Singleton
2) Factory
3) Abstract Factory
4) Factory Method
5) Prototype
6) Proxy Pattern
7) 


Design patterns used in Java 

Creational Pattern

Factory Method      -  getInstance() method in java.util.Calendar
Singleton           -  java.lang.System and java.sql.DriverManager although they are not implemented using the approach recommended in the GoF book but with static methods.
Prototype pattern   -  clone() method defined in class Object and the use of java.lang.Cloneable interface to grant permission for cloning.
Proxy pattern       -  is used extensively in the implementation of Java's Remote Method Invocation (RMI) and Interface Definition Language (IDL) features
Decorator 			-  The java.io package provides, among other things, a set of classes for reading input streams. Known as readers, each of those classes has a name that follows the pattern: xxxReader.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Template Method Pattern:
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
If we take a look at the dictionary definition of a template we can see that a template is a preset format, used as a starting point for a particular application so that the format does not have to be recreated each time it is used.
On the same idea is the template method is based. A template method defines an algorithm in a base class using abstract operations that subclasses override to provide concrete behavior.

Intent:
-Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
-Template Method lets subclasses redefine certain steps of an algorithm without letting them to change the algorithm's structure.

The template method fixes the order of operations, but allows Application subclasses to vary those steps as needed.

AbstractClass
	final templateMethod(){
		operationA();
		operationB();
	}
	abstract operationA();
	abstract operationB();
	operationC(){
		print("opertion C is common");
	}
ConcretClass extends AbstractClass{
	operationA(){
		print(do operation a);
	}
	operationB(){
		print(do operation b);
	}
}

ConcretClass2 extends AbstractClass{
	operationA(){
		print(do opeation a);
		operationA_1();
	}
	operationA_1(){
		print(do operation A_1);
	}
	operationB(){
		print(do operation b);
	}
}

Client{
	AbstractClass a = new ConcretClass();
	a.templateMethod();
	
	AbstractClass b = new ConcretClass2();
	b.templateMethod();
}
output: 
	do operation a
	do operation b
	operation c is common
	
	do operation a
	do operation A_1
	do operation b
	do C is common

Applicability
Use the Template Method pattern:
	To implement the invariant parts of an algorithm once and leave it up to subclasses to implement the behavior that can vary
	To localize common behavior among subclasses and place it in a common class (in this case, a superclass) to avoid code duplication. This is a classic example of ”code refactoring.”
	To control how subclasses extend superclass operations. You can define a template method that calls "hook" operations at specific points, thereby permitting extensions only at those points.
	The Template Method is a fundamental technique for code reuse.
	
Implementation Issues
	Operations which must be overridden by a subclass should be made abstract
	If the template method itself should not be overridden by a subclass, it should be made final.
	To allow a subclass to insert code at a specific spot in the operation of the algorithm, insert “hook” operations into the template method. These hook operations may do nothing by default.
	Try to minimize the number of operations that a subclass must override, otherwise using the template method becomes tedious for the developer
	In a template method, the parent class calls the operations of a subclass and not the other way around. This is an inverted control structure that's sometimes referred to as "the Hollywood principle," as in, "Don't call us, we'll call you".
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Proxy Pattern (Structural pattern)
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Sometimes we need the ability to control the access to an object. For example if we need to use only a few methods of some costly objects we'll initialize those objects when we need them entirely. Until that point we can use some light objects exposing the same interface as the heavy objects. These light objects are called proxies and they will instantiate those heavy objects when they are really need and by then we'll use some light objects instead.
This ability to control the access to an object can be required for a variety of reasons: 

1) controlling when a costly object needs to be instantiated and initialized, 
2) giving different access rights to an object, 
3) as well as providing a sophisticated means of accessing and referencing objects running in other processes, on other machines.

Consider for example an image viewer program. An image viewer program must be able to list and display high resolution photo objects that are in a folder, but how often do someone open a folder and view all the images inside. Sometimes you will be looking for a particular photo, sometimes you will only want to see an image name. The image viewer must be able to list all photo objects, but the photo objects must not be loaded into memory until they are required to be rendered.


Intent
The intent of this pattern is to provide a ?Placeholder? for an object to control references to it.

The participants classes in the proxy pattern are:
	Subject - Interface implemented by the RealSubject and representing its services. The interface must be implemented by the proxy as well so that the proxy can be used in any location where the RealSubject can be used.
Proxy
	Maintains a reference that allows the Proxy to access the RealSubject.
	Implements the same interface implemented by the RealSubject so that the Proxy can be substituted for the RealSubject.
	Controls access to the RealSubject and may be responsible for its creation and deletion.
	Other responsibilities depend on the kind of proxy.
RealSubject - the real object that the proxy represents.


Description

A client obtains a reference to a Proxy, the client then handles the proxy in the same way it handles RealSubject and thus invoking the method doSomething(). At that point the proxy can do different things prior to invoking RealSubject?s doSomething() method. The client might create a RealSubject object at that point, perform initialization, check permissions of the client to invoke the method, and then invoke the method on the object. The client can also do additional tasks after invoking the doSomething() method, such as incrementing the number of references to the object.

Applicability & Examples

The Proxy design pattern is applicable when there is a need to control access to an Object, as well as when there is a need for a sophisticated reference to an Object. Common Situations where the proxy pattern is applicable are:
	Virtual Proxies:
		delaying the creation and initialization of expensive objects until needed, where the objects are created on demand (For example creating the RealSubject object only when the doSomething method is invoked).
	Remote Proxies:
		providing a local representation for an object that is in a different address space. A common example is Java RMI stub objects. The stub object acts as a proxy where invoking methods on the stub would cause the stub to communicate and invoke methods on a remote object (called skeleton) found on a different machine.
	Protection Proxies: 
		where a proxy controls access to RealSubject methods, by giving access to some objects while denying access to others.
	Smart References:
		providing a sophisticated access to certain objects such as tracking the number of references to an object and denying access if a certain number is reached, as well as loading an object from database into memory on demand.
Example - Virtual Proxy Example.
	Consider an image viewer program that lists and displays high resolution photos. The program has to show a list of all photos however it does not need to display the actual photo until the user selects an image item from a list.
	
	see the diagram(proxy-design-pattern-image-example-uml-class-diagram.png)
	
	The code below shows the Image interface representing the Subject. The interface has a single method showImage() that the Concrete Images must implement to render an image to screen.
	package proxy;

/**
 * Subject Interface
 */
public interface Image {

	public void showImage();
	
}

The code below shows the Proxy implementation, the image proxy is a virtual proxy that creates and loads the actual image object on demand, thus saving the cost of loading an image into memory until it needs to be rendered:

package proxy;

/**
 * Proxy
 */
public class ImageProxy implements Image {

	/**
	 * Private Proxy data 
	 */
	private String imageFilePath;
	
	/**
	 * Reference to RealSubject
	 */
	private Image proxifiedImage;
	
	
	public ImageProxy(String imageFilePath) {
		this.imageFilePath= imageFilePath;	
	}
	
	@Override
	public void showImage() {

		// create the Image Object only when the image is required to be shown
		
		proxifiedImage = new HighResolutionImage(imageFilePath);
		
		// now call showImage on realSubject
		proxifiedImage.showImage();
		
	}

}

The code below displays the RealSubject Implementation, which is the concrete and heavyweight implementation of the image interface. The High resolution image, loads a high resolution image from disk, and renders it to screen when showImage() is called.

package proxy;

/**
 * RealSubject
 */
public class HighResolutionImage implements Image {

	public HighResolutionImage(String imageFilePath) {
		
		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {

		// load Image from disk into memory
		// this is heavy and costly operation
	}

	@Override
	public void showImage() {

		// Actual Image rendering logic

	}

}

The code below illustrates a sample image viewer program; the program simply loads three images, and renders only one image, once using the proxy pattern, and another time directly. Note that when using the proxy pattern, although three images have been loaded, the High resolution image is not loaded into memory until it needs to be rendered, while in the part not using the proxy, the three images are loaded into memory although one of them is actually rendered.

package proxy;

/**
 * Image Viewer program
 */
public class ImageViewer {

	
	public static void main(String[] args) {
		
	// assuming that the user selects a folder that has 3 images	
	//create the 3 images 	
	Image highResolutionImage1 = new ImageProxy("sample/veryHighResPhoto1.jpeg");
	Image highResolutionImage2 = new ImageProxy("sample/veryHighResPhoto2.jpeg");
	Image highResolutionImage3 = new ImageProxy("sample/veryHighResPhoto3.jpeg");
	
	// assume that the user clicks on Image one item in a list
	// this would cause the program to call showImage() for that image only
	// note that in this case only image one was loaded into memory
	highResolutionImage1.showImage();
	
	// consider using the high resolution image object directly
	Image highResolutionImageNoProxy1 = new HighResolutionImage("sample/veryHighResPhoto1.jpeg");
	Image highResolutionImageNoProxy2 = new HighResolutionImage("sample/veryHighResPhoto2.jpeg");
	Image highResolutionImageBoProxy3 = new HighResolutionImage("sample/veryHighResPhoto3.jpeg");
	
	
	// assume that the user selects image two item from images list
	highResolutionImageNoProxy2.showImage();
	
	// note that in this case all images have been loaded into memory 
	// and not all have been actually displayed
	// this is a waste of memory resources
	
	}
		
}

Specific problems and implementation


Java Remote Method Invocation (RMI)

In java RMI an object on one machine (executing in one JVM) called a client can invoke methods on an object in another machine (another JVM) the second object is called a remote object. The proxy (also called a stub) resides on the client machine and the client invokes the proxy in as if it is invoking the object itself (remember that the proxy implements the same interface that RealSubject implements). The proxy itself will handle communication to the remote object, invoke the method on that remote object, and would return the result if any to the client. The proxy in this case is a Remote proxy.


Related Patterns

Adapter Design Pattern - The adapter implements a different interface to the object it adapts where a proxy implements the same interface as its subject.
Decorator Design Pattern - A decorator implementation can be the same as the proxy however a decorator adds responsibilities to an object while a proxy controls access to it.

Consequences

Known Uses:

Java RMI as has been explained implements a remote proxy
Security Proxies that controls access to objects can be found in many object oriented languages including java, C#, C++.


-----------------------------------------------------------------------
Dependency Inversion Principle
---------------------------------

Motivation

In an application we have low level classes which implement basic and primary operations and high level classes which encapsulate complex logic and rely on the low level classes. A natural way of implementing such structures would be to write low level classes and once we have them to write the complex high level classes. Since the high level classes are defined in terms of others this seems the logical way to do it. But this is not a flexible design. What happens if we need to replace a low level class?

Let's take the classical example of a copy module which read characters from keyboard and write them to the printer device. The high level class containing the logic is the Copy class. The low level classes are KeyboardReader and PrinterWriter.

In a bad design the high level class uses directly the low level classes. In this case if we want to change the design to direct the output to a new FileWriter class we have to change the Copy class. (Let's assume that it is a very complex class, with a lot of logic and realy hard to test).

In order to avoid such problems we can introduce an abstraction layer between the high level classes and low level classes. Since the high level modules contains the complex logic they should not depend on the low level modules and that the new abstraction layer should not be created based on low level modules. The low level modules are created based on the abstraction layer.

According to this principle the way of designing a class structure is to start from high level modules to the low level modules:
High Level Classes --> Abstraction Layer --> Low Level Classes

Intent

High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend on details. Details should depend on abstractions.

Example

Below is an example which violates the Dependency Inversion Principle. We have the manager class which is a high level class, and the low level class Worker. We need to add a new module to our application because in the company there are some new specialized workers employed. We created a new class SuperWorker for this.

Let's assume that the Manager class is a complex one containing a very complex logic. And now we have to change it in order to introduce the new SuperWorker. Let's see the disadvantages:
we have to change the Manager class (remember it is a complex one and this will involve some time and effort).
some present functionality from the manager class might be affected.
the unit testing should be redone.
All those problems will take a lot of time to solve. Now it would be very simple if the application was designed following the Dependency Inversion Principle. That means that we design the manager class, an IWorker interface and the Worker class implementing the IWorker interface. When we need to add the SuperWorker class all we have to do is implement the IWorker interface for it.

In order to have more dramatic effect, just imagine that the Graphic Editor is a big class, with a lot of functionallity inside, written and changed by many developpers, while the a shape might be a class implemented only by one developer. In this case it would be great improvment to allow the adding of a new shape without changing the GraphicEditor class.

// Dependency Inversion Principle - Bad example
class Worker {
	public void work() {
		// ....working
	}
}

class Manager {
	Worker m_worker;

	public void setWorker(Worker w) {
		m_worker=w;
	}

	public void manage() {
		m_worker.work();
	}
}

class SuperWorker {
	public void work() {
		//.... working much more
	}
}

Below is the code which supports the Dependency Inversion Principle. In this new design a new abstraction layer is added through the IWorker Interface. Now the problems from the above code are solved:

Manager class should not be changed.
minimized risk to affect old funtionallity present in Manager class.
no need to redone the unit testing for Manager class.

// Dependency Inversion Principle - Good example
interface IWorker {
	public void work();
}

class Worker implements IWorker{
	public void work() {
		// ....working
	}
}

class SuperWorker  implements IWorker{
	public void work() {
		//.... working much more
	}
}

class Manager {
	IWorker m_worker;

	public void setWorker(IWorker w) {
		m_worker=w;
	}

	public void manage() {
		m_worker.work();
	}
}

Conclusion

When this principle is applied it means that the high level classes are not working directly with low level classes, they are using interfaces as an abstract layer. In that case the creation of new low level objects inside the high level classes(if necessary) can not be done using the operator new. Instead, some of the Creational design patterns can be used, such as Factory Method, Abstract Factory, Prototype.

The Template Design Pattern is an example where the DIP principle is applied.

Of course, using this principle implies an increased effort and a more complex code, but more flexible. This principle can not be applied for every class or every module. If we have a class functionality that is more likely to remain unchanged in the future there is not need to apply this principle.

----------------------------------------------------------------------------------------------------------------------------------------
Singleton Pattern
----------------------------------------------------------------------------------------------------------------------------------------
Motivation
	Sometimes it's important to have only one instance for a class. For example, 
	1) in a system there should be only one window manager (or only a file system or only a print spooler). Usually singletons are used for centralized management of internal or external resources and they provide a global point of access to themselves.

	The singleton pattern is one of the simplest design patterns: it involves only one class which is responsible to instantiate itself, to make sure it creates not more than one instance; in the same time it provides a global point of access to that instance. In this case the same instance can be used from everywhere, being impossible to invoke directly the constructor each time.
	
Intent
	Ensure that only one instance of a class is created.
	Provide a global point of access to the object.
Implementation
	The implementation involves a static member in the "Singleton" class, a private constructor and a static public method that returns a reference to the static member.
	see the singleton_implementation_-_uml_class_diagram.gif
	
The Singleton Pattern defines a getInstance operation which exposes the unique instance which is accessed by the clients. getInstance() is is responsible for creating its class unique instance in case it is not created yet and to return that instance.

class Singleton
{
	private static Singleton instance;
	private Singleton()
	{
		...
	}

	public static synchronized Singleton getInstance()
	{
		if (instance == null)
			instance = new Singleton();

		return instance;
	}
	...
	public void doSomething()
	{
		...	
	}
}

You can notice in the above code that getInstance method ensures that only one instance of the class is created. The constructor should not be accessible from the outside of the class to ensure the only way of instantiating the class would be only through the getInstance method.

The getInstance method is used also to provide a global point of access to the object and it can be used in the following manner:
Singleton.getInstance().doSomething();

Applicability & Examples
According to the definition the singleton pattern should be used when there must be exactly one instance of a class, and when it must be accessible to clients from a global access point. Here are some real situations where the singleton is used:

Example 1 - Logger Classes
The Singleton pattern is used in the design of logger classes. This classes are ussualy implemented as a singletons, and provides a global logging access point in all the application components without being necessary to create an object each time a logging operations is performed.

Example 2 - Configuration Classes

The Singleton pattern is used to design the classes which provides the configuration settings for an application. By implementing configuration classes as Singleton not only that we provide a global access point, but we also keep the instance we use as a cache object. When the class is instantiated( or when a value is read ) the singleton will keep the values in its internal structure. If the values are read from the database or from files this avoids the reloading the values each time the configuration parameters are used.

Example 3 - Accesing resources in shared mode

It can be used in the design of an application that needs to work with the serial port. Let's say that there are many classes in the application, working in an multi-threading environment, which needs to operate actions on the serial port. In this case a singleton with synchronized methods could be used to be used to manage all the operations on the serial port.

Example 4 - Factories implemented as Singletons

Let's assume that we design an application with a factory to generate new objects(Acount, Customer, Site, Address objects) with their ids, in an multithreading environment. If the factory is instantiated twice in 2 different threads then is possible to have 2 overlapping ids for 2 different objects. If we implement the Factory as a singleton we avoid this problem. Combining Abstract Factory or Factory Method and Singleton design patterns is a common practice.

Specific problems and implementation


Thread-safe implementation for multi-threading use.

A robust singleton implementation should work in any conditions. This is why we need to ensure it works when multiple threads uses it. As seen in the previous examples singletons can be used specifically in multi-threaded application to make sure the reads/writes are synchronized.
Lazy instantiation using double locking mechanism.

The standard implementation shown in the above code is a thread safe implementation, but it's not the best thread-safe implementation beacuse synchronization is very expensive when we are talking about the performance. We can see that the synchronized method getInstance does not need to be checked for syncronization after the object is initialized. If we see that the singleton object is already created we just have to return it without using any syncronized block. This optimization consist in checking in an unsynchronized block if the object is null and if not to check again and create it in an syncronized block. This is called double locking mechanism.

In this case case the singleton instance is created when the getInstance() method is called for the first time. This is called lazy instantiation and it ensures that the singleton instance is created only when it is needed.

//Lazy instantiation using double locking mechanism.
class Singleton
{
	private static Singleton instance;

	private Singleton()
	{
	System.out.println("Singleton(): Initializing Instance");
	}

	public static Singleton getInstance()
	{
		if (instance == null)
		{
			synchronized(Singleton.class)
			{
				if (instance == null)
				{
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new Singleton();
				}
			}            
		}

		return instance;
	}

	public void doSomething()
	{
		System.out.println("doSomething(): Singleton does something!");
	}
}

A detialed discussion(double locking mechanism) can be found on http://www-128.ibm.com/developerworks/java/library/j-dcl.html?loc=j
Early instantiation using implementation with static field
In the following implementattion the singleton object is instantiated when the class is loaded and not when it is first used, due to the fact that the instance member is declared static. This is why in we don't need to synchronize any portion of the code in this case. The class is loaded once this guarantee the uniquity of the object.
Singleton - A simple example (java)

//Early instantiation using implementation with static field.
class Singleton
{
	private static Singleton instance = new Singleton();

	private Singleton()
	{
		System.out.println("Singleton(): Initializing Instance");
	}

	public static Singleton getInstance()
	{    
		return instance;
	}

	public void doSomething()
	{
		System.out.println("doSomething(): Singleton does something!");
	}
}

Protected constructor

It is possible to use a protected constructor to in order to permit the subclassing of the singeton. This techique has 2 drawbacks that makes singleton inheritance impractical:

First of all, if the constructor is protected, it means that the class can be instantiated by calling the constructor from another class in the same package. A possible solution to avoid it is to create a separate package for the singleton.

Second of all, in order to use the derived class all the getInstance calls should be changed in the existing code from Singleton.getInstance() to NewSingleton.getInstance().

Multiple singleton instances if classes loaded by different classloaders access a singleton.

If a class(same name, same package) is loaded by 2 diferent classloaders they represents 2 different clasess in memory.

Serialization

If the Singleton class implements the java.io.Serializable interface, when a singleton is serialized and then deserialized more than once, there will be multiple instances of Singleton created. In order to avoid this the readResolve method should be implemented. See Serializable () and readResolve Method () in javadocs.

public class Singleton implements Serializable {
		...

		// This method is called immediately after an object of this class is deserialized.
		// This method returns the singleton instance.
		protected Object readResolve() {
			return getInstance();
		}
	}
	
Abstract Factory and Factory Methods implemented as singletons.

There are certain situations when the a factory should be unique. Having 2 factories might have undesired effects when objects are created. To ensure that a factory is unique it should be implemented as a singleton. By doing so we also avoid to instantiate the class before using it.

Hot Spot:

Multithreading - A special care should be taken when singleton has to be used in a multithreading application.
Serialization - When Singletons are implementing Serializable interface they have to implement readResolve method in order to avoid having 2 different objects.
Classloaders - If the Singleton class is loaded by 2 different class loaders we'll have 2 different classes, one for each class loader.
Global Access Point represented by the class name - The singleton instance is obtained using the class name. At the first view this is an easy way to access it, but it is not very flexible. If we need to replace the Sigleton class, all the references in the code should be changed accordinglly.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Factory Pattern
------------------------------------------------------------------------------------------------------------------
Motivation
	The Factory Design Pattern is probably the most used design pattern in modern programming languages like Java and C#. It comes in different variants and implementations. If you are searching for it, most likely, you'll find references about the GoF patterns: Factory Method and Abstract Factory.
	
	In this article we'll describe a flavor of factory pattern commonly used nowdays. You can also check the original Factory Method pattern which is very similar.
	
Intent
	creates objects without exposing the instantiation logic to the client.
	refers to the newly created object through a common interface
Implementation
		see factory implementation.gif
The implementation is really simple
	The client needs a product, but instead of creating it directly using the new operator, it asks the factory object for a new product, providing the information about the type of object it needs.
	The factory instantiates a new concrete product and then returns to the client the newly created product(casted to abstract product class).
	The client uses the products as abstract products without being aware about their concrete implementation.
Applicability & Examples
	Probably the factory pattern is one of the most used patterns.
	For example a graphical application works with shapes. In our implementation the drawing framework is the client and the shapes are the products. All the shapes are derived from an abstract shape class (or interface). The Shape class defines the draw and move operations which must be implemented by the concrete shapes. Let's assume a command is selected from the menu to create a new Circle. The framework receives the shape type as a string parameter, it asks the factory to create a new shape sending the parameter received from menu. The factory creates a new circle and returns it to the framework, casted to an abstract shape. Then the framework uses the object as casted to the abstract class without being aware of the concrete object type.
	
	The advantage is obvious: New shapes can be added without changing a single line of code in the framework(the client code that uses the shapes from the factory). As it is shown in the next sections, there are certain factory implementations that allow adding new products without even modifying the factory class.
	
	Specific problems and implementation
	
	Procedural Solution - switch/case noob instantiation.
		see factory noob implementation.gif
Those are also known as parameterized Factories. The generating method can be written so that it can generate more types of Product objects, using a condition (entered as a method parameter or read from some global configuration parameters - see abstract factory pattern) to identify the type of the object that should be created, as below:

public class ProductFactory{
	public Product createProduct(String ProductID){
		if (id==ID1)
			return new OneProduct();
		if (id==ID2) return
			return new AnotherProduct();
		... // so on for the other Ids
		
        return null; //if the id doesn't have any of the expected values
    }
    ...
}

This implementation is the most simple and intuitive (Let's call it noob implementation). The problem here is that once we add a new concrete product call we should modify the Factory class. It is not very flexible and it violates open close principle. Of course we can subclass the factory class, but let's not forget that the factory class is usually used as a singleton. Subclassing it means replacing all the factory class references everywhere through the code.

Class Registration - using reflection

If you can use reflection, for example in Java or .NET languages, you can register new product classes to the factory without even changing the factory itself. For creating objects inside the factory class without knowing the object type we keep a map between the productID and the class type of the product. In this case when a new product is added to the application it has to be registered to the factory. This operation doesn't require any change in the factory class code.

class ProductFactory
{
	private HashMap m_RegisteredProducts = new HashMap();

	public void registerProduct (String productID, Class productClass)
	{
		m_RegisteredProducts.put(productID, productClass);
	}

	public Product createProduct(String productID)
	{
		Class productClass = (Class)m_RegisteredProducts.get(productID);
		Constructor productConstructor = cClass.getDeclaredConstructor(new Class[] { String.class });
		return (Product)productConstructor.newInstance(new Object[] { });
	}
}

We can put the registration code anywhere in our code, but a convenient place is inside the product class in a static constructor. Look at the example below:

1. Registration done outside of product classes:

public static void main(String args[]){
		Factory.instance().registerProduct("ID1", OneProduct.class);
	} 
	
2. Registration done inside the product classes:


class OneProduct extends Product
{
	static {
		Factory.instance().registerProduct("ID1",OneProduct.class);
	}
	...
}

We have to make sure that the concrete product classes are loaded before they are required by the factory for registration(if they are not loaded they will not be registered in the factory and createProduct will return null). To ensure it we are going to use the Class.forName method right in the static section of the main class. This section is executed right after the main class is loaded. Class.forName is supposed to return a Class instance of the indicated class. If the class is not loaded by the compiler yet, it will be loaded when the Class.forName is invoked. Consequently the static block in each class will be executed when each class is loaded:

class Main
{
	static
	{
		try
		{
			Class.forName("OneProduct");
			Class.forName("AnotherProduct");
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}
	public static void main(String args[]) throws PhoneCallNotRegisteredException
	{
		...
	}
}

This reflection implementation has its own drawbacks. The main one is performance. When the reflection is used the performance on code involving reflection can decrease even to 10% of the poerfomance of a non reflection code. Another issue is that not all the programming languages provide reflection mechanism.

Class Registration - avoiding reflection

As we saw in the previous paragraph the factory object uses internally a HashMap to keep the mapping between parameters (in our case Strings) and concrete products class. The registration is made from outside of the factory and because the objects are created using reflection the factory is not aware of the objects types.

We don't want to use reflection but in the same time we want to have a reduced coupling between the factory and concrete products. Since the factory should be unaware of products we have to move the creation of objects outside of the factory to an object aware of the concrete products classes. That would be the concrete class itself.

We add a new abstract method in the product abstract class. Each concrete class will implement this method to create a new object of the same type as itself. We also have to change the registration method such that we'll register concrete product objects instead of Class objects.

abstract class Product
{
	public abstract Product createProduct();
	...
}

class OneProduct extends Product
{
	...
	static
	{
		ProductFactory.instance().registerProduct("ID1", new OneProduct());
	}
	public OneProduct createProduct()
	{
		return new OneProduct();
	}
	...
}

class ProductFactory
{
	public void registerProduct(String productID, Product p)    {
		m_RegisteredProducts.put(productID, p);
	}

	public Product createProduct(String productID){
		((Product)m_RegisteredProducts.get(productID)).createProduct();
	}
}

A more advanced solution - Factory design pattern with abstractions(Factory Method)
	see factory design pattern with abstractions.gif
	
This implementation represents an alternative for the class registration implementation. Let's assume we need to add a new product to the application. For the procedural switch-case implementation we need to change the Factory class, while in the class registration implementation all we need is to register the class to the factory without actually modifying the factory class. For sure this is a flexible solution.

The procedural implementation is the classical bad example for the Open-Close Principle. As we can see there the most intuitive solution to avoid modifying the Factory class is to extend it.
This is the classic implementation of the factory method pattern. There are some drawbacks over the class registration implementation and not so many advantages:

+ The derived factory method can be changed to perform additional operations when the objects are created (maybe some initialization based on some global parameters ...).
The factory can not be used as a singleton.
Each factory has to be initialized before using it.
 More difficult to implement.
 If a new object has to be added a new factory has to be created.
 Anyway, this classic implementation has the advantage that it will help us understanding the Abstract Factory design pattern.

 Conclusion
 When you design an application just think if you really need it a factory to create objects. Maybe using it will bring unnecessary complexity in your application. If you have many objects of the same base type and you manipulate them mostly casted to abstract types, then you need a factory. If you're code should have a lot of code like the following, you should reconsider it:
 
 (if (ConcreteProduct)genericProduct typeof )
	((ConcreteProduct)genericProduct).doSomeConcreteOperation().
	
	If you decided to go for a factory, I would recommend using one of class registration implementations(with or without reflection) and to avoid the Factory Method (Factory design pattern with abstractions). Please note the procedural switch-case (noob) implementation is the simplest, violates the OCP principle is used only to explain the theory. The only wise way to use it is for temporary modules until it is replaced with a real factory.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Factory Method Pattern
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Motivation
		Also known as Virtual Constructor, the Factory Method is related to the idea on which libraries work: a library uses abstract classes for defining and maintaining relations between objects. One type of responsibility is creating such objects. The library knows when an object needs to be created, but not what kind of object it should create, this being specific to the application using the library.
		
		The Factory method works just the same way: it defines an interface for creating an object, but leaves the choice of its type to the subclasses, creation being deferred at run-time. A simple real life example of the Factory Method is the hotel. When staying in a hotel you first have to check in. The person working at the front desk will give you a key to your room after you've paid for the room you want and this way he can be looked at as a ?room? factory. While staying at the hotel, you might need to make a phone call, so you call the front desk and the person there will connect you with the number you need, becoming a ?phone-call? factory, because he controls the access to calls, too.
		
Intent
	Defines an interface for creating objects, but let subclasses to decide which class to instantiate
	Refers to the newly created object through a common interface
Implementation
	The pattern basically works as shown below, in the UML diagram:
	see factory method implementation - uml class diagram.gif
The participants classes in this pattern are:
	Product defines the interface for objects the factory method creates.
	ConcreteProduct implements the Product interface.
	Creator(also refered as Factory because it creates the Product objects) declares the method FactoryMethod, which returns a Product object. May call the generating method for creating Product objects
	ConcreteCreator overrides the generating method for creating ConcreteProduct objects
All concrete products are subclasses of the Product class, so all of them have the same basic implementation, at some extent. The Creator class specifies all standard and generic behavior of the products and when a new product is needed, it sends the creation details that are supplied by the client to the ConcreteCreator. Having this diagram in mind, it is easy for us now to produce the code related to it. Here is how the implementation of the classic Factory method should look:

public interface Product { ? }

public abstract class Creator 
{
	public void anOperation() 
	{
		Product product = factoryMethod();
	}
	
	protected abstract Product factoryMethod();
}

public class ConcreteProduct implements Product { ? }

public class ConcreteCreator extends Creator 
{
	protected Product factoryMethod() 
	{
		return new ConcreteProduct();
	}
}

public class Client 
{
	public static void main( String arg[] ) 
	{
		Creator creator = new ConcreteCreator();
		creator.anOperation();
	}
}

Applicability & Examples
The need for implementing the Factory Method is very frequent. The cases are the ones below:
	when a class can't anticipate the type of the objects it is supposed to create
	when a class wants its subclasses to be the ones to specific the type of a newly created object
Example 1 - Documents Application.
	Take into consideration a framework for desktop applications. Such applications are meant to work with documents. A framework for desktop applications contains definitions for operations such as opening, creating and saving a document. The basic classes are abstract ones, named Application and Document, their clients having to create subclasses from them in order to define their own applications. For generating a drawing application, for example, they need to define the DrawingApplication and DrawingDocument classes. The Application class has the task of managing the documents, taking action at the request of the client (for example, when the user selects the open or save command form the menu).
	
	Because the Document class that needs to be instantiated is specific to the application, the Application class does not know it in advance, so it doesn't know what to instantiate, but it does know when to instantiate it. The framework needs to instantiate a certain class, but it only knows abstract classes that can't be instantiated.
	
	The Factory Method design pattern solves the problem by putting all the information related to the class that needs to be instantiated into an object and using them outside the framework, as you can see below
	
	see factory method example - uml class diagram.gif
	
In the Application class the CreateDocument method either has a default implementation or it doesn't have any implementation at all, this operation being redefined in the MyApplication subclass so that it creates a MyDocument object and returns a reference to it.

public Document CreateDocument(String type){
	if (type.isEqual("html"))
		return new HtmlDocument();
	if (type.isEqual("proprietary"))
		return new MyDocument();
	if (type.isEqual("pdf"))
		return new PdfDocument ();
}

Assuming that the Application class has a member called docs that represents a list of documents being handled by the application, then the NewDocument method should look like this:
public void NewDocument(String type){
	Document doc=CreateDocument(type);
	Docs.add(doc);
	Doc.Open();
}
This method will be inherited by the MyApplication class and, so, through the CreateDocument method, it will actually instantiate MyDocument objects. We will call the CreateDocument method a Factory Method because it is responsible with 'making' an object. Through this method, redefined in Application's subclasses, we can actually shape the situation in which the Application class creates objects without knowing their type. From this point of view the factory method is pattern which provides us a way to achieve the DIP principle.

Specific problems and implementation

When implementing the Factory Method design pattern some issues may appear:

Definition of Creator class

If we apply the pattern to an already written code there may be problems with the way we have the Creator class already defined. There are two cases:

Creator class is abstract and generating method does not have any implementation. In this case the ConcreteCreator classes must define their own generation method and this situation usually appears in the cases where the Creator class can't foresee what ConcreteProduct it will instantiate.

Creator class is a concrete class, the generating method having a default implementation. If this happens, the ConcreteCreator classes will use the generating method for flexibility rather than for generation. The programmer will always be able to modify the class of the objects that the Creator class implicitly creates, redefining the generation method.

Factory method is just a particular case of the factory design pattern. In the same time it is the most known factory pattern, maybe because it was published in the GoF. In modern programming languages the factory with registration is more used.

Drawbacks and Benefits

Here are the benefits and drawbacks of factory method pattern:

+ The main reason for which the factory pattern is used is that it introduces a separation between the application and a family of classes (it introduces weak coupling instead of tight coupling hiding concrete classes from the application). It provides a simple way of extending the family of products with minor changes in application code.
+ It provides customization hooks. When the objects are created directly inside the class it's hard to replace them by objects which extend their functionality. If a factory is used instead to create a family of objects the customized objects can easily replace the original objects, configuring the factory to create them.
- The factory has to be used for a family of objects. If the classes doesn't extend common base class or interface they can not be used in a factory design template.

Hot Points:

The factory method is one of the most used and one of the more robust design patterns. There are only few points which have to be considered when you implement a factory method.

When you design an application just think if you really need it a factory to create objects. Maybe using it will bring unnecessary complexity in your application. Anyway if you have many object of the same base type and you manipulate them mostly as abstract objects, then you need a factory. I you're code should have a lot of code like the following, reconsider it.

if (genericProduct typeof ConcreteProduct)
	((ConcreteProduct)genericProduct).doSomeConcreteOperation();
	
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Abstract Factory (creational)
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Motivation
	Modularization is a big issue in today's programming. Programmers all over the world are trying to avoid the idea of adding code to existing classes in order to make them support encapsulating more general information. Take the case of a information manager which manages phone number. Phone numbers have a particular rule on which they get generated depending on areas and countries. If at some point the application should be changed in order to support adding numbers form a new country, the code of the application would have to be changed and it would become more and more complicated.
		
	In order to prevent it, the Abstract Factory design pattern is used. Using this pattern a framework is defined, which produces objects that follow a general pattern and at runtime this factory is paired with any concrete factory to produce objects that follow the pattern of a certain country. In other words, the Abstract Factory is a super-factory which creates other factories (Factory of factories).
Intent
	Abstract Factory offers the interface for creating a family of related objects, without explicitly specifying their classes.
Implementation
	The pattern basically works as shown below, in the UML diagram:
	see abstract-factory-pattern.png

The classes that participate to the Abstract Factory pattern are:
	AbstractFactory - declares a interface for operations that create abstract products.
	ConcreteFactory - implements operations to create concrete products.
	AbstractProduct - declares an interface for a type of product objects.
	Product - defines a product to be created by the corresponding ConcreteFactory; it implements the AbstractProduct interface.
	Client - uses the interfaces declared by the AbstractFactory and AbstractProduct classes.

The AbstractFactory class is the one that determines the actual type of the concrete object and creates it, but it returns an abstract pointer to the concrete object just created. This determines the behavior of the client that asks the factory to create an object of a certain abstract type and to return the abstract pointer to it, keeping the client from knowing anything about the actual creation of the object.

The fact that the factory returns an abstract pointer to the created object means that the client doesn't have knowledge of the object's type. This implies that there is no need for including any class declarations relating to the concrete type, the client dealing at all times with the abstract type. The objects of the concrete type, created by the factory, are accessed by the client only through the abstract interface.

The second implication of this way of creating objects is that when the adding new concrete types is needed, all we have to do is modify the client code and make it use a different factory, which is far easier than instantiating a new type, which requires changing the code wherever a new object is created.

The classic implementation for the Abstract Factory pattern is the following:

abstract class AbstractProductA{
	public abstract void operationA1();
	public abstract void operationA2();
}

class ProductA1 extends AbstractProductA{
	ProductA1(String arg){
		System.out.println("Hello "+arg);
	} // Implement the code here
	public void operationA1() { };
	public void operationA2() { };
}

class ProductA2 extends AbstractProductA{
	ProductA2(String arg){
		System.out.println("Hello "+arg);
	} // Implement the code here
	public void operationA1() { };
	public void operationA2() { };
}

abstract class AbstractProductB{
	//public abstract void operationB1();
	//public abstract void operationB2();
}

class ProductB1 extends AbstractProductB{
	ProductB1(String arg){
		System.out.println("Hello "+arg);
	} // Implement the code here
}

class ProductB2 extends AbstractProductB{
	ProductB2(String arg){
		System.out.println("Hello "+arg);
	} // Implement the code here
}

abstract class AbstractFactory{
	abstract AbstractProductA createProductA();
	abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory{
	AbstractProductA createProductA(){
		return new ProductA1("ProductA1");
	}
	AbstractProductB createProductB(){
		return new ProductB1("ProductB1");
	}
}

class ConcreteFactory2 extends AbstractFactory{
	AbstractProductA createProductA(){
		return new ProductA2("ProductA2");
	}
	AbstractProductB createProductB(){
		return new ProductB2("ProductB2");
	}
}

//Factory creator - an indirect way of instantiating the factories
class FactoryMaker{
	private static AbstractFactory pf=null;
	static AbstractFactory getFactory(String choice){
		if(choice.equals("a")){
			pf=new ConcreteFactory1();
		}else if(choice.equals("b")){
				pf=new ConcreteFactory2();
			} return pf;
	}
}

// Client
public class Client{
	public static void main(String args[]){
		AbstractFactory pf=FactoryMaker.getFactory("a");
		AbstractProductA product=pf.createProductA();
		//more function calls on product
	}
}

Applicability & Examples
We should use the Abstract Factory design pattern when:
	the system needs to be independent from the way the products it works with are created.
	the system is or should be configured to work with multiple families of products.
	a family of products is designed to work only all together.
	the creation of a library of products is needed, for which is relevant only the interface, not the implementation, too.
Phone Number Example
	The example at the beginning of the article can be extended to addresses, too. The AbstractFactory class will contain methods for creating a new entry in the information manager for a phone number and for an address, methods that produce the abstract products Address and PhoneNumber, which belong to AbstractProduct classes. The AbstractProduct classes will define methods that these products support: for the address get and set methods for the street, city, region and postal code members and for the phone number get and set methods for the number.

	The ConcreteFactory and ConcreteProduct classes will implement the interfaces defined above and will appear in our example in the form of the USAddressFactory class and the USAddress and USPhoneNumber classes. For each new country that needs to be added to the application, a new set of concrete-type classes will be added. This way we can have the EnglandAddressFactory and the EnglandAddress and EnglandPhoneNumber that are files for English address information.
Pizza Factory Example
	Another example, this time more simple and easier to understand, is the one of a pizza factory, which defines method names and returns types to make different kinds of pizza. The abstract factory can be named AbstractPizzaFactory, RomeConcretePizzaFactory and MilanConcretePizzaFactory being two extensions of the abstract class. The abstract factory will define types of toppings for pizza, like pepperoni, sausage or anchovy, and the concrete factories will implement only a set of the toppings, which are specific for the area and even if one topping is implemented in both concrete factories, the resulting pizzas will be different subclasses, each for the area it was implemented in.
Look & Feel Example
	Look & Feel Abstract Factory is the most common example. For example, a GUI framework should support several look and feel themes, such as Motif and Windows look. Each style defines different looks and behaviors for each type of controls: Buttons and Edit Boxes. In order to avoid the hardociding it for each type of control we define an abstract class LookAndFeel. This calls will instantiate, depending on a configuration parameter in the application one of the concrete factories: WindowsLookAndFeel or MotifLookAndFeel. Each request for a new object will be delegated to the instatiated concrete factory which will return the controls with the specific flavor
	
	see (abstract-factory-pattern-example.png)
Specific problems and implementation
	The Abstract Factory pattern has both benefits and flaws. On one hand it isolates the creation of objects from the client that needs them, giving the client only the possibility of accessing them through an interface, which makes the manipulation easier. The exchanging of product families is easier, as the class of a concrete factory appears in the code only where it is instantiated. Also if the products of a family are meant to work together, the Abstract Factory makes it easy to use the objects from only one family at a time. On the other hand, adding new products to the existing factories is difficult, because the Abstract Factory interface uses a fixed set of products that can be created. That is why adding a new product would mean extending the factory interface, which involves changes in the AbstractFactory class and all its subclasses. This section will discuss ways of implementing the pattern in order to avoid the problems that may appear.
	
Factories as singletons
	An application usually needs only one instance of the ConcreteFactory class per family product. This means that it is best to implement it as a Singleton.

Creating the products
	The AbstractFactory class only declares the interface for creating the products. It is the task of the ConcreteProduct class to actually create the products. For each family the best idea is applying the Factory Method design pattern. A concrete factory will specify its products by overriding the factory method for each of them. Even if the implementation might seem simple, using this idea will mean defining a new concrete factory subclass for each product family, even if the classes are similar in most aspects.
	
	For simplifying the code and increase the performance the Prototype design pattern can be used instead of Factory Method, especially when there are many product families. In this case the concrete factory is initiated with a prototypical instance of each product in the family and when a new one is needed instead of creating it, the existing prototype is cloned. This approach eliminates the need for a new concrete factory for each new family of products.

Extending the factories
	The operation of changing a factory in order for it to support the creation of new products is not easy. What can be done to solve this problem is, instead of a CreateProduct method for each product, to use a single Create method that takes a parameter that identifies the type of product needed. This approach is more flexible, but less secure. The problem is that all the objects returned by the Create method will have the same interface, that is the one corresponding to the type returned by the Create method and the client will not always be able to correctly detect to which class the instance actually belongs.

Hot Points:
	AbstractFactory class declares only an interface for creating the products. The actual creation is the task of the ConcreteProduct classes, where a good approach is applying the Factory Method design pattern for each product of the family.
	
	Extending factories can be done by using one Create method for all products and attaching information about the type of product needed.	
	
-----------------------------------------------------------------------------------------------------
Iterator
-----------------------------------------------------------------------------------------------------
Motivation
	One of the most common data structures in software development is what is generic called a collection. A collection is just a grouping of some objects. They can have the same type or they can be all cast to a base type like object. A collection can be a list, an array, a tree and the examples can continue. 
	
	But what is more important is that a collection should provide a way to access its elements without exposing its internal structure. We should have a mechanism to traverse in the same way a list or an array. It doesn't matter how they are internally represented. 
	
	The idea of the iterator pattern is to take the responsibility of accessing and passing trough the objects of the collection and put it in the iterator object. The iterator object will maintain the state of the iteration, keeping track of the current item and having a way of identifying what elements are next to be iterated. 
Intent
	Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation. 

The abstraction provided by the iterator pattern allows you to modify the collection implementation without making any changes outside of collection. It enables you to create a general purpose GUI component that will be able to iterate through any collection of the application. 

Implementation
	see (iterator_implementation_-_uml_class_diagram.gif)

Applicability & Examples
The iterator pattern allow us to:
	access contents of a collection without exposing its internal structure.
	support multiple simultaneous traversals of a collection.
	provide a uniform interface for traversing different collection.
	
Example 1: This exmple is using a collection of books and it uses an iterator to iterate through the collection. The main actors are:
	IIterator - This interface represent the AbstractIterator, defining the iterator
	BookIterator - This is the implementation of Iterator(implements the IIterator interface)
	IContainer - This is an interface defining the Agregate
	BooksCollection - An implementation of the collection
Here is the code for the abstractions IIterator and IContainer:
interface IIterator
{
	public boolean hasNext();
	public Object next();
}

interface IContainer
{
	public IIterator createIterator();
}

And here is the code for concrete classes for iterator and collection. Please note that the concrete iterator is an nested class. This way it can access all the members of the collection and it is encapsulated so other classes can not access the BookIterator. All the classes are not aware of BookIterator they uses the IIterator:

class BooksCollection implements IContainer
{
	private String m_titles[] = {"Design Patterns","1","2","3","4"};

	public IIterator createIterator()
	{
		BookIterator result = new BookIterator();
		return result;
	}


	private class BookIterator implements IIterator
	{
		private int m_position;

		public boolean hasNext()
		{
			if (m_position < m_titles.length)
				return true;
			else
				return false;
		}
		public Object next()
		{
			if (this.hasNext())
				return m_titles[m_position++];
			else
				return null;
		}
	}
}
Example 2: Java collection framework 
Example 3: .NET collection framework 
Specific problems and implementation
Iterator and multithreading
Several problems may appear when collections are added from different threads. First of all let's see which the basic steps when using an iterator are:
	Step one: the collection return a new iterator (using in our example the createIterator method). Usually this step is not affected when it is used in multithreading environments because it returns a new iterator object.
	Step two: The iterator is used for iterating through the objects. Since the iterators are different objects this step is not a problematic one in multithreading environments.
It seems that the iterator does not raise special problems when a collection is used from different threads. Of course here we are talking about an "seems". To reformulate the iterator does not raise special problems when the collection used from different threads as long the collection is not changed.

Let's analyze each case:
	A new element is added to the collection (at the end). The iterator should be aware of the new size of the collection and to iterate till the end.
	A new element is added to the collection before the current element. In this case all the iterators of the collection should be aware of this.
The same actions should occur when an element is removed from the collection. The iterators should be aware of the changes.

The main task when creating a multithreading iterator is to create a robust iterator (that allows insertions and deletions without affection transversal). Then the blocks which are changing or accessing resources changed by another thread have to be synchronized. 

External vs. internal iterators.
External Iterators - when the iteration is controlled by the collection object we say that we have an external Iterator. 

In languages like .net on java it's very easy to create external iterators. In our classical implementation an external iterator is implemented. In the following example an external iterator is used:

// using iterators for a clloection of String objects:
// using in a for loop
for (Iterator it = options.iterator(); it.hasNext(); ) {
   String name = (String)it.next();
   System.out.println(name);
}

// using in while loop
Iterator name = options.iterator();
    while (name.hasNext() ){
      System.out.println(name.next() );
    }

// using in a for-each loop (syntax available from java 1.5 and above)
    for (Object item : options)
        System.out.println(((String)item));
		
Internal Iterators - When the iterator controls it we have an internal iterator 

On the other side implementing and using internal iterators is really difficult. When an internal iterator is used it means that the code is be run is delegated to the aggregate object. For example in languages that offer support for this is easy to call internal iterators:
	collection do: [:each | each doSomething] (Smalltalk) 
The main idea is to pass the code to be executed to the collection. Then the collection will call internally the doSomething method on each of the components. In C++ it's possible to send the doMethod method as a pointer. In C# .NET or VB.NET it is possible to send the method as a delegate. In java the Functor design pattern has to be used. The main idea is to create a base Interface with only one method (doSomething). Then the method will be implemented in a class which implements the interface and the class will be passed to the collection to iterate. For more details see the Functor design pattern.

Who defines the traversal algorithm?
	The algorithm for traversing the aggregate can be implemented in the iterator or in the aggregate itself. When the traversal algorithm is defined in the aggregate, the iterator is used only to store the state of the iterator. This kind of iterator is called a cursor because it points to the current position in the aggregate. 
The other option is to implement the traversal algorithm in the iterator. This option offers certain advantages and some disadvantages. For example it is easier to implement different algorithms to reuse the same iterators on different aggregates and to subclass the iterator in order to change its behavior. The main disadvantage is that the iterator will have to access internal members of the aggregate. In Java and .NET this can be done, without violating the encapsulation principle, by making the iterator an inner class of the aggregate class. 

Robust Iterators
	
	- Can the aggregate be modified while a traversal is ongoing? An iterator that allows insertion and deletions without affecting the traversal and without making a copy of the aggregate is called a robust iterator. A robust iterator will make sure that when elements are added or removed from an aggregate during iteration; elements are not accessed twice or ignored. 
	
	Lets' say we don't need a robust iterator. If the aggregate can not be modified (because the iteration is started), it should be made explicitly, meaning that the client should be aware of it. We can just return a false value what an element is added to the collection stating that the operation has failed, or we can throw an exception. 
	
	An alternative solution is to add functions to change the aggregate in the iterator itself. For example we can add the following methods to our iterator:
	
		bool remove();
		bool insertAfer();
		bool insertBefore();
		
In the case when this solution is chosen the iterator handles the changes of the aggregator. In this case the operation to change the iteration should be added to the iterator interface or base class not to the implementation only, in order to have a general mechanism for the entire application.

Mechanism provided by the programming language
	The iterator pattern can be implemented from scrach in Java or .NET, but there is already built-in support for Iterator Pattern (IEnumerator/IEnumerable in .NET and Iterator/Collection in JAVA).
	
Hot Spot
	
	External vs. internal iterators - In languages like Java, C#, VB .NET, C++ is very easy to use external iterators.
	Who defines the traversal algorithm? - The aggregate can implement it or the iterator as well. Usually the algorithm is defined in the iterator.
	Robust Iterators - Can the aggregate be modified while a traversal is ongoing?
	Multithreading iterators - First of all multithreading iterators should be robust iterators. Second of all they should work in multithreading environments.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Decorator Pattern	
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Motivation
	Extending an object?s functionality can be done statically (at compile time) by using inheritance however it might be necessary to extend an object?s functionality dynamically (at runtime) as an object is used.
Consider the typical example of a graphical window. To extend the functionality of the graphical window for example by adding a frame to the window, would require extending the window class to create a FramedWindow class. To create a framed window it is necessary to create an object of the FramedWindow class. However it would be impossible to start with a plain window and to extend its functionality at runtime to become a framed window.

Intent
	The intent of this pattern is to add additional responsibilities dynamically to an object.
Implementation
	The figure below shows a UML class diagram for the Decorator Pattern: see decorator-design-pattern-implementation-uml-class-diagram.png
Component - Interface for objects that can have responsibilities added to them dynamically.
ConcreteComponent - Defines an object to which additional responsibilities can be added.
Decorator - Maintains a reference to a Component object and defines an interface that conforms to Component's interface.
Concrete Decorators - Concrete Decorators extend the functionality of the component by adding state or adding behavior.

Description
	The decorator pattern applies when there is a need to dynamically add as well as remove responsibilities to a class, and when subclassing would be impossible due to the large number of subclasses that could result.

Applicability & Examples
	Example - Extending capabilities of a Graphical Window at runtime
	see decorator-design-pattern-example-uml-class-diagram.png
	
In Graphical User Interface toolkits windows behaviors can be added dynamically by using the decorator design pattern.
Specific problems and implementation

Graphical User Interface Frameworks
	GUI toolkits use decoration pattern to add functionalities dynamically as explained before.
	Related Patterns
	Adapter Pattern - A decorator is different from an adapter in that a decorator changes object's responsibilities, while an adapter changes an object interface.
	Composite Pattern - A decorator can be viewed as a degenerate composite with only one component. However, a decorator adds additional responsibilities.
	
Consequences
	Decoration is more convenient for adding functionalities to objects instead of entire classes at runtime. With decoration it is also possible to remove the added functionalities dynamically.
	
	Decoration adds functionality to objects at runtime which would make debugging system functionality harder.
Known Uses:
	GUI toolkits as has been previously explained.
	
	
	
	
	



 



Remaining
creational
-----------------
Builder
Prototype
Object Pool
------------
Behavioral Patterns
---------------
Chain of Responsibility
Command
Interpreter
Mediator
Memento
Observer
Strategy
Visitor
Null Object
-----------
Structural Patterns
------------------
Adapter
Bridge
Composite
Flyweight

--------------------------------------------------------------------------------------------------------------
Facade
--------------------------------------------------------------------------------------------------------------	
	
	
Design Patterns Uncovered: The Facade Pattern from http://java.dzone.com/articles/design-patterns-uncovered-1
Facades in the Real World 
	Facades are all around us in the real world.  Operating systems are one such example - you don't see all the inner workings of your computer, but the OS provides a simplified interface to use the machine. Buildings also have a facade - the exterior of the building. Wikipedia gives us a nice link between software architecture and standard architecture: 
	
	In architecture, the facade of a building is often the most important from a design standpoint, as it sets the tone for the rest of the building
	
	So, in a nutshell, a Facade aims to make things look cleaner and more appealling.
	
	The Facade Pattern
	
	Like the Adapter pattern, Facade is known as a structural pattern, as it's used to identifying a simple way to realize relationships between entities. The definition of Facade provided in the original Gang of Four book on Design Patterns states: 
	
	Provide a unified interface to a set of interfaces in a subsystem. Façade defines a higher-level interface that makes the subsystem easier to use.
	The diagram definition of the Facade pattern is quite simple - all you're really doing is insulating client from the subsystem: (see facade_class.PNG)
	
	Like the adapter pattern, the Facade can be used to hide the inner workings of a third party library, or some legacy code.  All that the client needs to do is interact with the Facade, and not the subsystem that it is encompassing.
	
	The following sequence diagram illustrates how the pattern is used by a client: see facade_seq.PNG
	
Where Would I Use This Pattern?

	As the concept behind facade is to simplify an interface, service oriented architectures make use of the facade pattern. For example, in web services, one web service might provide access to a number of smaller services that have been hidden from the caller by the facade. Similarly, a typical pattern in OSGi bundles is to provide an interface package that is exposed to users of the bundle. All other packages are hidden from the user.

So How Does It Work In Java?
	Let's put together a simple example in Java code to illustrate the pattern. Let's take a travel agent site for example, that allows you to book hotels and flights. We have a HotelBooker:
	
public class HotelBooker{
	public ArrayList<Hotel> getHotelNamesFor(Date from, Date to){
		//returns hotels available in the particular date range
	}
}

And a FlightBooker:
public class FlightBooker{
	public ArrayList<Flight> getFlightsFor(Date from, Date to){
		//returns flights available in the particular date range
	}
}
Both of these have Hotel and Flight datatypes, which the client has knowledge about. They could be provided in the same package as the Facade for example. 

The TravelFacade class allows the user to get their Hotel and Flight information in one call:
public class TravelFacade{
	private HotelBooker hotelBooker;
	private FlightBooker flightBooker;
	public void getFlightsAndHotels(Date from, Data to){
		ArrayList<Flight> flights = flightBooker.getFlightsFor(from, to);
		ArrayList<Hotel> hotels = hotelBooker.getHotelsFor(from, to);
		//process and return
	}
}
All that the client needs to worry about is the Facade class: 
public class Client{
	public static void main(String[] args){
		TravelFacade facade = new TravelFacade();
		facade.getFlightsAndHotels(from, to);
	}
}

As you can see, it's just a simple approach to encapsulating data.

By introducing the Facade into your code, you will be hardwiring subsystems into the Facade. This is fine if the subsystem never changes, but if it does, your Facade could be broken. Therefore, developers working on the subsystem should be made aware of any Facade around their code.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Command Pattern
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Command pattern forwards the request to a specific module. This is behavioural pattern
real world example is ordering at restrurant 
Definition from GOF : Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations

Use ful when?
	A history of requests is needed
	You need callback functionality
	Requests need to be handled at variant times or in variant orders
	The invoker 


-------------------------


1)adapter pattern
2)template pattern

problems with traditional j2ee components such as like Servlet, JSPs

1) Each servlet/jsp need to configure in web.xml and it will be cumbersome(difficult to handle).
2) consists of accepting the request, process, view generation and presenting.
3) Duplicate code for  common features like logging, authentication , authorization
4) distrubuted control of requesting handling.


MVC is architectural pattern
-----

advatanges
1) get rid comebsume of web.xml 
2) 


Front Controller pattern
------
The Front Controller pattern defines a single component that is responsible for processing application requests. A front controller centralizes functions such as view selection, security, and templating, and applies them consistently across all pages or views. Consequently, when the behavior of these functions need to change, only a small part of the application needs to be changed: the controller and its helper classes.

advatages
separating processing and view.. we can change the desired view with simple change.

deem offers signed with sign post

Domain Specific Language

domains - travel
		  e-procurement
		  finance
		  writing ..scripts
		  telecom
		  
		  
		  struts
		  
		  make
		  ant
		  maven
		  rake -- 
		  
		  
		  external -- compiler/
		  internal -- 
		  
		  

-------------------------------------------------------------------------------------------------------------------------------
Hashing


Hashing is designed to solve the problem of needing to efficiently find item in a collection.

For example, if we have a list of 10,000 words of English and we want to check if a given word is in the list, it would be inefficient to successively compare the word with all 10,000 items until we find a match. Hashing is a technique to make things more efficient by effectively narrowing down the search at the outset.

What is hashing?
Hashing means using some function or algorithm to map object data to some representative integer value. This so-called hash code (or simply hash) can then be used as a way to narrow down our search when looking for the item in the map.
How hashing works?
Purely as an example to help us grasp the concept, let's suppose that we want to map a list of string keys to string values (for example, map a list of countries to their capital cities). So let's say we want to store the data in Table 1 in the map.

				Key			Value
				Cuba		Havana
				England		London
				France		Paris
				Spain		Madrid
				Switzerland	Berne
And let's suppose that our hash function is to simply take the length of the string. For simplicity, we'll have two arrays: one for our keys and one for the values. So to put an item in the hash table, we compute its hash code (in this case, simply count the number of characters), then put the key and value in the arrays at the corresponding index. For example, Cuba has a hash code (length) of 4. So we store Cuba in the 4th position in the keys array, and Havana in the 4th index of the values array etc. And we end up with the following:

Position
(hash code = key length)		Keys	Values
1	 	 
2	 	 
3	 	 
4								Cuba			Havana
5								Spain			Madrid
6								France			Paris
7								England			London
8	 	 
9	 	 
10	 	 
11								Switzerland		Berne				

Now, in this specific example things work quite well. Our array needs to be big enough to accommodate the longest string, but in this case that's only 11 slots. And we do waste a bit of space because, for example, there's no 1-letter keys in our data, nor keys between 8 and 10 letters. But in this case, the waste isn't so bad either. And taking the length of a string is nice and fast, so so is the process of finding the value associated with a given key (certainly faster than doing up to five string comparisons)1.

We can also easily see that this method wouldn't work for storing arbitrary strings. If one of our string keys was a thousand characters in length but the rest were small, we'd waste the majority of the space in the arrays. More seriously, this model can't deal with collisions: that is, what to do when there is more than one key with the same hash code (in this case, one than more string of a given length). For example, if our keys were random words of English, taking the string length would be fairly useless. Granted, the word psuedoantidisestablishmentarianistically would probably get its own place in the array. But on the other hand, we'd be left with thousands of, say, 6-letter words all competing for the same slot in the array.

We can then create a map by using this hash as an index into an array of key/value pairs. Such a structure is generally called a hash table or, particularly in Java parlance, hash map. We saw that using the string length to create the hash, and indexing a simple array, could work in some restricted cases, but is no good generally: for example, we have the problem of collisions (several keys with the same length) and wasted space if a few keys are vastly larger than the majority.

Buckets

Now, we can solve the problem of collisions by having an array of (references to) linked lists rather than simply an array of keys/values. Each little list is generally called a bucket.

Then, we can solve the problem of having an array that is too large simply by taking the hash code modulo a certain array size3. So for example, if the array were 32 positions in size, going from 0-31, then rather than storing a key/value pair in the list at position 33, we store it at position (33 mod 32) = 1. (In simple terms, we "wrap round" when we reach the end of the array.) So we end up with a structure something like this:

          
		  
		  5 ---> spain|madrid ---> wales|Cardiff
		  6 ---> France|Paris
		  7 ---> Germany|Berlin ---> Ireland|Dublin
		  
Each node in the linked lists stores a pairing of a key with a value. Now, to look for the mapping for, say, Ireland, we first compute this key's hash code (in this case, the string length, 7). Then we start traversing the linked list at position 7 in the table. We traverse each node in the list, comparing the key stored in that node with Ireland. When we find a match, we return the value from the pair stored in that node (Dublin). In our example here, we find it on the second comparison. So although we have to do some comparisons, if the list at a given position in the table is fairly short, we'll still reduce significantly the amount of work we need to do to find a given key/value mapping.

In our simple but impractical example, we took the length of the string as the hash function. If we solve the problem of collisions by having a linked list in each bucket, then taking the string length as the hash function will theoretically work. But it has an obvious problem if, say, we want our keys to be, say, 100,000 words of English. In this case, our linked lists at array position 6, as well as those corresponding to other common string lengths, will still have thousands of entries, while higher numbers will have practically none. Sure, it's better to scan a list of 10,000 entries than a list of 100,000 when looking for the key. But really, our hash function of taking the string length isn't adequate. We need to choose a better hash function that ideally has these properties:

1)It can distribute the keys more or less evenly over the range of positions in the array. We want to avoid the situation where position 6 has a list of 10,000 entries and position 13 has a list of only 20 entries.
2) It can distribute the keys over a larger range of values. If there are 100,000 words in the map and a perfectly-distributed hash function, then having 50 positions in the array would still give an average list size of 2,000 items. But if we could have 5,000 positions, there'd be just 20 items in each list. And if we had in the region of 100,000 positions then we'd on average make just one or two comparisons1 to find the mapping we were looking for.

In practice, we combine these problems and define our task as coming up with a hash function that distributes hash codes evenly over the entire range of possible integers (in Java, that means a 4-byte number, or one with about 4 billion possible values). Then we assume that whatever the size of the array in our hash map (whatever the modulus), the mappings will be distributed more or less evenly.


Of course, for a given key X, the hash function must always generate the same hash code Y. But the point is that Y should essentially be a "random number across the possible range of hash codes".



			

 

-------------------------------------------------------------------------------------------------------------------------------

Component
----------
component is a glob of software that's intended to be used, without change, by application that is out of the control of the writers of the component. By 'without change' mean that the using application doesn't change the source code of the components, although they may alter the component's behavior by extending it in ways allowed by the component writers.

Service
-----------
A service is similar to a component in that it's used by foreign applications. The main difference is that I expect a component to be used locally (think jar file, assembly, dll, or a source import). A service will be used remotely through some remote interface, either synchronous or asynchronous (eg web service, messaging system, RPC, or socket.)


------------------------------------------------------------------------------------------------------------------------------
UML
UML

1) Structural Diagrams
	a) Class
		shows classes of the system, their relations, attributes and operations of the class
	b) Component
		shows depedencies amoung software components, example : grails framework, purchase ui, purchse service layer
	c) Deployment
		depicts a static view of the run time configuration of hardware nodes and the software components that run on those nodes
		show hardware of your system, the software that is installed on that hardware, and the middleware used to connect the disparate machines to another
	d) Object
		Are useful for exploring real world examples of objects and the relationships between them. they are useful for explaining small pieces
		with complicated relationships, especially recursive relationships
	e) Composite Structure
		Used to explore run-time instances of interconnected instances collaborating over communications links, It shows the internal structure
		(including parts and Connectors) of a structured classifier or collaboration.
			exmaple : Student enrolling course 
	d) Package
		simplify classes into packages, A package is a collection of logically related UML elements, packages are depicted as file folders and
		can be used on any of the UML Diagrams. (exmaple UI, Accounting, Ordering, Shipping, CustomerDB)
2) Behavioral
	a) Activity
		helps to describe the flow of control of the target system. Such as the exploring complex business rules and operations,
		describing the use case also the business process. It is object-oriented equivalent of flow charts and data-flow diagrams(DFDs)
	b) State Machine
		can show the different states of an entity also how an entity responds to various events by changing from one state to another. 
		The history of an entity can best be modeled by a finite stage diagram.
	c) Use Case
		describes the behavior of the target system from an external point of view. Use cases describe "the meat" of the actual requirements.
		USE CASES: A use case describes a sequence of actions that provide something of measurable value to an actor and is drwan as a 
				   horizontal ellipse.
		Actors   : An actor is a person, organization, or external system that plays a role in one or more interactions with you system. Actors
				   are drawn as stick figures.
	    Associations : Associations between actors and use cases are indicated by solid lines. An association exists whenever an actor is
						involved with an interaction described by a use case
3) Interaction
	a) Communication
			used to model the dynamic behavior of the use case. When compare to sequence diagram, the communication diagram is more focused on showing the collaboration of objects rather than the time sequence.
	b) Sequence
			Models the collaboration of objects based on a time sequence. It shows how the objects interact with others in a particular scenario of a use case.
	c) Interaction Overview
	d) Timing
	
	
	
	
	Manager--> CFO --> 
	
-------------------------------------------------------------------------------------------------------------------------------



SOLID
Single Responsibility Principal
Open Closed Principal
Linkov Substution Principal
Interface segregation  Principal
Dependency Injection Principal






