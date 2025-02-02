# Currency Converter Project - Study Questions

## Basic Understanding
1. What is the overall purpose of this application?

Its purpose is to calculate the equivalence between different currencies, subtracting
the commission for the service.

2. How does the application handle different currencies? Where are they defined?

The currencies are defined as an Enum class and selected from a ComboBox in the GUI.

3. What design pattern is used to represent currencies in the code? Why might this be a good choice?

The currencies are retrieved as an array of Strings which is formed by iterating the values of the
enum. This makes the system scalable, as when a new currency must be added, we just have to add it
to the enum and the ComboBox will automátically have the updated list.

## Architecture & Flow
4. Describe the relationship between `CalculatorWindow`, `CalculatorController`, and `calculator.fxml`. How do they work together?

- `CalculatorWindow` is the main class of the application. It creates a new stage with `calculator.fxml`
as scene and launches it.
- `calculator.fxml` has the information necessary to build the GUI application, the position of each element
and the function to be called when interacted with any of them. These functions have to be in the controller
class, `CalculatorController`.
- `CalculatorController` is where the elements of `calculator.fxml` are linked to attributes and where the
functions attached to these elements are defined.


5. What is the role of the `ForexOperator` class? How does it obtain currency exchange rates?

Its role is to return the equivalent value between the two currencies given the constructor,
whenever `ForexOperator#getChangeValue()` is called. To obtain the currency exchange rates,
it scrapes the web "https://currencyconvert.online/" and checks the updated values for each
pair of currencies.

6. How does the commission calculation work? What are the two factors that determine the final commission amount?

The company has a commission for the service of exchanging currencies. There is a minimum
comission in euros `MIN_COMMISION_IN_EUROS`. If another currency is used, the equivalent
is calculated.

The normal commission is calculated multiplying the quantity to exchange by a factor
`COMMISION_RATE`. The final commission is the maximum between these two values.

## Technical Implementation
7. Why does the `ForexOperator` class need to set a User-Agent header in its HTTP request?

Many web apps try to block bots to avoid them abusing their services. To avoid the restriction,
this header is added to fool the server into believing we are normal users using a web browser.

8. How does the application parse the exchange rate from the response? What potential issues might arise from this approach?

It searches for a specific part of the page that is always the same, to find the converted value
and save it into a variable. The main issue is that as soon as the web page is updated and its
structure changes, our application will stop working. This could be avoided implementing an API.

9. What happens if a user tries to convert between the same currency? How is this handled?

`currencyconvert.online` does not support converting between the same currency, and it redirects
to the main page. Our application checks this case and warns the user that they cannot perform
the operation. Another approach could be to return the same value, as this conversion is trivial.

10. How does the application ensure that amounts are displayed with exactly two decimal places?

It uses Java's built in `NumberFormat` class, which brings more advanced tools to manipulate the
format, as opposed to the traditional `String#format("%.2f",x)`. The method `setMaximumFractionDigit(2)`
sets the decimimal places to exactly two.

## Error Handling
11. What types of exceptions might occur in this application? How are they handled?

When trying to get the change value one of the following Exceptions can be raised.
The program notifies the user that the conversion could not be done.
- `URLMalformedException` (unlikely)
- `IOException`
- `NumberFormatException`

When trying to read the number in the text field, `NumberFormatException` can be thrown. In that
case, the program asks the user to introduce a valid number.

12. What happens if:
    - The user enters an invalid amount? `NumberFormatException` is thrown.
    - The online service is unavailable? `IOException` is thrown.
    - The minimum commission makes the final amount negative? The program tells the user that the
      minimum commission is 3.00€

## JavaFX Specific
13. How are the currency selection ComboBoxes populated?

An `ObservableArrayList` is created from the `String[]` returned by `Currency#longNames()` and
assigned to the ComboBoxes by the method `ComboBox#setItems()`.

14. What is the purpose of the `initialize()` method in the `CalculatorController`?

This method is called each time a new stage is opened with the scene set to `calculator.fxml`,
which has the controller set to `CalculatorController`.

15. How does the application maintain separation between the UI (FXML) and business logic?

## Code Quality, Design & Testing
16. How does the project handle dependency management? What external libraries are used and why?

The project uses Maven as dependency manager. All the dependencies are declared in the pom.xml file
and when we build the project, Maven will download automatically al the files required and will
link them to the project.

The dependencies used are javafx-controls, javafx-fxml to create GUIs, bootstrapfx to
add a style using CSS, and JUnit to create tests.

17. What types of tests would be important for this application?

- API availability
- Handling unexpected input

18. What edge cases should be considered when testing the currency conversion functionality?
- Input value is negative
- Number format does not match US locale
- Double overflow