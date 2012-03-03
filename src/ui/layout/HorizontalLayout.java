package ui.layout;

import ui.activity.BaseActivity;
import ui.layout.calc.HorizontalLayoutCalc;
import ui.layout.calc.LayoutCalc;
import ui.wrapper.ContainerWrapper;
import ui.wrapper.Wrapper;

public class HorizontalLayout extends Layout {

	public HorizontalLayout(BaseActivity activity, Wrapper wrapper) {
		super(activity, wrapper);
	}
	
	@Override
	protected LayoutCalc createCalc(ContainerWrapper c, int width, int height) {
		return new HorizontalLayoutCalc(c, width, height);
	}

}
