
public class Hook {
	private PApplet processing;
	PImage img;
	private int x, y;
	
	public Hook(PApplet processing)
	{
		this.processing = processing;
		img = processing.loadImage( "images" + java.io.File.separator + "HOOK.png" );
		x = Utility.randomInt( processing.width );
		y = Utility.randomInt( processing.height );
	}
	public Hook(PApplet processing, int x, int y)
	{
		this.processing = processing;
		img = processing.loadImage( "images" + java.io.File.separator + "HOOK.png" );
		this.x = x;
		this.y = y;
	}
	
	public void update()
	{
		if( y > 0 )
		{
			y += -( processing.height + 50 - y ) / 50;
		}
		else
		{
			y = processing.height - 1;
		}
		
		processing.fill( 0 );
		processing.line( x+4, y-5, x+4, 0 );
		processing.image( img, x, y );
	}
	
	public void handleClick(int mouseX, int mouseY)
	{
		x = mouseX;
		y = processing.height-1;
	}
	
	public void tryToCatch(Fish fish)
	{
		if( fish.distanceTo( x, y ) < 40 )
			fish.getCaught();
	}
}
