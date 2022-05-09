Java String-Kata
==================

##### Instructions
TDD is very important when pair programming.  It allowes us to write better code, faster, and with less bugs.
This exercise is meant to gain confidence and understanding with the TDD process.
Remember the steps
1. red
   1. You have a failing test
2. green
   1. You write the code that satisfies the test requirements
3. refactor
   1. You find a more efficient and more readable way to write your code and tests!
 
**Remember to write *only code* that satisfies your test. Nothing more and nothing less.**
    
----------

##### Steps

1. Create add method on `StringCalculator.java` class that will take a String argument and return an int.
2. Method can take 0, 1, or 2 numbers, and will return their sum.
   2. Empty String or Null returns 0.
   1. Example: `"" == 0`, `"1" == 1`, `"1,2" == 3`
3. Allow add method to take an unknown amount of numbers that are comma delimited.
4. Allow add method to handle new lines between numbers (instead of commas).
   1. `"1\n2,3" == 6`
5. Support different delimiters.
   1. `";\n1;2" == 3`
6. Calling add with negative numbers throws IllegalArgumentException with message:
   1. `Negative numbers not allowed`
7. If there are more than one negative numbers, list them in the exception message.
   1. Example: `"-1,-2,3,4,5"` `->` `Negative numbers not allowed: [-1, -2]`
8. Numbers larger than 1000 will be ignored.
   1. Example: `"1,2,3,1001,1002" == 6`
9. White space is trimmed from numbers.
   1. Example: `"1, 2, 3" == 6`
