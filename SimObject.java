
public class SimObject {
	protected int x;
	protected int y;
	protected static PApplet processing;
	protected PImage img;
	protected boolean removeObject;
	
	public SimObject(String imagePath)
	{
		removeObject = false;
		try
		{
			if(processing == null)
			{
				throw new IllegalStateException("SimObject.setProcessing() must be called before constructing any SimObjects.");
			}
			else
			{
				img = processing.loadImage(imagePath);
				x = Utility.randomInt( processing.width );
				y = Utility.randomInt( processing.height );
			}
		}finally {
		}
	}
	public SimObject(String imagePath, int x, int y)
	{
		removeObject = false;
		try
		{
			if(processing == null)
			{
				throw new IllegalStateException("SimObject.setProcessing() must be called before constructing any SimObjects.");
			}
			else
			{
				img = processing.loadImage(imagePath);
				this.x = x;
				this.y = y;
			}
		}finally {
		}
	}
	
	
	// initialize the PApplet reference that is used by all SimObjects
	public static void setProcessing(PApplet processing)
	{
		SimObject.processing = processing;
	}
	
	public void update() {}
	
	public float distanceTo(int x, int y)
	{
		double deltaXSquared = Math.pow( ( x - this.x ), 2 );
		double deltaYSquared = Math.pow( ( y - this.y ), 2 );
		return new Float( Math.abs( Math.sqrt( deltaXSquared + deltaYSquared ) ) );
	}
	
	public void tryToInteract(SimObject other) {}
	
	public boolean shouldBeRemoved()
	{
		return removeObject;
	}

}