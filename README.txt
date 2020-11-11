/////////////////////////////////////////////////////////////////////////////////////////////////////
!I worked on this solo, no other team members... I originally was in a group but decided to do the hw on my own!
Jonathan Wachholz
jhw190002
CS 4384.502

Instructions to TA for executing this code.
    This is basic java source code. Inserting these files into an Java IDE and running from main will work

    If you run the program by default then it will bring you into a loop that asks for the 2 different input file
        names / directories.

    If you run the program by passing command line arguments then you need to pass them so that the first arg is
        the PDA's description file (ex. input1.txt)
        And the second argument is the PDA's input file (ex. testInput1.txt)

    At anytime in the loop when it is asking for filenames, type in exit (ignores case) for either filename to
        exit the loop....

    Also to note... The original instructions (even after redownloading the pdf at 8Pm Nov 10th, still say that:
        "The output is a True if the PDA accepted the string (i.e. it ended in an accept state and the
         stack was empty)"

         However according to the professor in Discord he said:
            "Redownload the PDF
             [7:58 PM]
             I removed that last part the stack does not have to be empty"

         So my rules for accepting a string are that the current input string is empty, and we are at the final state

/////////////////////////////////////////////////////////////////////////////////////////////////////
File Descriptions for each file:

input1.txt
- This is the pda for the first test 

testInput1.txt
- The test file for input1.txt. The correct output for this file is:
	true    aabb
	true	aaaaaabbcccc
	false	aab
	false	bac
	true	aaaabbcc

	
The pda description for the first test is input1.txt and the test strings are in testInput1.txt 


input2.txt
- This is the pda for the second test

testInput2.txt
- The test file for input2.txt. The correct output for this file is:
	false
	true
	false
	true
	false
	
The pda description for the second test is input2.txt and the test strings are in testInput2.txt
	