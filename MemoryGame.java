/**
* Project 3.1.5
*
* The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
* After wathcing the memory strings appear in the buttons one at a time, the
* player recreates the sequence from memory.
*/
public class MemoryGame1
{
 public static void main(String[] args) {


   // TO DO: Create the "memory strings" - an array of at least 4 single character
   // strings to show in the buttons, one element at a time. This is the sequence
   // the player will have to remember.
   String[] memoryStrings = {"A", "B", "C", "D", "E", "F"};


   // adjust settings
   int numButtons =4;              // changes num of buttons
   boolean randomizedBoard = true;  // random or non random version
   double delay = 0.5;              // speed
   int startSequenceLength = 4;     // length of sequence initially
   boolean increaseDifficulty = true; // if true, sequence length grows when you match


   // Create the game and gameboard. Configure a randomized board with 3 buttons.
   // (Later, you can change options to configure more or less buttons
   // and turn randomization on or off.))
   MemoryGameGUI game = new MemoryGameGUI();
   game.createBoard(numButtons, randomizedBoard);


   // TO DO: Play the game until user wants to quit.
   int score = 0;
   int rounds = 0;
   int seqLen = Math.min(startSequenceLength, memoryStrings.length);


   boolean play = true;
   while (play)
   {
     rounds++;
     // role switch #1


     // TO DO: Call the next method in RandomPermutation to create a random version
     // of the "memory strings"
     String[] shuffled = RandomPermutation.next(memoryStrings);


     // Build a sequence of the desired length (lets you demonstrate varied lengths)
     String[] randomSeq = new String[seqLen];
     for (int i = 0; i < seqLen; i++)
     {
       randomSeq[i] = shuffled[i];
     }
    // role switch #2


     // TO DO: Play one sequence with a .5 second delay. Save the player's guess.
     // (Later, you can speed up or slow down the game.)
     String guess = game.playSequence(randomSeq, delay);


     // TO DO: If the guess is not null, determine a match
     if (guess == null)
     {
       // user click cancel on input screen
       break;
     }


     // TO DO: Cleanup the guess - repalce commas and spaces with the empty string.
     // Refer to a new String method replace.
     guess = guess.replace(",", "").replace(" ", "").trim();


     // Build the correct answer string from the sequence shown
     String correct = "";
     for (int i = 0; i < randomSeq.length; i++)
     {
       correct += randomSeq[i];
     }


     // role switch #3


     // TO DO: Iterate to determine if all elements of the guess match sequence
     boolean matched = true;


     // handles: no input + longer/shorter input 
     if (guess.length() != correct.length())
     {
       matched = false;
     }
     else
     {
       for (int i = 0; i < correct.length(); i++)
       {
         if (guess.charAt(i) != correct.charAt(i))
         {
           matched = false;
           break;
         }
       }
     }


     // If match, signal a match, otherwise, try again
     if (matched)
     {
       game.matched();
       // increase score
       score++;


       // optional: increase difficulty which is varied length 
       if (increaseDifficulty && seqLen < memoryStrings.length)
       {
         seqLen++;
       }
     }
     else
     {
       game.tryAgain();
     }



