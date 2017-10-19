/**
 * This is a hook object.
 *
 *@author Nick Stoffel
 *@version 4.0
 *@since 2017-10-04
 */
public class Hook extends SimObject{
	
	/**
	 * Constructor that creates new Hook w/ random locations
	 * 
	 */
	public Hook()
	{
		super("images" + java.io.File.separator + "HOOK.png");
	}

	/**
	 * Constructor that creates new Hook w/ set locations
	 * 
	 * @param x
	 * @param y
	 */
	public Hook(int x, int y)
	{
		super("images" + java.io.File.separator + "HOOK.png", x, y);
	}

	/**
	 * Updates the location of the hook coordinates
	 * @Override
	 */
	public void update()
	{
		//If hook is not at the top of the screen, keep moving
		if( y > 0 )
		{
			y += -( processing.height + 50 - y ) / 50;
		}

		// If the hook is at the top of the screen, move it back to the bottom
		else
		{
			y = processing.height - 1;
		}

		processing.fill( 0 );
		processing.line( x+4, y-5, x+4, 0 );
		processing.image( img, x, y );
	}

	/**
	 * Moves hook x coordinate to the location of the click,
	 * and the y coordinate to the bottom of the applet
	 * 
	 * @param mouseX
	 * @param mouseY
	 */
	public void handleClick(int mouseX, int mouseY)
	{
		x = mouseX;
		y = processing.height-1;
	}

	/**
	 * Handles collisions b/w hook and fish
	 * 
	 * @param fish
	 * @Override
	 */
	public void tryToInteract(SimObject fish)
	{
		if(fish instanceof Fish)
		{
			if( fish.distanceTo( x, y ) < 40 )
				((Fish) fish).getCaught();
		}
	}
}