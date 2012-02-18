package ui.layout.calc;

import java.util.ArrayList;

import ui.view.wrapper.ViewWrapper;
import android.widget.FrameLayout.LayoutParams;

public class HorizontalLayoutCalc extends LayoutCalc {

	public HorizontalLayoutCalc(ArrayList<ViewWrapper> controls, int parentWidth, int parentHeight) {
		super(controls, parentWidth, parentHeight);
	}
	
	public void layoutControls() {
		applyLayoutParams();
		applySpacing();
	}
	
	/*
	 * Apply the horizontal and vertical spacing to controls
	 */
	protected void applySpacing() {
		int horizontalMargin = 0;
		for(ViewWrapper control : controls){
			int width = getMeasuredWidth(control);
			int marginLeft = control.getMarginLeft();
			int marginRight = control.getMarginRight();
			int space = parentWidth - width - marginLeft - marginRight;
        	horizontalMargin += calculateLeftSpacing(control, space);
        	control.getView().setTranslationX(horizontalMargin);
        	horizontalMargin += calculateRightSpacing(control, space) + width;
        	control.getView().setTranslationY(control.getMarginTop());
		}
	}
	
	protected int calculateLeftSpacing(ViewWrapper c, int space) {
		int marginLeft = c.getMarginLeft();
		
		/*switch(c.getControlConfig().getScreenAlignment()){
		case LEFT: return marginLeft;
		case CENTER: return (space /2);
		case RIGHT: return marginLeft + (space /2);
		}
		return 0;*/
		return marginLeft;
	}
	
	protected int calculateRightSpacing(ViewWrapper c, int space) {
		int marginRight = c.getMarginRight();
		
		/*switch(c.getControlConfig().getScreenAlignment()){
		case RIGHT: return marginRight;
		case CENTER: return (space /2);
		case LEFT: return marginRight + (space /2);
		}
		return 0;*/
		return marginRight;
	}
	
	/*
	 * Apply LayoutParams to each control
	 */
	protected void applyLayoutParams() {
		for(ViewWrapper control : controls){
			control.getView().setLayoutParams(new LayoutParams(getMeasuredWidth(control), getMeasuredHeight(control)));
		}	
	}

}