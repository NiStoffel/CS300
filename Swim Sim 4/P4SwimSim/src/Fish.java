
public class Fish {
	private PApplet processing;
	PImage img;
	private int x, y;
	
	public Fish(PApplet processing)
	{
		this.processing = processing;
		img = processing.loadImage( "images" + java.io.File.separator + "FISH.png" );
		x = Utility.randomInt( processing.width );
		y = Utility.randomInt( processing.height );
	}
	
	public Fish(PApplet processing, int x, int y)
	{
		this.processing = processing;
		img = processing.loadImage( "images" + java.io.File.separator + "FISH.png" );
		this.x = x;
		this.y = y;
	}
	
	public void update()
	{
		if(x < processing.width-1)
		{
			x += 1;
		}
		else
		{
			x = 0;
		}
		
		processing.image( img, x, y );
	}
	
	public void tryToEat(Food food)
	{
		if( food.distanceTo( x, y ) < 40 )
			food.getEaten();
	}
	
	public float distanceTo(int x, int y) // returns the distance from this fish to position x, y
	{
		double deltaXSquared = Math.pow( ( x - this.x ), 2 );
		double deltaYSquared = Math.pow( ( y - this.y ), 2 );
		return new Float( Math.abs( Math.sqrt( deltaXSquared + deltaYSquared ) ) );
	}
	public void getCaught() // moves this fish to a random position along the left edge of the screen
	{
		x = 0;
		y = Utility.randomInt( processing.height );
	}

}
