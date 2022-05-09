# string-kata

1. Create add method on `StringCalculator.java` class
   1. Method can take 0, 1, or 2 number, and will return their sum
   2. Example: `"" == 0`, `"1" == 1`, `"1,2" == 3`
2. Empty String or Null returns 0
3. Allow add method to take an unknown amount of numbers that are comma delimited
4. Allow add method to handle new lines between numbers (instead of commas)
   1. `"1\n2,3" == 6`
5. Support different delimiters
   1. `";\n1;2" == 3`
6. Calling add with negative numbers throws IllegalArgumentException with message: 
   1. `Negative numbers not allowed`
7. If there are more than one negative numbers, list them in the exception message
   1. Example: `"-1,-2,3,4,5"` -> `Negative numbers not allowed: [-1, -2]`
8. Numbers larger than 1000 will be ignored
   1. Example: `"1,2,3,1001,1002" == 6`
9. White space is trimmed from numbers
   1. Example: `"1, 2, 3" == 6`
