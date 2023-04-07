package MarsRover;

import io.cucumber.java.en.*;

public class stepdefinition {

	
	public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    Integer facing = N;
    
    
   
    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
    }
    
    private void move() {
        if (facing == N) {
            this.y++;
        } else if (facing == E) {
            this.x++;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }
    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }
    
    
    private void turnRight() {
        facing = (facing  +1) > W ? N : facing  +1;
    }
    
	
    @Given("user sets position as {int}  {int} and {int}")
    public void user_sets_position_as_and(Integer x, Integer y, Integer facing) {
        
    	this.x = x;
        this.y = y;
        this.facing = facing;
    	
    	
    }
    
    
    @Given("enters the process as {string}")
    public void enters_the_process_as(String commands) {
       
    	 for (int idx = 0; idx < commands.length(); idx++ ) {
             process(commands.charAt(idx));
         }
    }
    
    
    @Then("the position is set")
    public void the_position_is_set() {
       
    	char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        System.out.println(x   +" " +  y  + " "  + dir);
    	
    }
}
