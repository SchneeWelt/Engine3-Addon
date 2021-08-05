package tools.circle;

import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;

/**
 * The VCircle or VisibleCircle is as its super class also a container for
 * values. However, the VCircle can also be rendered on screen. To render the
 * latest version of the circle simply call the draw() method.
 *
 * A VCircle has its own color value. The default value is Color.orange. There
 * are serveral constructors to change the color on init.
 * 
 * There is a displayState. The display state can be choosen in the constructor.
 * Fill means draw whole circle, outline means only draw the outline of the
 * circle.
 */

public class VCircle extends Circle implements Draw
{
	private int displayState = 0;
	public static final int DISPLAY_STATE_FILL = 0;
	public static final int DISPLAY_STATE_OUTLINE = 1;

	private Color color = Color.orange;

	public VCircle(float x, float y)
	{
		super(x, y);
	}

	public VCircle(float x, float y, float r)
	{
		super(x, y, r);
	}

	public VCircle(float x, float y, float r, Color color)
	{
		super(x, y, r);
		setColor(color);
	}

	public VCircle(float x, float y, float r, int DISPLAY_STATE)
	{
		super(x, y, r);
		setDisplayState(DISPLAY_STATE);
	}

	public VCircle(float x, float y, float r, int DISPLAY_STATE, Color color)
	{
		super(x, y, r);
		setColor(color);
		setDisplayState(DISPLAY_STATE);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		graphics.setColor(color);

//		switch(displayState)
//		{
//			case DISPLAY_STATE_FILL -> fillCircle(graphics);
//			case DISPLAY_STATE_OUTLINE -> outlineCircle(graphics);
//		}

		if (displayState == DISPLAY_STATE_FILL)
			fillCircle(graphics);
		else if (displayState == DISPLAY_STATE_OUTLINE)
			outlineCircle(graphics);
	}

	/*
	 * based on the x, y and r values this method draws a centered circle on screen.
	 */

	private final void outlineCircle(Graphics2D graphics)
	{
		int x = Math.round(this.x);
		int y = Math.round(this.y);
		int r = Math.round(this.r);

		graphics.drawOval(x - r, y - r, r * 2, r * 2);
	}

	/*
	 * based on the x, y and r values this method fills a centered circle on screen.
	 */

	private final void fillCircle(Graphics2D graphics)
	{
		int x = Math.round(this.x);
		int y = Math.round(this.y);
		int r = Math.round(this.r);

		graphics.fillOval(x - r, y - r, r * 2, r * 2);
	}

	public final Color getColor()
	{
		return color;
	}

	public final void setColor(Color color)
	{
		this.color = color;
	}

	private final void setDisplayState(int displayState)
	{
		this.displayState = displayState;
	}
}
