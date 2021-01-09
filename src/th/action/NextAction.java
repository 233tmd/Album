package th.action;


import th.component.ViewerFrame;
import th.component.ViewerService;

/**
 * 下一张图片的Action
 */
public class NextAction implements Action {

	@Override
	public void execute(ViewerService service, ViewerFrame frame) {
		service.next(frame);
	}

}
