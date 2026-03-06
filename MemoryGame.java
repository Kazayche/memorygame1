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
