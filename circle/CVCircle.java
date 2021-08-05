package tools.circle;

import java.awt.Color;
import java.awt.Graphics2D;

import in.Draw;
import tools.circle.ccircle.CCircle;
import tools.circle.ccircle.OnCollision;

/**
 * The CollisionVisibleCircle or CVCircle is a collision circle which can be
 * displayed on screen. I feel like it should be more easy to work with
 * something that can actually be seen on display. To display the circle just
 * call its draw() method.
 */

public class CVCircle extends CCircle implements Draw
{
	private boolean drawOutline = false;

	private Color outlineColor = Color.orange;

	public CVCircle(float x, float y, OnCollision onCollisionEventTarget)
	{
		super(x, y, onCollisionEventTarget);
	}

	public CVCircle(float x, float y, float r, OnCollision onCollisionEventTarget)
	{
		super(x, y, r, onCollisionEventTarget);
	}

	public CVCircle(float x, float y, float r, OnCollision onCollisionEventTarget, Color outlineColor)
	{
		super(x, y, r, onCollisionEventTarget);
		setOutlineColor(outlineColor);
	}

	@Override
	public void draw(Graphics2D graphics)
	{
		if (isDrawOutline())
			displayCircle(graphics);
	}

	/**
	 * displays an circle which center point is located at x and y
	 * 
	 * @param graphics
	 */

	private final void displayCircle(Graphics2D graphics)
	{
		graphics.setColor(outlineColor);
		
		int x = Math.round(this.x);
		int y = Math.round(this.y);
		int r = Math.round(this.r);
		
		graphics.drawOval(x - r, y - r, r * 2, r * 2);
	}

	private final void setOutlineColor(Color outlineColor)
	{
		this.outlineColor = outlineColor;
	}

	public final void setDrawOutline(boolean drawOutline)
	{
		this.drawOutline = drawOutline;
	}

	private final boolean isDrawOutline()
	{
		return drawOutline;
	}
}
