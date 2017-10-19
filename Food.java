/**
 * This is a food object.
 *
 *@author Nick Stoffel
 *@version 4.0
 *@since 2017-10-04
 */
public class Food extends SimObject{

	/**
	 * Constructor that creates a new food w/ random locations
	 * 
	 */
	public Food()
	{
		super("images" + java.io.File.separator + "FOOD.png");
	}

	/**
	 * Constructor that creates a new food w/ set locations
	 * 
	 * @param x
	 * @param y
	 */
	public Food(int x, int y)
	{
		super("images" + java.io.File.separator + "FOOD.png", x, y);
	}

	/**
	 * Changes the location of the food
	 * @Override
	 */
	public void update()
	{
		// If food is not on the left edge of the screen, move one to the left
		if( x > 0 )
		{
			x -= 1;
		}

		// If food is on the left edge of the screen, move it to the right edge
		else
		{
			x = processing.width - 1;
		}

		// If food is not on the bottom of the screen, move it one down
		if( y < processing.height-1 )
		{
			y += 1;
		}

		// If food is on the bottom of the screen, move it to the top of the screen
		else
		{
			y = 0;
		}

		processing.image(img,x,y);
	}

	/**
	 * If the food collides with a fish, set the food x coordinate to a random position
	 * and move the food to the top of the screen
	 */
	public void getEaten() 
	{
		removeObject = true;
	}
}