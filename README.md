# RandomPasswordGenerator-Java
Intro to Programming II - assignment 3

Write a program with the following class and functionality.

class Assign3 (save as Assign3.java)

This program will prompt the user to accept 5 lastnames. It will then generate passwords for each of those 5 names. Any duplicate passwords will need to be re-generated. After the entry of the 5 lastnames, and password generation, the program should sort in ascending sequence of lastname, after which the user can search for lastname. YOU CAN ASSUME USER WILL NOT ENTER DUPLICATE LASTNAMES.

The password generation MUST OCCUR AS SOON AS EACH LASTNAME IS ENTERED (I.E. DO NOT WAIT UNTIL YOU HAVE ENTERED ALL 5 LASTNAMES)
The 5 lastname entry occurs once, at the beginning, but the program should allow the user to search for lastname until “0” is entered, at which point the program will exit.

This class will contain at least the following instance methods.
main(..)
class Assign3 will contain the public static void main(..) method. It will contain the following String array to store 5 lastnames and its 5 corresponding passwords.
String lname[] = {"","","","",""};
String psw[] = {"","","","",""};
main(..) will invoke the following methods (and please note, when you create these array methods, they should all work for any sized arrays.:
sortArrayAsc(…) (instance method)
Use this method to sort the “lname[]” array in ascending order. This method will take a String array as a parameter. It will return nothing. As it sorts the lname array, it should also move the passwords in the psw[] accordingly. Below shows five names were entered with corresponding passwords generated for each name. The last names were sorted in ascending sequence and corresponding password moved accordingly. Note you are only sorting on lastname only.

*Image file attached as Example1*

(DO NOT USE ANY of Java’s own array methods)
(HINT: You may need to use the “compareTo” method for string comparison)
arrayDisplay(...) (instance method)
This method will take String arrays as parameters, and will display the content of the arrays, one name/password per line, and nothing else.
binSrch(…..) (instance method)
This method will take at least a String array as a parameter (there could be more parameters) and perform a binary search to locate the lastname and corresponding password. It is also important to note that this method must be able to search irrespective of case (whether it is uppercase, lowercase or mixture of both.). (DO NOT USE ANY of Java’s own array methods).
(HINT: You may need to use the “compareTo” method for string comparison)
The display of the found lastname and password should be done in main() and NOT here. Again if the name is not found, the error message should be displayed in main() and NOT here.

Above shows the user searching for “magnum”, which is found and “red” , which is not found. *Image file attached as Example2*

generatePassword(..) (instance method)
This method should take a String array as a parameter (at least). It will generate the password according to the following rules:
a) randomly generate a digit (between 1 to 5 inclusive)
b) take the 1st char of the lastname
c) the 2nd character of the password is calculated as:
If the 1st char. Of the last name is NOT the same as the last char. of the lastname
int mid = (Unicode integer of 1st char of lastname + Unicode integer of last char of lastname) /4
Convert the integer “mid” to the lowercase character.

If the 1st char. of the last name is the same as the last char. of the lastname
int mid = (Unicode integer of 1st char of lastname + Unicode integer of last char of lastname) /3
Convert the integer “mid” to the lowercase character.

Hint: (int)(‘a’) should give you the integer representation of that character.
(char)(97) should give you the character representation of that integer
d) if the 2nd character is a numerical character (i.e. 0 to 9) AND is the same as the randomly generated digit (between 1 to 5 inclusive) in a), then the 2nd character is replaced with a zero, i.e. “0”.
if the 2nd character is NOT a numerical character or a letter of the alphabet (uppercase or lowercase), then replace the 2nd character with a zero, i.e. “0”.
e) combine with 1st character in part b) with the character created in part c) or d)
f) combine e) with the randomly generated digit (between 1 to 5 inclusive) you did in a)
Hint: See the Random class to see how to randomly generate numbers.
See the Character class to see how to test if a character is a digit or a letter.
You should call this method as soon as you have entered a lastname and then generate the password, before asking the user for the next lastname. DO NOT wait until you have entered ALL five names before generating the passwords.
The method should return back the password.

Things to Note:
 The program should be able to eliminate leading and trailing spaces (see “columbo” and “caine” entry below)
 It should also handle upper or lowercase and should convert all strings to lowercase.
 Feel free to write any additional methods as required (you may need one to search for duplicate passwords.)
 No need to worry about entering numbers. It will be sorted as a string
 Your program should exit on “0”.

Typical Screen Dialogue: *Image file attached as TypicalScreen*

When the program is first run, it will look similar to this: the various screen prompts like "YOUR NAME Password Generator", "Please enter 5 Lastnames", "Please enter lastname:" and "Please enter name to search (0 to exit):” are all displayed from main(..) rather than from the instance methods.

For example: 
IF lastname: "magnum" , as the 1st character is the same as the last character (both being “m”), then you use the second formula to create the character for the password.
i.e.:
As the integer representation of ‘m’ is 109, therefore
 (109 + 109 ) / 3 = 72 (there is NO rounding)
 The Unicode character of 72 is ‘H’ (uppercase)
 Finally you take the lowercase, which is ‘h’.
Thus, as shown above the password for magnum is mh2 (2 being randomly generated)

IF lastname “sahid” , as the first and last characters are different you use the first formula, i.e.:
 (115 + 100 ) / 4 = 53 (there is NO rounding)
 The Unicode character of 53 is ‘5’
However, in this case as the randomly generated digit apparently is also 5, which means you would have got s55, which is NOT allowed in criteria d), therefore it is replaced with 0.
Thus, as shown above the password for sahid is s05 (5 being randomly generated)

*More examples attached as image files: Example3, Example4, Example5, Example6*

Restrictions
 You cannot use ArrayList or Vectors.
 You cannot use any StringBuilder methods.
 You can use String methods like “toLowercase()”, “charAt()” ,”trim()” and the comparison methods.
 Use the “+” for your String concatenations
 You can use Character methods to test which character is a digit or letter.
 You cannot use any Java’s own built-in Array methods for searching or sorting.
