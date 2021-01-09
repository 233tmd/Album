package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * ËõÐ¡Í¼Æ¬µÄAction
 */
public class SmallAction implements Action {

	public void execute(ViewerService service, ViewerFrame frame) {
		service.zoom(frame, false);
	}

}
