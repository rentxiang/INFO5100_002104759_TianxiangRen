# Write a console program to demonstrate the use (in real-life like example) for at least three design pattern implementation in Java.   (Due Date: 8th April 2023)

# The codes we have are to:
1. Factory Pattern:
The CoffeeFactory class is the factory in this pattern. It creates instances of different types of coffee. We pass the type of coffee we want to create and it returns the instance of that coffee.

2. Decorator Pattern:
The CoffeeDecorator is the abstract decorator in this pattern. It extends the Coffee class and has a reference to the Coffee object it decorates. The Milk and WhippedCream classes are the concrete decorators. They add additional ingredients to the coffee. They extend the CoffeeDecorator class and override the getDescription and cost methods to add their own description and cost to the coffee.

3. Observer Pattern:
The CoffeeListener is the observer interface in this pattern. It has an onCoffeeReady method that is called when the coffee is ready. The Barista is the subject in this pattern. It has a list of CoffeeListeners and notifies them when the coffee is ready. The Customer is the concrete observer in this pattern. It orders the coffee from the Barista and listens for the onCoffeeReady method to be called. When it is called, it prints a message saying that the coffee is ready.
