# Generating-a-Word-Cloud-from-Text
This is a command line menu - driven Java application for creating a Word Cloud (in PNG format) from text, taken from a file or from URL

Details:
The application process txt files from File or URL and generates a word cloud, that contain the most common words in the text, but does not include word, that are part of ignorewords file.

How to work with the application:

When the program is started the menu shows four options:
1) Enter a file name or URL
2) Enter Maximum Words in The Cloud
3) Enter Output File Name
4) Quit

1. When user press 1 and "Enter", the program will displaythe following message: 
"Press F for reading a file or U for reading a URL:".
The program is case insensitive and the user can enter "f" or "u" and still will be continue working without a problem. 
If the user choose "F" or "f" the program will ask him to enter a file name.
If teh user choose "U" or "u" the program will ask him to enter a URL.
If the file/URL is entered incorectly or there is any other problem with it the program will show an error message.
If everything with the file/URL is OK, the program will show the following message:
"Enter Maximum Words in The Cloud:". After that the user should see another message:
"Enter Output File Name:". It is enough to type just the name, the program automatucaly appends ".png" extension. 
After that the user can find the output image (it is in the project directory).

Pressing 4 + "Enter" will terminate the program. A information message "Shutting down...Please wait.."  will appear.
