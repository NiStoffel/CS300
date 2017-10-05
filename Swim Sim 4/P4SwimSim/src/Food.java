
public class Food {
	private PApplet processing;
	PImage img;
	private int x, y;
	
	public Food(PApplet processing)
	{
		this.processing = processing;
		img = processing.loadImage( "images" + java.io.File.separator + "FOOD.png" );
		x = Utility.randomInt( processing.width );
		y = Utility.randomInt( processing.height );
	}
	
	public Food(PApplet processing, int x, int y)
	{
		this.processing = processing;
		img = processing.loadImage( "images" + java.io.File.separator + "FOOD.png" );
		this.x = x;
		this.y = y;
	}
	
	public void update()
	{
		if( x > 0 )
		{
			x -= 1;
		}
		else
		{
			x = processing.width - 1;
		}
		
		if( y < processing.height-1 )
		{
			y += 1;
		}
		else
		{
			y = 0;
		}
		
		processing.image(img,x,y);
	}
	
	public float distanceTo(int x, int y) // returns the distance from this food to position x, y
	{
		double deltaXSquared = Math.pow( ( x - this.x ), 2 );
		double deltaYSquared = Math.pow( ( y - this.y ), 2 );
		return new Float( Math.abs( Math.sqrt( deltaXSquared + deltaYSquared ) ) );
	}
	
	public void getEaten() // moves this food to a random position at the top of the screen
	{
		x = Utility.randomInt( processing.width );
		y = processing.height-1;
	}
}
