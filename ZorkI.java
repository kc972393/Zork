import java.io.*;
import java.util.Scanner;

public class Main{

    static int moves = 0;
    static int backpack = 0;
    static int tresure = 0;
    static int weapons = 0;
    static int lives = 3;
    
    //has key
    static boolean hasLobbyKey = false;
    static boolean hasMainKey = false;
    static boolean hasOfficeKey = false;
    static boolean hasMeds = false;
    static boolean hasWeapon = false;

    static void Lobby(){
        Scanner scnr = new Scanner(System.in);
        String prompt;
        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        //in room
        boolean inLobby = false;
        inLobby = true;
        //prompt
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        while(inLobby){
            prompt = prompt.toLowerCase();
            // Directions
            indexGo = prompt.contains("go");
            indexExamine = prompt.contains("examine");
            if(indexGo | indexExamine){
                //plant
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("plant");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is nothing in the plant except for dirt.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                //pic
                indexDirection = prompt.contains("west");
                indexObject = prompt.contains("poster");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The poster has a picture of a dinosaur.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                //desk
                indexDirection = prompt.contains("southwest");
                indexObject = prompt.contains("desk");
                if((indexDirection | indexObject) & !hasLobbyKey){
                    System.out.println("Moves:" + moves);
                    System.out.println("The desk has a key on the desk.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //Take key
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("key");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the key.");
                        backpack++;
                        hasLobbyKey = true;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
                //has key already
                indexDirection = prompt.contains("southwest");
                indexObject = prompt.contains("desk");
                if((indexDirection | indexObject) & hasLobbyKey){
                    System.out.println("Moves:" + moves);
                    System.out.println("There doesn't seem to be anything else that is important about the desk.");
                    moves++;
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                }
                //door
                indexDirection = prompt.contains("south");
                indexObject = prompt.contains("door");
                if((indexDirection | indexObject) & !hasLobbyKey){
                    System.out.println("Moves:" + moves);
                    System.out.println("The door is locked.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                indexOpen = prompt.contains("open");
                indexObject = prompt.contains("door");
                if((indexOpen & indexObject) & hasLobbyKey){
                    System.out.println("Moves:" + moves);
                    System.out.println("Door unlocked. Entering Main Gallery.");
                    backpack--;
                    MainGallery();
                }
            }
            else{
                System.out.println("Moves:" + moves);
                System.out.print("< ");
                prompt = scnr.nextLine();
                moves++;
            }
        }
    }

    static void MainGallery(){
        hasLobbyKey = true;
        Scanner scnr = new Scanner(System.in);
        String prompt;
        boolean inMain = false;
        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        inMain = true;
        //has key or mdes
        boolean hasMainKey = false;
        boolean hasMeds = false;
        //prompt
        System.out.println("Main Gallery:");
        System.out.println("Moves: " + moves);
        System.out.println("To the east there is a large dinosaur skeleton, in the south there is an information booth, and there are 6 doors.");
        System.out.println("The doors are labeled: Lobby, Ancient Artifacts, Aquarium, Art Gallery, Office, and Egyptian Exhibit");
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        while (inMain){
            prompt = prompt.toLowerCase();
            // Directions
            indexGo = prompt.contains("go");
            indexExamine = prompt.contains("examine");
            if(indexGo | indexExamine){
                //dino
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("dinosaur");
                if((indexDirection | indexObject) & !hasMainKey){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is a key in the dinosaur's mouth.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get key
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("key");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the key.");
                        hasMainKey = true;
                        backpack++;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
                //has key already
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("dinosaur");
                if((indexDirection | indexObject) & hasMainKey){
                    System.out.println("Moves:" + moves);
                    System.out.println("There doesn't seem to be anything else that is important about the dinosaur.");
                    moves++;
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                }
                //info booth
                indexDirection = prompt.contains("south");
                indexObject = prompt.contains("booth");
                if((indexDirection | indexObject) & !hasMeds){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is some medicine in the booth.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get medicine
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("medicine");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the medicine.");
                        hasMeds = true;
                        backpack++;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
                //has meds already
                indexDirection = prompt.contains("south");
                indexObject = prompt.contains("booth");
                if((indexDirection | indexObject) & hasMeds){
                    System.out.println("Moves:" + moves);
                    System.out.println("There doesn't seem to be anything else that is important about the information booth.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
            }
            //open lobby door
            indexOpen = prompt.contains("open");
            if(indexOpen){
                indexDoor = prompt.contains("lobby");
                if(indexDoor){
                    hasLobbyKey = true;
                    System.out.println("Entering Lobby:");
                    System.out.println("Moves: " + moves);
                    System.out.println("There is a poster to the west, a desk to the southwest, and a plant to the east.");
                    System.out.println("There is a door in the south.");
                    Lobby();
                }
            }
            //open art gallery door
	        indexOpen = prompt.contains ("open");
        	if (indexOpen)
	        {
	            indexDoor = prompt.contains ("gallery");
	            if (indexDoor)
	            {
		            System.out.println ("Entering Art Gallery:");
		            ArtGallery ();
                }
            }
            //open Egyption Exhibit door
	        indexOpen = prompt.contains ("open");
        	if (indexOpen)
	        {
	            indexDoor = prompt.contains ("egypt");
	            if (indexDoor)
	            {
		            System.out.println ("Entering Egyptian Exhibit:");
		            Egyptian();
                }
            }
            //open Aquarium door
	        indexOpen = prompt.contains ("open");
        	if (indexOpen)
	        {
	            indexDoor = prompt.contains ("aquarium");
	            if (indexDoor)
	            {
		            System.out.println ("Entering Aquarium:");
		            Aquarium();
                }
            }
            //open office door
            indexOpen = prompt.contains ("open");
        	if (indexOpen)
	        {
	            indexDoor = prompt.contains ("office");
	            if (indexDoor)
	            {
		            if(hasMainKey){
		                System.out.println ("Entering Office:");
                        Office();
                    }
                    else{
                        System.out.println("The Office is locked.");
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
            }
            //open artifacts door
            indexOpen = prompt.contains ("open");
        	if (indexOpen)
	        {
	            indexDoor = prompt.contains ("ancient");
	            if (indexDoor)
	            {
		            if(hasOfficeKey){
		                System.out.println ("Entering Ancient Artifacts Exhibit:");
                        Artifacts();
                    }
                    else{
                        System.out.println("The Exhibit is locked.");
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
            }
        }
	}

    static void ArtGallery(){
        hasLobbyKey = true;
        hasMainKey = true;
        Scanner scnr = new Scanner (System.in);
        String prompt;
        boolean inArt = false;

        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        inArt = true;

        System.out.println ("Art Gallery:");
        System.out.println ("Moves: " + moves);
        System.out.println("To the east there is a wall of art and to the south there is a case.");
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        label:
        while(inArt){
            prompt = prompt.toLowerCase();
            // Directions
            indexGo = prompt.contains("go");
            indexExamine = prompt.contains("examine");
            indexOpen = prompt.contains("open");
            if(indexGo | indexExamine | indexOpen){
                //wall of art
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("wall");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The wall of art does not have anything important.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                //case
                indexDirection = prompt.contains("south");
                indexObject = prompt.contains("case");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is a tresure in the case.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get tresure
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("tresure");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the tresure.");
                        tresure++;
                        if(tresure == 3){
                            System.out.println("Congradulations. You won!");
                            break label;
                        }
                        backpack++;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
            }
            //open door
            indexOpen = prompt.contains ("open");
            if (indexOpen)
            {
                indexDoor = prompt.contains ("door");
                if (indexDoor)
                {
                    System.out.println ("Entering Main Gallery:");
                    MainGallery();
                }
            }
        }
        System.exit(0);
    }

    static void Office(){
        hasLobbyKey = true;
        hasMainKey = true;
        Scanner scnr = new Scanner (System.in);
        String prompt;
        boolean inOffice = false;

        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        inOffice = true;

        System.out.println ("Office:");
        System.out.println ("Moves: " + moves);
        System.out.println("To the east there is a safe, to the south there is a desk, to the west there is an aquarium, and to the north there is a mini fridge.");
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        while(inOffice){
            prompt = prompt.toLowerCase();
            // Directions
            indexGo = prompt.contains("go");
            indexExamine = prompt.contains("examine");
            indexOpen = prompt.contains("open");
            if(indexGo | indexExamine | indexOpen){
                //safe
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("safe");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is a knife and a key in the safe.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    // get weapon
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("knife");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the knife.");
                        backpack++;
                        weapons++;
                        hasWeapon = true;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                    //get key
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("key");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the key.");
                        backpack++;
                        hasOfficeKey = true;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
                //desk
                indexDirection = prompt.contains("south");
                indexObject = prompt.contains("desk");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The desk doesn't have anything useful on it.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                //aquarium
                indexDirection = prompt.contains("west");
                indexObject = prompt.contains("aquarium");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The aquarium looks pretty, but isn't important.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                // fridge
                indexDirection = prompt.contains("north");
                indexObject = prompt.contains("fridge");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The fridge has food and drinks.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get food and drinks
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("food and drink");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the food and drinks.");
                        backpack++;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
                
            }
            //open door
            indexOpen = prompt.contains ("open");
            if (indexOpen)
            {
                indexDoor = prompt.contains ("door");
                if (indexDoor)
                {
                    System.out.println ("Entering Main Gallery:");
                    MainGallery();
                }
            }
        }
    }

    static void Artifacts(){
        hasLobbyKey = true;
        hasMainKey = true;
        hasOfficeKey = true;
        Scanner scnr = new Scanner (System.in);
        String prompt;
        boolean inAncient = false;

        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        inAncient = true;

        System.out.println ("Ancient Artifacts Exhibit:");
        System.out.println ("Moves: " + moves);
        System.out.println("To the north there is a wall of weapons, to the east there is jewelry, and to the west there is pottery.");
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        label:
        while(inAncient){
            prompt = prompt.toLowerCase();
            // Directions
            indexGo = prompt.contains("go");
            indexExamine = prompt.contains("examine");
            indexOpen = prompt.contains("open");
            if(indexGo | indexExamine | indexOpen){
                //wall of weapons
                indexDirection = prompt.contains("north");
                indexObject = prompt.contains("weapons");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The weapons look sharp.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get tresure
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("weapon");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the weapon.");
                        weapons++;
                        backpack++;
                        hasWeapon = true;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
                //pottery
                indexDirection = prompt.contains("west");
                indexObject = prompt.contains("pottery");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The pottery looks really old.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                // jewelry
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("jewelry");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is a tresure in the jewelry case.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get tresure
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("tresure");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the tresure.");
                        tresure++;
                        if(tresure == 3){
                            System.out.println("Congradulations. You won!");
                            break label;
                        }
                        backpack++;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
            }
            //open door
            indexOpen = prompt.contains ("open");
            if (indexOpen)
            {
                indexDoor = prompt.contains ("door");
                if (indexDoor)
                {
                    System.out.println ("Entering Main Gallery:");
                    MainGallery();
                }
            }
        }
        System.exit(0);
    }

    static void Egyptian(){
        hasLobbyKey = true;
        hasMainKey = true;
        hasOfficeKey = true;
        Scanner scnr = new Scanner (System.in);
        String prompt;
        boolean inEgypt = false;

        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        boolean indexKill = false;
        boolean monsterDead = false;
        inEgypt = true;

        System.out.println ("Egyptian Exhibit:");
        System.out.println ("Moves: " + moves);
        System.out.println("To the east there are some artifacts, to the west there are some statues, and there is also a mummy.");
        if(!monsterDead){
        System.out.println("The mummy is a monster! You need a weapon to kill it!");
        }
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        label:
        while(inEgypt){
            System.out.println("Lives: " + lives);
            prompt = prompt.toLowerCase();
            //open door
            indexOpen = prompt.contains ("open");
            if (indexOpen)
            {
                indexDoor = prompt.contains ("door");
                if (indexDoor)
                {
                    lives--;
                    if(lives == 0){
                        System.out.println("You died. Try again.");
                        break label;
                    }
                    System.out.println ("Entering Main Gallery:");
                    MainGallery();
                }
            }
            //kill monster
            indexKill = prompt.contains ("kill");
            if (indexKill)
            {
                if (hasWeapon)
                {
                    System.out.println ("You killed the monster!");
                    monsterDead = true;
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    weapons--;
                    if(weapons == 0){
                        hasWeapon = false;
                    }
                    moves++;
                }
                else{
                    System.out.println("You need a weapon!");
                    lives--;
                    if(lives == 0){
                        System.out.println("You died. Try again.");
                        break label;
                    }
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
            }
            //examine
            if(monsterDead){
                indexDirection = prompt.contains("west");
                indexObject = prompt.contains("statue");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The satues are of Egyptian Gods and guards.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("artifact");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("There is a tresure.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                    //get tresure
                    indexTake = prompt.contains("take");
                    indexPickUp = prompt.contains("pick up");
                    indexKey = prompt.contains("tresure");
                    if((indexTake | indexPickUp) & indexKey){
                        System.out.println("Moves:" + moves);
                        System.out.println("You took the tresure.");
                        tresure++;
                        if(tresure == 3){
                            System.out.println("Congradulations. You won!");
                            break label;
                        }
                        backpack++;
                        System.out.print("< ");
                        prompt = scnr.nextLine();
                        moves++;
                    }
                }
            }
            else{
                System.out.println("You need to defeat the monster first!");
                lives--;
                if(lives == 0){
                    System.out.println("You died. Try again.");
                    break label;
                }
                System.out.print("< ");
                prompt = scnr.nextLine();
                moves++;
            }
        }
        System.exit(0);
    }

    static void Aquarium(){
        Scanner scnr = new Scanner (System.in);
        String prompt;
        boolean inAqua = false;

        //commands
        boolean indexGo = false;
        boolean indexDirection = false;
        boolean indexObject = false;
        boolean indexExamine = false;
        boolean indexTake = false;
        boolean indexPickUp = false;
        boolean indexKey = false;
        boolean indexOpen = false;
        boolean indexDoor = false;
        boolean indexKill = false;
        boolean monsterDead = false;
        inAqua = true;

        System.out.println ("Aquarium:");
        System.out.println ("Moves: " + moves);
        System.out.println("In the middle of the room there is a touch table, to the north there are Jellyfish, to the east there are fish, and to the west there are seahorses");
        if(!monsterDead){
        System.out.println("The octopus is a monster! You need a weapon to kill it!");
        }
        System.out.print("< ");
        prompt = scnr.nextLine();
        moves++;
        label:
        while(inAqua){
            prompt = prompt.toLowerCase();
            //open door
            indexOpen = prompt.contains ("open");
            if (indexOpen)
            {
                indexDoor = prompt.contains ("door");
                if (indexDoor)
                {
                    if(!monsterDead){
                        lives--;
                    }
                    if(lives == 0){
                        System.out.println("You died. Try again.");
                        break label;
                    }
                    System.out.println ("Entering Main Gallery:");
                    MainGallery();
                }
            }
            //kill monster
            indexKill = prompt.contains ("kill");
            if (indexKill)
            {
                if (hasWeapon)
                {
                    System.out.println ("You killed the monster!");
                    monsterDead = true;
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    weapons--;
                    if(weapons == 0){
                        hasWeapon = false;
                    }
                    moves++;
                }
                else{
                    System.out.println("You need a weapon!");
                    lives--;
                    if(lives == 0){
                        System.out.println("You died. Try again.");
                        break label;
                    }
                    System.out.println("Lives: " + lives);
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
            }
            //examine
            if(monsterDead){
                indexDirection = prompt.contains("west");
                indexObject = prompt.contains("seahorse");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The seahorses have camouflage.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                indexDirection = prompt.contains("east");
                indexObject = prompt.contains("fish");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("There are many different types of fish.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
                indexDirection = prompt.contains("north");
                indexObject = prompt.contains("jelly");
                if(indexDirection | indexObject){
                    System.out.println("Moves:" + moves);
                    System.out.println("The jellyfish look squishy.");
                    System.out.print("< ");
                    prompt = scnr.nextLine();
                    moves++;
                }
            }
            else{
                System.out.println("You need to defeat the monster first!");
                lives--;
                if(lives == 0){
                    System.out.println("You died. Try again.");
                    break label;
                }
                System.out.println("Lives: " + lives);
                System.out.print("< ");
                prompt = scnr.nextLine();
                moves++;
            }
        }
        System.exit(0);
    }

    public static void main(String[] args){
        System.out.println("Welcome to the Museum.");
        System.out.println("Moves: 0");
        System.out.println("Lobby:");
        System.out.println("There is a poster to the west, a desk to the southwest, and a plant to the east.");
        System.out.println("There is a door in the south labeled Main Gallery.");
        Lobby();
    }
}