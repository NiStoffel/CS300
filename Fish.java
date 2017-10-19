/**
 * This is a fish object.
 *
 *@author Nick Stoffel
 *@version 4.0
 *@since 2017-10-04
 */
public class Fish extends SimObject{

	/**
	 * Default constructor that creates a new fish w/ random locations
	 * 
	 */
	public Fish()
	{
		super("images" + java.io.File.separator + "FISH.png");
	}

	/**
	 * Constructor that creates a new fish w/ set locations
	 * 
	 * @param x
	 * @param y
	 */
	public Fish(int x, int y)
	{
		super("images" + java.io.File.separator + "FISH.png", x, y);
	}

	/**
	 * Updates location of the fish
	 * @Override
	 */
	public void update()
	{
		//If fish is not on the right edge of the screen, move it one unit to the right
		if(x < processing.width-1)
		{
			x += 1;
		}

		//If fish is on the right edge of the screen,  move it to the left edge
		else
		{
			x = 0;
		}

		processing.image( img, x, y );
	}

	/**
	 * Method that detects collision b/w food and fish
	 * 
	 * @param food
	 * @Override
	 */
	public void tryToInteract(SimObject food)
	{
		if(food instanceof Food)
		{
			if( food.distanceTo( x, y ) < 40 )
				((Food) food).getEaten();
		}
	}

	/**
	 * If the fish is caught by the hook, move the fish to a random y position
	 * and to the left edge of the screen
	 */
	public void getCaught()
	{
		x = 0;
		y = Utility.randomInt( processing.height );
	}

}