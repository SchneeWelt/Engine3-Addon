package tools.circle.ccircle;

import java.awt.Point;

import tools.circle.Circle;

/**
 * The collision Circle or CCircle can detect collision with another CCircle.
 * Once the CCircle found collision with another CCircle it is going to fire an
 * onCollision() event.
 */

public class CCircle extends Circle
{
	private OnCollision target = null;

	public CCircle(float x, float y, OnCollision onCollisionEventTarget)
	{
		super(x, y);
		setOnCollisionEventTarget(onCollisionEventTarget);
	}

	public CCircle(float x, float y, float r, OnCollision onCollisionEventTarget)
	{
		super(x, y, r);
		setOnCollisionEventTarget(onCollisionEventTarget);
	}

	/**
	 * A more complex algorithm than the isCollision() algorithm. First, the
	 * algorithm determine wether there is a collision between both objects. If so
	 * then the algorithm will fire the onCollision event. If not it will not be
	 * fired.
	 * 
	 * @param other
	 */

	public final void computeCollision(CCircle other)
	{
		if (isCollision(other))
			target.onCollision();
	}

	/**
	 * Use this method to manuel detect collision between two CCircles. Since this
	 * is a getter the onCollision event of the target will not be fired.
	 * 
	 * If you want that the onCollision() event is fired call computCollision()
	 * instead. If will first test for collision and if so than trigger the
	 * onCollision() event.
	 * 
	 * @param other
	 * @return true if there is a collision between both objects
	 */
	public final boolean isCollision(CCircle other)
	{
		int x = Math.round(this.x);
		int y = Math.round(this.y);
		int r = Math.round(this.r);
		
		int xo = Math.round(other.getX());
		int yo = Math.round(other.getY());
		int ro = Math.round(other.getR());
		
		int dist = (int) new Point(x, y).distance(new Point(xo, yo));
		int radia = r + ro;

		return (dist < radia);
	}

	private final void setOnCollisionEventTarget(OnCollision onCollisionEventTarget)
	{
		this.target = onCollisionEventTarget;
	}
}
